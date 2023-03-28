package utez.edu.mx.SIGEV.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
    @GetMapping(value="/sign")
    public String login() {
        return  "/sign/login";
    }
    
    @GetMapping(value="/index")
    public String index() {
        return  "/index";
    }
    
}
