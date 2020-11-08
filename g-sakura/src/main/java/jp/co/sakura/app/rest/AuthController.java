package jp.co.sakura.app.rest;

import jp.co.sakura.core.domain.dto.RegistrationDTO;
import org.apache.commons.lang3.StringUtils;
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
    public ModelAndView authLogin(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("returnUrl") String returnUrl) {
        ModelAndView mv = StringUtils.isEmpty(returnUrl) ? new ModelAndView("index") : new ModelAndView(returnUrl);
        mv.addObject("locale", "ja");
        return mv;
    }

    @PostMapping("/registration")
    public ModelAndView authRegistration(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale, @ModelAttribute("registration") RegistrationDTO registrationDTO, @RequestParam("returnUrl") String returnUrl){
        ModelAndView mv = StringUtils.isEmpty(returnUrl) ? new ModelAndView("index") : new ModelAndView(returnUrl);
        mv.addObject("locale", "ja");
        return mv;
    }
}
