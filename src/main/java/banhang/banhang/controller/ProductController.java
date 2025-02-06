package banhang.banhang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import banhang.banhang.model.Product;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/products")
@Controller
public class ProductController {

    @GetMapping("/new")
    public String newProduct( Model model, @ModelAttribute("product") Product product ) {
        return "product/new";
    }

    @PostMapping("/create")
    public String createProduct(Model model, @ModelAttribute @Valid Product product, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("message", "Dữ liệu chưa nhập đúng !!!!");
        } else {
            model.addAttribute("message", "Dữ liệu Đã nhập đúng");
        }    
        return "product/new";
    }
    

}
