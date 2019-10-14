package by.training.photographer.controller;

import by.training.photographer.action.Action;
import by.training.photographer.action.AlbumsShowAction;
import by.training.photographer.action.HomePageShowAction;
import by.training.photographer.action.LoginAction;
import by.training.photographer.action.PortfolioShowAction;

public class ActionFactoryImpl implements ActionFactory {

    @Override
    public Action create(String actionPath) {
        switch (actionPath) {
            case "/portfolio":
                return new PortfolioShowAction();
            case "/home":
                return new HomePageShowAction();
            case "album":
                return new AlbumsShowAction();
            case "/login":
                return new LoginAction();
            default:
                throw new IllegalArgumentException();
        }
    }
}
