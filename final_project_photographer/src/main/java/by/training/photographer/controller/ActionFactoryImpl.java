package by.training.photographer.controller;

import by.training.photographer.action.Action;
import by.training.photographer.action.AlbumsShowAction;
import by.training.photographer.action.HomePageShowAction;
import by.training.photographer.action.LoginAction;
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
            case "registration":
                return new RegistrationShowAction(serviceFactory);
            case "signup":
                return new RegistrationAction(serviceFactory);

            default:
                throw new IllegalArgumentException();
        }
    }
}
