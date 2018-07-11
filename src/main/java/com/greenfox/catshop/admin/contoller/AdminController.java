package com.greenfox.catshop.admin.contoller;

import com.greenfox.catshop.cats.dao.CatRepository;
import com.greenfox.catshop.cats.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CatRepository catRepository;

    @GetMapping("")
    public String renderMainPage(HttpServletRequest request) throws NoSuchAlgorithmException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userValidation") &&
                        cookie.getValue().equals(toMD5("Admin" + getTime() + "SECURE0077"))) {
                    return "admin";
                }
            }
        }
        return "login";
    }

    @PostMapping("/signin")
    public String add(@ModelAttribute(value="username") String username,
                      @ModelAttribute(value = "password") String password,
                      HttpServletResponse response) throws NoSuchAlgorithmException {
        if (username.equals("admin") && password.equals("admin")) {
            Cookie cookie = new Cookie("userValidation", toMD5("Admin" + getTime() + "SECURE0077"));
            cookie.setPath("/");
            cookie.setMaxAge(100000);
            response.addCookie(cookie);
            return  "redirect:/admin";
        }
        return "redirect:/admin";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute(value="name") String name,
                      @ModelAttribute(value="amazinglevel") String amazingLevel,
                      @ModelAttribute(value="daddy") String daddy,
                      @ModelAttribute(value="mommy") String mommy,
                      @ModelAttribute(value="description") String description,
                      @ModelAttribute(value="fluffiness") String fluffiness,
                      @ModelAttribute(value="gender") String gender,
                      @ModelAttribute(value="isonsale") String isOnSale,
                      @ModelAttribute(value="piece") String piece,
                      @ModelAttribute(value="price") String price) {
        Cat cat = new Cat();
        cat.setPiece(Long.parseLong(piece));
        cat.setPrice(Long.parseLong(price));
        cat.setAmazingLevel(Integer.parseInt(amazingLevel));
        cat.setOnSale(Boolean.parseBoolean(isOnSale));
        cat.setName(name);
        cat.setDaddy(daddy);
        cat.setMommy(mommy);
        cat.setDescription(description);
        cat.setFluffiness(fluffiness);
        cat.setGender(gender);

        catRepository.save(cat);

        return "redirect:/admin";
    }

    private String toMD5(String text) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(text.getBytes(),0, text.length());
        String hashedPass = new BigInteger(1, messageDigest.digest()).toString(16);
        if (hashedPass.length() < 32) {
            hashedPass = "0" + hashedPass;
        }
        return  hashedPass;
    }

    private int getTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH + Calendar.DAY_OF_MONTH);
    }
}
