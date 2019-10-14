package by.training.photographer.service.factory;

import by.training.photographer.dao.DaoFactory;
import by.training.photographer.service.UserService;
import by.training.photographer.service.UserServiceImpl;

public class ServiceFactoryImpl implements ServiceFactory {

    @Override
    public UserService createUserService(DaoFactory daoFactory) {
        return new UserServiceImpl(daoFactory);
    }
}
