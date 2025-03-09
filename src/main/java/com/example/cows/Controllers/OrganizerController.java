package com.example.cows.Controllers;

import com.example.cows.Services.OwnerService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/cowsOrganizer")
@AllArgsConstructor
public class OrganizerController {

    private final OwnerService ownerService;


    @GetMapping("/list_Of_Owners")
    public String listOfOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "index";
    }

    @GetMapping("/updatedOwners")
    public String updatedOwnersList(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "/fragments/owner :: tableOfOwners";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/cattleInfo")
    public String cattleInfo() {
        return "/fragments/cattle :: cattle-panel";
    }

    @GetMapping("/pregnancies")
    public String pregnanciesHistory() {
        return "/fragments/pregnancies :: history-cattle";
    }

    @GetMapping("/owner-panel")
    public String ownerPanel(Authentication authentication, HttpServletRequest request, Model model) {

        //not working
//        if (authentication != null) {
//            Object principal = request.getUserPrincipal();
//            if (principal instanceof UserDetails userDetails) {
//                model.addAttribute("username", userDetails.getUsername());
//            }
//        }

        return "ownerPanel";
    }

//    @PostMapping("/logout")
//    public String logout() {
//        return "login";
//    }




}
