package by.training.photographer.action;

import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.entity.LocalizedTextEntity;
import by.training.photographer.entity.PhotoCategoryEntity;
import by.training.photographer.entity.PhotoEntity;
import by.training.photographer.exception.PersistenceException;
import by.training.photographer.service.AlbumService;
import by.training.photographer.service.LocalizedTextService;
import by.training.photographer.service.PhotoService;
import by.training.photographer.service.factory.ServiceFactory;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminAlbumAddAction extends Action {
    private final Logger logger = LogManager.getLogger(getClass());

    public AdminAlbumAddAction(final ServiceFactory serviceFactory) {
        super(serviceFactory);
    }

    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException, PersistenceException, FileUploadException {
        AlbumService albumService = getServiceFactory().createAlbumService();
        LocalizedTextService textService = getServiceFactory().createLocalizedTextService();
        PhotoService photoService = getServiceFactory().createPhotoService();

        AlbumEntity album = new AlbumEntity();

        if (!ServletFileUpload.isMultipartContent(request)) {
            logger.debug("Not a file upload request");
            throw new IllegalArgumentException();
        }

        String name;
        String description;
        String categoryId;
        String coverPath;
        List<String> photoPaths = new ArrayList<>();

        ServletFileUpload upload = new ServletFileUpload();

        FileItemIterator iter = upload.getItemIterator(request);

        while (iter.hasNext()) {
            FileItemStream item = iter.next();

            if (item.isFormField()) {
                String inputName = item.getFieldName();
                if ("name".equals(inputName)) {
                    name = Streams.asString(item.openStream());
                    LocalizedTextEntity nameEntity = new LocalizedTextEntity(name);
                    nameEntity.setId(textService.create(nameEntity));
                    album.setNameEntity(nameEntity);
                }
                if ("description".equals(inputName)) {
                    description = Streams.asString(item.openStream());
                    LocalizedTextEntity descriptionEntity = new LocalizedTextEntity(description);
                    descriptionEntity.setId(textService.create(descriptionEntity));
                    album.setDescriptionEntity(descriptionEntity);
                }
                if ("category".equals(inputName)) {
                    categoryId = Streams.asString(item.openStream());
                    PhotoCategoryEntity category = new PhotoCategoryEntity(Integer.valueOf(categoryId));
                    album.setPhotoCategory(category);
                }
            } else {
                try {
                    String contentType = item.getContentType();
                    if (!contentType.equals("image/png") && !contentType.equals("image/jpg") && !contentType.equals("image/jpeg")) {
                        logger.debug("only png, jpg, jpeg formats image files supported");
                        continue;
                    }

                    File uploadDir = new File(File.separator
                                              + "Users"
                                              + File.separator
                                              + "alex"
                                              + File.separator
                                              + "imgData");
                    File file = File.createTempFile("img", ".jpg", uploadDir);

                    if ("photos".equals(item.getFieldName())) {
                        photoPaths.add(file.getName());
                    }
                    if ("cover".equals(item.getFieldName())) {
                        coverPath = file.getName();
                        album.setCoverImagePath(coverPath);
                    }
                    FileOutputStream fos = new FileOutputStream(file);
                    Streams.copy(item.openStream(), fos, true);

                    logger.debug("File " + file.getPath() + " Saved Successfully");
                } catch (Exception ex) {
                    logger.error("can't save",ex);
                }
            }
        }

        album.setId(albumService.create(album));

        if (!photoPaths.isEmpty()) {
            List<PhotoEntity> photoList = new ArrayList<>();
            for (String path : photoPaths) {
                PhotoEntity photo = new PhotoEntity(path, album, null);
                photo.setId(photoService.create(photo));
                photoList.add(photo);
            }

            album.setPhotoList(photoList);
        }

        redirectToSuccessPage(response);
    }

    @Override
    public String getSuccessResponsePageName() {
        return "/photographer/admin/album";
    }
}
