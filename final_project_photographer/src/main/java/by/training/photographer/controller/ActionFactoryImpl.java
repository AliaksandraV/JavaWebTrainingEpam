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
import by.training.photographer.action.SwitchLanguageAction;
import by.training.photographer.service.factory.ServiceFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ActionFactoryImpl implements ActionFactory {

    private final ServiceFactory serviceFactory;
    private Map<String, ActionCreator> actionCreatorMap;

    public ActionFactoryImpl(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
        initActionCreatorMap();
    }

    private void initActionCreatorMap() {
        actionCreatorMap = new HashMap<>();
        actionCreatorMap.put("/portfolio", () -> new PortfolioShowAction(serviceFactory));
        actionCreatorMap.put("/home", () -> new HomePageShowAction(serviceFactory));
        actionCreatorMap.put("/album/\\d+", () -> new AlbumsShowAction(serviceFactory));
        actionCreatorMap.put("/photos/\\d+", () -> new PhotoShowAction(serviceFactory));
        actionCreatorMap.put("/login", () -> new LoginAction(serviceFactory));
        actionCreatorMap.put("/logout", () -> new LogoutAction(serviceFactory));
        actionCreatorMap.put("/registration", () -> new RegistrationShowAction(serviceFactory));
        actionCreatorMap.put("/signup", () -> new RegistrationAction(serviceFactory));
        actionCreatorMap.put("/admin", () -> new AdminAction(serviceFactory));
        actionCreatorMap.put("/edit-profile", () -> new EditProfileShowAction(serviceFactory));
        actionCreatorMap.put("/language", () -> new SwitchLanguageAction(serviceFactory));
    }

    @Override
    public Action create(String actionPath) {
        Optional<String> actionCreator = actionCreatorMap.keySet().stream().filter(actionPath::matches).findFirst();
        if (actionCreator.isPresent()) {
            return actionCreatorMap.get(actionCreator.get()).create();
        } else {
            throw new IllegalArgumentException("Action not found for action path " + actionPath);
            //TODO на странице регистрации когда все ок сюда почему-то приходит css
        }
    }

    private interface ActionCreator {
        Action create();
    }
}
