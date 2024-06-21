package fpt.aptech.client.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardUser {

    @RequestMapping("/teacher")
    public String index( Model model){
        return "DashboardTeacher/TH/teacher";
    }
}
