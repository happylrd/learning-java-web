package io.happylrd.demo1.servlet;

import io.happylrd.demo1.model.Product;
import io.happylrd.demo1.form.ProductForm;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1579L;

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

        if (action.equals("product_input.action")) {

        } else if (action.equals("product_save.action")) {
            ProductForm productForm = new ProductForm();
            productForm.setName(request.getParameter("name"));
            productForm.setDescription(
                    request.getParameter("description")
            );
            productForm.setPrice(request.getParameter("price"));

            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            try {
                product.setPrice(Float.parseFloat(productForm.getPrice()));
            } catch (NumberFormatException e) {
            }

            // code to save product

            request.setAttribute("product", product);
        }

        // forward to a view
        String dispatchUrl = null;
        if (action.equals("product_input.action")) {
            dispatchUrl = "/WEB-INF/jsp/ProductForm.jsp";
        } else if (action.equals("product_save.action")) {
            dispatchUrl = "/WEB-INF/jsp/ProductDetails.jsp";
        }
        if (dispatchUrl != null) {
            RequestDispatcher requestDispatcher =
                    request.getRequestDispatcher(dispatchUrl);
            requestDispatcher.forward(request, response);
        }
    }
}
