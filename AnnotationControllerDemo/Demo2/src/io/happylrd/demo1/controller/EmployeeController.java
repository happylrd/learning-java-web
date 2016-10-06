package io.happylrd.demo1.controller;

import io.happylrd.demo1.model.Product;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
    private static final Log logger = LogFactory.getLog(ProductController.class);

    @RequestMapping(value = "/employee_input")
    public String inputEmployee() {
        logger.info("inputEmployee called");
        return "ProductForm";
    }

    @RequestMapping(value = "/employee_save")
    public String saveEmployee(Product product, BindingResult bindingResult,
                               Model model) {
        logger.info("saveEmployee called 2");

        logger.info("as map:" + model.asMap());

        if (bindingResult.hasErrors()) {
            logger.info("has errors");
            FieldError fieldError = bindingResult.getFieldError();
            logger.info("Code:" + fieldError.getCode()
                    + ", field:" + fieldError.getField());

            return "ProductForm";
        }

        // save product here

        model.addAttribute("product", product);
        return "ProductDetails";
    }

    @ModelAttribute
    public Product addAccount(@RequestParam String number) {
        logger.info("addAccount called. number is " + number);
        return new Product();
    }

    @ModelAttribute
    public void populateModel(@RequestParam String number, Model model) {
        logger.info("populateModel called. number is " + number);
        model.addAttribute("blah");
    }
}
