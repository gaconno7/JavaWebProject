package vn.com.stanford.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.stanford.springmvc.module.DAO;
import vn.com.stanford.springmvc.module.User;

import java.util.ArrayList;

@Controller
public class SignupController {

    private DAO dao;

    @RequestMapping(value = "/signup")
    public String showSignup(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @RequestMapping(value = "/signup-action")
    public String Signup(@ModelAttribute("user") User user, Model model) {
        dao = new DAO();

        dao.addUser(user);

        model.addAttribute("user", new User());
        return "redirect:signin";
    }
}
