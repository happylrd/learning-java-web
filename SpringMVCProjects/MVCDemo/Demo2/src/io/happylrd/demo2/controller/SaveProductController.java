package io.happylrd.demo2.controller;

import io.happylrd.demo2.form.ProductForm;
import io.happylrd.demo2.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveProductController implements Controller{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
        return "/WEB-INF/jsp/ProductDetails.jsp";
    }
}
