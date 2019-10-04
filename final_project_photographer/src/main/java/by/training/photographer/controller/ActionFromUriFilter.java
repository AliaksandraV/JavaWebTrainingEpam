package by.training.photographer.controller;

import by.training.photographer.action.Action;
import by.training.photographer.action.AlbumsShowAction;
import by.training.photographer.action.HomePageShowAction;
import by.training.photographer.action.PortfolioShowAction;
import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ActionFromUriFilter implements Filter {


    private static Logger logger = Logger.getLogger(ActionFromUriFilter.class);

    private static Map<String, Action> actions = new ConcurrentHashMap<>();

    static {
        actions.put("/home", new HomePageShowAction());
        actions.put("/portfolio", new PortfolioShowAction());
        actions.put("/album", new AlbumsShowAction());
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {

    }

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }


}


