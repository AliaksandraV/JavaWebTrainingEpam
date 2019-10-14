package by.training.photographer.dao;

import by.training.photographer.entity.LocalizedTextEntity;
import by.training.photographer.exception.PersistenceException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

public class LocalizedTextDaoImplTest extends BaseDaoImplTest {
    private LocalizedTextDao localizedTextDao;

    private static final int ID = 1;
    private static final String TEXT = "text";
    private static final LocalizedTextEntity NEW_LOCALIZED_TEXT_ENTITY = new LocalizedTextEntity(TEXT);
    private static final LocalizedTextEntity SAVED_LOCALIZED_TEXT_ENTITY = new LocalizedTextEntity(ID, TEXT);

    @BeforeClass
    public void initClass() {
        localizedTextDao = new LocalizedTextDaoImpl(getConnection());
    }

    @Test
    public void testCreate() throws PersistenceException {
        // init
        assertTrue(localizedTextDao.findAll().isEmpty());

        // when
        Integer id = localizedTextDao.create(NEW_LOCALIZED_TEXT_ENTITY);

        // then
        assertEquals(SAVED_LOCALIZED_TEXT_ENTITY, localizedTextDao.findById(id));
    }

    @Test
    public void testUpdate() throws PersistenceException {
        // init
        executeScript("INSERT INTO localized_text (russian) VALUES ('"
            + TEXT + "')");

        String updatedName = "new name";
        LocalizedTextEntity updatedUserEntity = new LocalizedTextEntity(ID, updatedName);

        // when
        localizedTextDao.update(updatedUserEntity);

        // then
        assertEquals(updatedUserEntity, localizedTextDao.findById(ID));
    }

    @Test
    public void testDelete() throws PersistenceException {
        // init
        executeScript("INSERT INTO localized_text (russian) VALUES ('"
            + TEXT + "')");
        assertFalse(localizedTextDao.findAll().isEmpty());

        // when
        localizedTextDao.delete(ID);

        // then
        assertTrue(localizedTextDao.findAll().isEmpty());
    }

    @Test
    public void testFindById() throws PersistenceException {
        // init
        assertNull(localizedTextDao.findById(ID));
        executeScript("INSERT INTO localized_text (russian) VALUES ('"
            + TEXT + "')");
        // when
        LocalizedTextEntity result = localizedTextDao.findById(ID);

        // then
        assertEquals(result, SAVED_LOCALIZED_TEXT_ENTITY);
    }

    @Test
    public void testFindAll() throws PersistenceException {
        // init
        executeScript("INSERT INTO localized_text (russian) VALUES ('"
            + TEXT + "')");
        // when
        List<LocalizedTextEntity> result = localizedTextDao.findAll();

        // then
        assertEquals(result, Collections.singletonList(SAVED_LOCALIZED_TEXT_ENTITY));
    }
}