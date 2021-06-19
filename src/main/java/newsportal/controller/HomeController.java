package newsportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/newsportal/")
public class HomeController {
    @GetMapping("/user")
    public String index() {
        return "user";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}