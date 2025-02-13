package banhang.banhang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import banhang.banhang.model.Product;
import banhang.banhang.service.CookieService;
import banhang.banhang.service.CrudService;
import banhang.banhang.service.PgCrudService;
import banhang.banhang.service.SqlServerCrudService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/products")
@Controller
public class ProductController {

    @Qualifier("CS2")
    @Autowired
    CookieService cookieService;

    @Autowired
    CrudService crudService;
 
    @GetMapping("/new")
    public String newProduct( Model model, @ModelAttribute("product") Product product ) {
        System.out.println(crudService.getClass());

        crudService.create();

        cookieService.creatCookie( null, 0);
        return "home/index";
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
