package by.training.photographer.controller;

import by.training.photographer.action.Action;

public interface ActionFactory {

    Action create(String actionPath);
}
