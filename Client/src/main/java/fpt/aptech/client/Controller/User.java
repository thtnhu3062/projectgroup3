package fpt.aptech.client.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class User {

    @RequestMapping("/index")
    public String index() {
        return "User/TH/index";
    }

    @RequestMapping("/about")
    public String about() {
        return "User/TH/about";
    }

    @RequestMapping("/login")
    public String login() {
        return "User/TH/login";
    }
}
