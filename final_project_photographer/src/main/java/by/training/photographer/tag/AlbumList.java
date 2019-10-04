package by.training.photographer.tag;

import by.training.photographer.entity.AlbumEntity;

import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

public class AlbumList {
    private List<AlbumEntity> albums;
    private Iterator<AlbumEntity> it;

    public AlbumList(final List<AlbumEntity> albums) {
        this.albums = albums;
        it = albums.iterator();
    }

    public int getSize() {
        return albums.size();
    }

    public String getAlbum() {
        if (it.hasNext()) {
            AlbumEntity m = it.next();
            return m.toString();
        } else {
            return null;
        }
    }

}
