//package by.training.photographer.controller;
//
//import by.training.photographer.controller.action.Action;
//import org.apache.log4j.Logger;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Map;
//
//public class DispatcherServlet extends HttpServlet {
//    private static Logger logger = Logger.getLogger(DispatcherServlet.class);
//
//    @Override
//    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
//        requestDispatcher.forward(req, resp);
////        process(req, resp);
//    }
//
//    @Override
//    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
//        requestDispatcher.forward(req, resp);
//        process(req, resp);
//    }
//
//    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        Action action = (Action) request.getAttribute("action");
//        System.out.println(action);
//        try {
//            HttpSession session = request.getSession(false);
//            if (session != null) {
//                @SuppressWarnings("unchecked")
//                Map<String, Object> attributes = (Map<String, Object>) session.getAttribute("redirectedData");
//                if (attributes != null) {
//                    for (String key : attributes.keySet()) {
//                        request.setAttribute(key, attributes.get(key));
//                    }
//                    session.removeAttribute("redirectedData");
//                }
//            }
////            ActionManager actionManager = ActionManagerFactory.getManager(getFactory());
////            Action.Forward forward = actionManager.execute(action, request, response);
////            actionManager.close();
////            if(session != null && forward != null && !forward.getAttributes().isEmpty()) {
////                session.setAttribute("redirectedData", forward.getAttributes());
////            }
////            String requestedUri = request.getRequestURI();
////            if(forward != null && forward.isRedirect()) {
////                String redirectedUri = request.getContextPath() + forward.getForward();
////                logger.debug(String.format("Request for URI \"%s\" id redirected to URI \"%s\"", requestedUri, redirectedUri));
////                response.sendRedirect(redirectedUri);
////            } else {
////                String jspPage;
////                if(forward != null) {
////                    jspPage = forward.getForward();
////                } else {
////                    jspPage = action.getName() + ".jsp";
////                }
////                jspPage = "/WEB-INF/jsp" + jspPage;
////                logger.debug(String.format("Request for URI \"%s\" is forwarded to JSP \"%s\"", requestedUri, jspPage));
////                getServletContext().getRequestDispatcher(jspPage).forward(request, response);
////            }
//        } catch (Exception e) {
//            logger.error("It is impossible to process request", e);
//            request.setAttribute("error", "Ошибка обработки данных");
//            getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
//        }
//    }
//}
