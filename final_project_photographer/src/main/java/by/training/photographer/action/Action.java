package by.training.photographer.action;

import by.training.photographer.exception.PersistenceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Action {

    void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, PersistenceException;
}
