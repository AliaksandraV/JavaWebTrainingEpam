package by.training.photographer.service;

import by.training.photographer.dao.AlbumDao;
import by.training.photographer.entity.AlbumEntity;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AlbumServiceImplTest {

    @Mock
    private AlbumDao albumDao;

    @Mock
    private AlbumEntity albumEntity;

    private AlbumService albumService;

    @BeforeTest
    public void setUpTest() {
        MockitoAnnotations.initMocks(this);
        albumService = new AlbumServiceImpl(albumDao);
    }

    @Test
    public void testCreate() {
        // init
        doNothing()
            .when(albumDao)
            .create(albumEntity);

        // call
        albumService.create(albumEntity);

        // check
        verify(albumDao).create(albumEntity);
    }
}