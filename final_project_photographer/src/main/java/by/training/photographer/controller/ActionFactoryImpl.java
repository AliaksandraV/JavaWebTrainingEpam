package by.training.photographer.controller;

import by.training.photographer.action.Action;
import by.training.photographer.action.AdminAction;
import by.training.photographer.action.AlbumsShowAction;
import by.training.photographer.action.EditProfileShowAction;
import by.training.photographer.action.HomePageShowAction;
import by.training.photographer.action.LoginAction;
import by.training.photographer.action.LogoutAction;
import by.training.photographer.action.PhotoShowAction;
import by.training.photographer.action.PortfolioShowAction;
import by.training.photographer.action.RegistrationAction;
import by.training.photographer.action.RegistrationShowAction;
import by.training.photographer.service.factory.ServiceFactory;

public class ActionFactoryImpl implements ActionFactory {

    private final ServiceFactory serviceFactory;

    public ActionFactoryImpl(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Override
    public Action create(String actionPath) {
        String[] parts = actionPath.split("/");
        switch (parts[1]) {
            case "portfolio":
                return new PortfolioShowAction(serviceFactory);
            case "home":
                return new HomePageShowAction(serviceFactory);
            case "album":
                return new AlbumsShowAction(serviceFactory);
            case "photos":
                return new PhotoShowAction(serviceFactory);
            case "login":
                return new LoginAction(serviceFactory);
            case "logout":
                return new LogoutAction(serviceFactory);
            case "registration":
                return new RegistrationShowAction(serviceFactory);
            case "signup":
                return new RegistrationAction(serviceFactory);
            case "admin":
                return new AdminAction(serviceFactory);
            case "edit-profile":
                return new EditProfileShowAction(serviceFactory);

            default:
                System.out.println(parts[1]);
                throw new IllegalArgumentException();
                //TODO на странице регистрации когда все ок сюда почему-то приходит css
        }
    }
}
