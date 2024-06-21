package fpt.aptech.client.Controller;

import fpt.aptech.client.Model.Classs;
import fpt.aptech.client.Model.EducationLevel;
import fpt.aptech.client.Model.Subject;
import fpt.aptech.client.dto.Classsdto;
import fpt.aptech.client.dto.EducationLeveldto;
import fpt.aptech.client.dto.Subjectdto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class DashboardAdmin {

    private final String urlLevel = "http://localhost:9999/api/edu";
    private final String urlClasss = "http://localhost:9999/api/class";
    private final String urlSubject = "http://localhost:9999/api/subject";
    private static RestTemplate rt = new RestTemplate();

    @RequestMapping("/list_level")
    public String listlevel(Model model) {
        List<EducationLevel> eList = rt.getForObject(urlLevel + "/", List.class);
        model.addAttribute("level", eList);
        return "DashboardAdmin/TH/list_level";
    }

    @GetMapping("/create_level")
    public String createlevel(Model model) {
        model.addAttribute("level", new EducationLevel());
        return "DashboardAdmin/TH/create_level";
    }

    @PostMapping("/save")
    public String save(@Valid EducationLeveldto leveldto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "DashboardAdmin/TH/create_level";
        }

        EducationLevel level = new EducationLevel();
        level.setLevelname(leveldto.getLevelname());
        level.setLeveldescription(leveldto.getLeveldescription());

        ResponseEntity<EducationLevel> response = rt.postForEntity(urlLevel + "/create", level, EducationLevel.class);
        if (response.getStatusCode() == HttpStatus.CREATED) {
            model.addAttribute("level", response.getBody());
            return "redirect:/list_level";
        } else {
            model.addAttribute("error", "Failed to create level. Please try again later.");
            return "DashboardAdmin/TH/create_level";
        }
    }

    @RequestMapping("/list_class")
    public String listclass(Model model) {
        List<Classs> cList = rt.getForObject(urlClasss + "/", List.class);

        model.addAttribute("classs", cList);

        return "DashboardAdmin/TH/list_class";
    }


    @GetMapping("/create_class")
    public String createclass(Model model) {
        List<EducationLevel> eList = rt.getForObject(urlLevel + "/", List.class);
        model.addAttribute("classs", new Classs()); // Change "class" to "classs"
        model.addAttribute("levels", eList);
        return "DashboardAdmin/TH/create_class";
    }

    @PostMapping("/saveclasss")
    public String saveclasss(@Valid Classsdto classsdto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<EducationLevel> eList = rt.getForObject(urlLevel + "/", List.class);
            model.addAttribute("level", eList);
            return "DashboardAdmin/TH/create_class";
        }

        Classs classs = new Classs();
        classs.setClasssname(classsdto.getClasssname());

        // Lấy đối tượng EducationLevel từ ID
        EducationLevel level = rt.getForObject(urlLevel + "/" + classsdto.getLevelid(), EducationLevel.class);
        classs.setLevelid(level);

        ResponseEntity<Classs> response = rt.postForEntity(urlClasss + "/create", classs, Classs.class);
        if (response.getStatusCode() == HttpStatus.CREATED) {
            return "redirect:/list_class";
        } else {
            List<EducationLevel> eList = rt.getForObject(urlLevel + "/", List.class);
            model.addAttribute("level", eList);
            model.addAttribute("error", "Failed to create class. Please try again later.");
            return "DashboardAdmin/TH/create_class";
        }
    }


//    @GetMapping("/")
//    public String index(Model model) {
//        return "admin/layout_admin";
//    }


    @RequestMapping("/create_subject")
    public String createsubject(Model model) {
        ResponseEntity<List<Classs>> responseEntity = rt.exchange(
                urlClasss + "/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Classs>>() {}
        );
        List<Classs> sList = responseEntity.getBody();

        model.addAttribute("subject", new Subject());
        model.addAttribute("classs", sList);
        return "DashboardAdmin/TH/create_subject";
    }


    @RequestMapping("/list_subject")
    public String listSubject(Model model) {
        ResponseEntity<List<Subject>> response = rt.exchange(
                urlSubject + "/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Subject>>() {}
        );
        List<Subject> sList = response.getBody();
        model.addAttribute("subject", sList);
        return "DashboardAdmin/TH/list_subject";
    }


    @PostMapping("/savesubject")
    public String savesubject(@Valid Subjectdto subjectdto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Classs> cList = rt.getForObject(urlClasss + "/", List.class);

            model.addAttribute("classs", cList);
            return "DashboardAdmin/TH/create_subject";
        }

        Subject subject = new Subject();
        subject.setSubjectname(subjectdto.getSubjectname());

        // Lấy đối tượng Classs từ ID
        Classs classs = rt.getForObject(urlClasss + "/" + subjectdto.getClasssid(), Classs.class);
        subject.setClasssid(classs);

        ResponseEntity<Subject> response = rt.postForEntity(urlSubject + "/create", subject, Subject.class);
        if (response.getStatusCode() == HttpStatus.CREATED) {
            return "redirect:/list_subject";
        } else {
            List<Classs> cList = rt.getForObject(urlClasss + "/", List.class);

            model.addAttribute("classs", cList);
            model.addAttribute("error", "Failed to create subject. Please try again later.");
            return "DashboardAdmin/TH/create_subject";
        }
    }
    @GetMapping("/Delete/{subjectid}")
    public String deleteSubject(@PathVariable("subjectid") int subjectid) {
        rt.delete(urlSubject + "/" + subjectid);
        return "redirect:/list_subject";
    }

}

