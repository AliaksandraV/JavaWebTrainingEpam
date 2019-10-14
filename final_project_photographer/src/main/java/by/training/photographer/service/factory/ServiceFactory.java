package by.training.photographer.service.factory;

import by.training.photographer.dao.DaoFactory;
import by.training.photographer.service.UserService;

public interface ServiceFactory {
    UserService createUserService(DaoFactory daoFactory);
}
