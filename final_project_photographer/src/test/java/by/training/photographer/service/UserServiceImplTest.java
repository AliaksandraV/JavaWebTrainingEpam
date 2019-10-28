package by.training.photographer.service;

import by.training.photographer.dao.DaoFactory;
import by.training.photographer.dao.UserDao;
import by.training.photographer.dao.connection.Transaction;
import by.training.photographer.entity.UserEntity;
import by.training.photographer.exception.PersistenceException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Connection;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

public class UserServiceImplTest {

    private static final Integer ID = 1;
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String SALT = "salt";
    private static final String PASSWORD_HASH = "hash";
    private static final String NAME = "name";
    private static final String PHONE_NUMBER = "phoneNumber";

    @Mock
    private DaoFactory daoFactory;
    @Mock
    private Transaction transaction;
    @Mock
    private Connection connection;
    @Mock
    private UserDao userDao;

    @Mock
    private UserEntity userEntity;

    private UserServiceImpl userService;

    @BeforeTest
    public void beforeTest() {
        MockitoAnnotations.initMocks(this);
        userService = spy(new UserServiceImpl(daoFactory));
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testCreate() throws PersistenceException {
        userService.create(new UserEntity());
    }

    @Test
    public void testRegister() throws PersistenceException {
        // init
        when(userService.createTransaction()).thenReturn(transaction);
        when(transaction.getConnection()).thenReturn(connection);
        when(daoFactory.getUserDao(connection)).thenReturn(userDao);
        when(userDao.create(userEntity)).thenReturn(ID);
        // todo think how to improve this stuff
        when(transaction.commitWithResult(isA(Transaction.CallbackWithResult.class))).thenReturn(ID);

        when(userService.generateSalt()).thenReturn(SALT);
        when(userService.getPasswordHash(PASSWORD, SALT)).thenReturn(PASSWORD_HASH);

        // when
        Integer result = userService.register(EMAIL, PASSWORD, NAME, PHONE_NUMBER);

        // then
        assertEquals(ID, result);
        verify(userService).createTransaction();
        verify(transaction).getConnection();
        verify(daoFactory).getUserDao(connection);
        verify(transaction).commitWithResult(isA(Transaction.CallbackWithResult.class));
        verify(userService).generateSalt();
        verify(userService).getPasswordHash(PASSWORD, SALT);
    }
}