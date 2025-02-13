package banhang.banhang.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;

public class CookieService {
    public String name;
    public CookieService(String name){
        this.name = name;
    }

    public Cookie creatCookie( String value, int exp){
        return null;
    }
}
