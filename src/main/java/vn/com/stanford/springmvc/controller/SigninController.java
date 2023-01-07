package vn.com.stanford.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.com.stanford.springmvc.module.DAO;
import vn.com.stanford.springmvc.module.User;

@Controller
public class SigninController {

    private DAO dao;

    @RequestMapping(value = "/signin")
    public String showSignin(Model model) {
        model.addAttribute("user", new User());
        return "signin";
    }

    @RequestMapping(value = "/signin-action")
    public String Signin(@ModelAttribute("user") User user, Model model) {
        dao = new DAO();

        for(User u : dao.getUsers()) {
            if(user.getUsername().equals(u.getUsername()) && user.getPassword().equals(u.getPassword())) {
                model.addAttribute("user", user);
                return "welcome";
            }
        }

        return "redirect:signin";
    }
}
