package by.training.photographer.controller;

import by.training.photographer.entity.PhotoCategoryEntity;
import by.training.photographer.service.PhotoCategoryService;
import by.training.photographer.service.PhotoCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Portfolio extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/portfolio.jsp").forward(req, resp);
    }
}
