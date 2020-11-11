package jp.co.sakura.app.rest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @PostMapping("/login")
    public ModelAndView authLogin(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
        return new ModelAndView("index");
    }

    @PostMapping("/registration")
    public ModelAndView authRegistration(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
        return new ModelAndView("index");
    }
}
