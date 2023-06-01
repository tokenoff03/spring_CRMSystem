package com.example.sprinttask2bitlab.Controller;


import com.example.sprinttask2bitlab.Models.ApplicationRequest;
import com.example.sprinttask2bitlab.Repositories.ApplicationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ApplicationRequestRepository applicationRequestRepository;

    @GetMapping("/")
    public String allRequests(Model model){
        List<ApplicationRequest> applicationRequests = applicationRequestRepository.findAll();
        model.addAttribute("requests", applicationRequests);
        return "allRequests";
    }

    @GetMapping("/new")
    public String newRequests(Model model){
        List<ApplicationRequest> applicationRequests = applicationRequestRepository.findAll();
        model.addAttribute("requests", applicationRequests);
        return "new_requests";
    }

    @GetMapping("/seen")
    public String seenRequests(Model model){
        List<ApplicationRequest> applicationRequests = applicationRequestRepository.findAll();
        model.addAttribute("requests", applicationRequests);
        return "seen_requests";
    }

    @GetMapping("/add")
    public String addRequests(Model model){

        return "add_request";
    }

    @PostMapping("/add")
    public String addRequestsPost(Model model,
                                  @RequestParam(name = "name") String name,
                                  @RequestParam(name = "number") String number,
                                  @RequestParam(name = "course") String course,
                                  @RequestParam(name = "comment") String comment){
        ApplicationRequest applicationRequest = new ApplicationRequest();
        applicationRequest.setCommentary(comment);
        applicationRequest.setPhone(number);
        applicationRequest.setUserName(name);
        applicationRequest.setHandled(false);
        applicationRequest.setCourseName(course);

        applicationRequestRepository.save(applicationRequest);
        return "redirect:/new";
    }

    @GetMapping("/desc/{id}")
    public String description(Model model, @PathVariable("id") Long id){
        ApplicationRequest applicationRequest = applicationRequestRepository.getOne(id);

        model.addAttribute("request", applicationRequest);
        return "description";
    }

    @PostMapping("/desc")
    public String descriptionUpd(Model model, @RequestParam(name = "id") Long id){
        ApplicationRequest applicationRequest = applicationRequestRepository.getOne(id);
        applicationRequest.setHandled(true);
        applicationRequestRepository.save(applicationRequest);
        model.addAttribute("request", applicationRequest);
        return "redirect:/desc/" + id;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        applicationRequestRepository.deleteById(id);
        return "/";
    }
}
