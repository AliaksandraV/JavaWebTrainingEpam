package by.training.photographer.controller;

import by.training.photographer.action.Action;
import by.training.photographer.action.AlbumsShowAction;
import by.training.photographer.action.HomePageShowAction;
import by.training.photographer.action.LoginAction;
import by.training.photographer.action.PhotoShowAction;
import by.training.photographer.action.PortfolioShowAction;
import by.training.photographer.action.RegistrationAction;
import by.training.photographer.action.RegistrationShowAction;

public class ActionFactoryImpl implements ActionFactory {

    @Override
    public Action create(String actionPath) {
        String[] parts = actionPath.split("/");
        switch (parts[1]) {
            case "portfolio":
                return new PortfolioShowAction();
            case "home":
                return new HomePageShowAction();
            case "album":
                return new AlbumsShowAction();
            case "photos":
                return new PhotoShowAction();
            case "login":
                return new LoginAction();
            case "registration":
                return new RegistrationShowAction();
            case "signup":
                return new RegistrationAction();

            default:
                throw new IllegalArgumentException();
        }
    }
}
