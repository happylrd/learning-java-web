package io.happylrd.demo1.controller;

import io.happylrd.demo1.form.ProductForm;
import io.happylrd.demo1.model.Product;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    private static final Log logger = LogFactory
            .getLog(ProductController.class);

    @RequestMapping(value = "/product_input")
    public String inputProduct() {
        logger.info("inputProduct called");
        return "ProductForm";
    }

    @RequestMapping(value = "/product_save")
    public String saveProduct(ProductForm productForm, Model model) {
        logger.info("saveProduct called");

        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try {
            product.setPrice(Float.parseFloat(productForm.getPrice()));
        } catch (NumberFormatException e) {
        }

        model.addAttribute("product", product);
        return "ProductDetails";
    }
}
