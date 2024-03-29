package by.training.photographer.dao;

import by.training.photographer.entity.Role;
import by.training.photographer.entity.UserEntity;
import by.training.photographer.exception.PersistenceException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

public class UserDaoImplTest extends BaseDaoImplTest {

    private static final String EMAIL = "email";
    private static final String NAME = "name";
    private static final String PASSWORD_HASH = "password";
    private static final String SALT = "salt";
    private static final String PHONE = "phone2";
    private static final Role ROLE = Role.USER;
    private static final int ID = 1;
    private static final UserEntity NEW_USER_ENTITY = new UserEntity(null, EMAIL, PASSWORD_HASH, SALT, NAME, PHONE, ROLE);
    private static final UserEntity SAVED_USER_ENTITY = new UserEntity(ID, EMAIL, PASSWORD_HASH, SALT, NAME, PHONE, ROLE);

    private UserDao userDao;

    @BeforeClass
    public void initClass() {
        userDao = new UserDaoImpl(getConnection());
    }

    @Test
    public void testCreate() throws PersistenceException {
        // init
        assertTrue(userDao.findAll().isEmpty());

        // when
        Integer id = userDao.create(NEW_USER_ENTITY);

        // then
        assertEquals(SAVED_USER_ENTITY, userDao.findById(id));
    }

    @Test
    public void testUpdate() throws PersistenceException {
        // init
        executeScript("INSERT INTO user (email, password_hash, salt, name, phone_number, role) VALUES ('"
            + EMAIL + "', '" + PASSWORD_HASH + "', '" + SALT + "', '" + NAME + "', '" + PHONE + "', '" + ROLE.getId() + "')");

        String updatedName = "new name";
        UserEntity updatedUserEntity = new UserEntity(ID, EMAIL, PASSWORD_HASH, SALT, updatedName, PHONE, ROLE);

        // when
        userDao.update(updatedUserEntity);

        // then
        assertEquals(updatedUserEntity, userDao.findById(ID));
    }

    @Test
    public void testDelete() throws PersistenceException {
        // init
        executeScript("INSERT INTO user (email, password_hash, salt, name, phone_number, role) VALUES ('"
            + EMAIL + "', '" + PASSWORD_HASH + "', '" + SALT + "', '" + NAME + "', '" + PHONE + "', '" + ROLE.getId() + "')");
        assertFalse(userDao.findAll().isEmpty());

        // when
        userDao.delete(ID);

        // then
        assertTrue(userDao.findAll().isEmpty());
    }

    @Test
    public void testFindById() throws PersistenceException {
        // init
        assertNull(userDao.findById(ID));
        executeScript("INSERT INTO user (email, password_hash, salt, name, phone_number, role) VALUES ('"
            + EMAIL + "', '" + PASSWORD_HASH + "', '" + SALT+ "', '" + NAME + "', '" + PHONE + "', '" + ROLE.getId() + "')");

        // when
        UserEntity result = userDao.findById(ID);

        // then
        assertEquals(result, SAVED_USER_ENTITY);
    }

    @Test
    public void testFindAll() throws PersistenceException {
        // init
        executeScript("INSERT INTO user (email, password_hash, salt, name, phone_number, role) VALUES ('"
            + EMAIL + "', '" + PASSWORD_HASH + "', '" + SALT + "', '" + NAME + "', '" + PHONE + "', '" + ROLE.getId() + "')");

        // when
        List<UserEntity> result = userDao.findAll();

        // then
        assertEquals(result, Collections.singletonList(SAVED_USER_ENTITY));
    }
}