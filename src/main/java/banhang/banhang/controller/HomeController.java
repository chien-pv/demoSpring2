package banhang.banhang.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class HomeController {
    @Autowired
    HttpSession session;
    @Autowired 
    ServletContext context;

    @ModelAttribute("now")
    public Date getDate(){
        return new Date();
    }
    
    @GetMapping("about")
    public String about(Model model) {
        return "home/about";
    }
    
    @GetMapping("")
    public String index(Model model) {
        session.setAttribute("uname", "Tran VAN C");
        Staff staff =  new Staff();
        staff.pass = "12345678";
        staff.uname= "nguyen van b";
        staff.photo= "image.png";
        staff.mark = 5;

        List list = new ArrayList<>();
        list.add(staff);
        list.add(staff);
        list.add(staff);
        list.add(staff);
    
        model.addAttribute("list", list);

        model.addAttribute("staff", staff);
        model.addAttribute("name", " &lt &copy; Nguyen Van A");
        return "home/index";
    }
    @GetMapping("/form/{id}")
    public String form(Model model, 
    @RequestParam("page") Optional<Integer> page,
    @CookieValue("JSESSIONID") String ck,
    @PathVariable("id") String id

    ) {
        int pg = page.orElse(0);
        model.addAttribute("message", id);
        return "login/login";
    }
    
    @PostMapping("/check")
    public String login(Model model, 
    Staff bean,
    @RequestPart("photo") MultipartFile filePhoto
     ) {
        String message;
        if (bean.uname.equals("poly") && bean.pass.equals("123")) {
            message = "Đăng Nhập Thành Công!!!";
        } else {
            message = "Đăng Nhập Thất bại!!!";
        }

        String dir = "/Users/phamvanchien/SpringBoot/banhang2/src/main/resources/static/photos";
        if(!filePhoto.isEmpty()){
            String fileName = filePhoto.getOriginalFilename();
            try {
                filePhoto.transferTo(new File(dir, fileName));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("message", message);
        return "redirect:/login";
    }
}
