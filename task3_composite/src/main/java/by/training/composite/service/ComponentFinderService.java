package by.training.composite.service;

import by.training.composite.entity.Component;
import by.training.composite.entity.ComponentException;
import by.training.composite.entity.Paragraph;

import java.util.ArrayList;
import java.util.List;

public class ComponentFinderService {

    public List<Component> find(final Component component, final Class<? extends Component> className) throws ComponentException {
        List<Component> components = new ArrayList<>();
//        for (int i = 0; i < component.takeChildrenNumber(); i++) {
//            if (component.takeChild(i).getClass() == className) {
//
//            }
//        }

        return null;
    }
}
