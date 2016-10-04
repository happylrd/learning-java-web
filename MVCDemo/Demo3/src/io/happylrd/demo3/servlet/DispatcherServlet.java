package io.happylrd.demo3.servlet;

import io.happylrd.demo3.controller.InputProductController;
import io.happylrd.demo3.controller.SaveProductController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUUID = 748495L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();

        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);

        // forward to a view
        String dispatchUrl = null;
        if (action.equals("product_input.action")) {
            InputProductController controller =
                    new InputProductController();
            dispatchUrl = controller.handleRequest(request, response);
        } else if (action.equals("product_save.action")) {
            SaveProductController controller =
                    new SaveProductController();
            dispatchUrl = controller.handleRequest(request, response);
        }

        if (dispatchUrl != null) {
            RequestDispatcher requestDispatcher =
                    request.getRequestDispatcher(dispatchUrl);
            requestDispatcher.forward(request, response);
        }
    }
}