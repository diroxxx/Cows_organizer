package com.example.cows.Controllers;


import com.example.cows.Services.CattleService;
import com.example.cows.Services.OwnerService;
import com.example.cows.dtos.CattleRegisterDto;
import com.example.cows.mappers.CattleMapper;
import com.example.cows.models.Cattle;
import com.example.cows.models.Owner;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class OwnerController {

    private final OwnerService ownerService;
    private final CattleService cattleService;
    private final CattleMapper cattleMapper;


    public OwnerController(OwnerService ownerService, CattleService cattleService, CattleMapper cattleMapper) {
        this.ownerService = ownerService;
        this.cattleService = cattleService;
        this.cattleMapper = cattleMapper;
    }

//    @PostMapping("/update/{id}")
//    public String updateCattle(@PathVariable Long id, @ModelAttribute Cattle cattle, Model model) {
//        cattleService.save(cattle);
//        model.addAttribute("cattle", cattle);
//        return "fragments/cattle-templates :: cattle-row";
//    }




    @PostMapping("/cattles")
    public String addCattle(CattleRegisterDto cattleDto, Authentication authentication, Model model) {

        Cattle cattle = cattleMapper.toCattle(cattleDto);

        Optional<Owner> owner = ownerService.findOwnerByEmail(authentication.getName());

        if (owner.isPresent()) {
            cattle.setOwner(owner.get());
            cattle.setIsCalf(false);

            cattleService.save(cattle);

            model.addAttribute("message", "Cattle has been added successfully!");
            return "redirect:/owner-panel?success=true";
        } else {
            model.addAttribute("error", "Owner not found!");
            return "redirect:/owner-panel?error=true";
        }
    }


    @GetMapping("/cattles/{id}/edit")
    public String editCattle(@PathVariable Long id, Model model) {
        Optional<Cattle> cattleOptional = cattleService.getCattleByCattleId(id);
        if (cattleOptional.isPresent()) {
            model.addAttribute("cattle", cattleOptional.get());
            return "fragments/cattle-templates :: editRow";
        }
        return "";
    }

    // Usunięcie krowy
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteCattle(@PathVariable Long id) {
//        cattleService.deleteById(id);
//        return ResponseEntity.ok().build();
//    }
}
