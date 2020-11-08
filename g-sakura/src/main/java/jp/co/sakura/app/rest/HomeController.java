package jp.co.sakura.app.rest;

import jp.co.sakura.core.domain.dto.RegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("locale", "ja");
        return mv;
    }

    @PostMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale,@RequestParam("returnUrl") String returnUrl) {
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("locale", "ja");
        mv.addObject("returnUrl",returnUrl);
        return mv;
    }

    @PostMapping("/registration")
    public ModelAndView registration(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale, @ModelAttribute("registrationDTO") RegistrationDTO registrationDTO, @RequestParam("returnUrl") String returnUrl) {
        ModelAndView mv = new ModelAndView("registration");
        mv.addObject("locale", "ja");
        mv.addObject("returnUrl",returnUrl);
        return mv;
    }
}
