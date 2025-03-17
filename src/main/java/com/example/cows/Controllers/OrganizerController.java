package com.example.cows.Controllers;

import com.example.cows.Services.UserService;
import com.example.cows.dtos.OwnerRegistrationDto;
import com.example.cows.models.Owner;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//@RequestMapping("/cowsOrganizer")
@AllArgsConstructor
public class OrganizerController {

    private final UserService ownerService;
    private final UserService userService;


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

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("ownerDto", new OwnerRegistrationDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("ownerDto") Owner ownerDto, Model model, BindingResult bindingResult) {

//        if (bindingResult.hasErrors()) {
//            return "register";
//        }

        try {
            userService.registerOwner(ownerDto.getFirstName(), ownerDto.getLastName(), ownerDto.getDateOfBirth(),
                     ownerDto.getEmail(), ownerDto.getPhoneNumber(),
                    ownerDto.getPassword(), ownerDto.getAddress());

            return "redirect:/login?success";
        } catch (Exception e) {
//            model.addAttribute("error", "User already exists!");
            return "/register";
        }

    }

}
