package io.happylrd.demo3.controller;

import io.happylrd.demo3.form.ProductForm;
import io.happylrd.demo3.model.Product;
import io.happylrd.demo3.validator.ProductValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SaveProductController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ProductForm productForm = new ProductForm();
        productForm.setName(request.getParameter("name"));
        productForm.setDescription(
                request.getParameter("description")
        );
        productForm.setPrice(request.getParameter("price"));

        ProductValidator productValidator = new ProductValidator();
        List<String> errors = productValidator.validate(productForm);
        if (errors.isEmpty()) {
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            product.setPrice(Float.parseFloat(productForm.getPrice()));

            // insert code to save product to the database

            request.setAttribute("product", product);
            return "/WEB-INF/jsp/ProductDetails.jsp";
        } else {
            request.setAttribute("errors", errors);
            request.setAttribute("form", productForm);
            return "/WEB-INF/jsp/ProductForm.jsp";
        }
    }
}