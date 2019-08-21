package by.training.composite.service.parser;

import by.training.composite.entity.Component;

import java.util.List;

public interface Parser {

  Component parse(String string);
}
