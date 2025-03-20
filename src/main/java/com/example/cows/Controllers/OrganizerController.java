package com.example.cows.Controllers;

import com.example.cows.Services.CattleService;
import com.example.cows.Services.UserService;
import com.example.cows.dtos.CattleRegisterDto;
import com.example.cows.dtos.OwnerRegistrationDto;
import com.example.cows.models.Cattle;
import com.example.cows.models.Owner;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/cowsOrganizer")
@AllArgsConstructor
public class OrganizerController {

    private final UserService userService;


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/pregnancies")
    public String pregnanciesHistory() {
        return "/fragments/pregnancies :: history-cattle";
    }

    @GetMapping("/owner-panel")
    public String ownerPanel(Authentication authentication, HttpServletRequest request, Model model) {
        return "ownerPanel";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("ownerDto", new OwnerRegistrationDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("ownerDto") @Valid OwnerRegistrationDto ownerDto, Model model, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "register";
        }
        try {
            userService.registerOwner(ownerDto);

        } catch (Exception e) {
            model.addAttribute("error", "User already exists!");
            e.printStackTrace();
        }
        return "redirect:/login?success=true";
    }




//    public String addCattle(CattleRegisterDto cattleRegisterDto) {
//
//    }

}
