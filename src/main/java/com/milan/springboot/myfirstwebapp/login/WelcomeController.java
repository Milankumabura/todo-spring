package com.milan.springboot.myfirstwebapp.login;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
    //private Logger logger = LoggerFactory.getLogger(getClass());

//    @RequestMapping("login")
//    public String gotoLoginPage(@RequestParam String name, ModelMap model) {
//        model.put("name", name);
//        logger.debug("Request param is {}", name);
//        logger.info("I want this printed at info level");
//        logger.warn("I want this printed at warning level");
//        System.out.println("Request param = " + name);
//        return "login";
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String gotoWelcomePage(ModelMap model) {
        model.put("name", getLoggedinUsername());
        return "welcome";
    }

    private String getLoggedinUsername() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
