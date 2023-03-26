package utez.edu.mx.SIGEV.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
    @GetMapping(value="/Login")
    public String login() {
        return  "login";
    }
    
}
