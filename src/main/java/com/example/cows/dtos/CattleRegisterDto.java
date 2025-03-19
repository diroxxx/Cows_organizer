package com.example.cows.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;

@Getter
@Setter
public class CattleRegisterDto {

    private int identificationNumber;
    private String gender;
    private String breed;
    private double weight;
    private LocalDate dateOfBirth;
    private String status;



}
