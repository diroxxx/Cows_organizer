package com.example.cows.Controllers;

import com.example.cows.Services.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cowsOrganizer")
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

}
