package com.example.cows.dtos;

import com.example.cows.models.Owner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class CattleRegisterDto {

    private int identificationNumber;
    private String gender;
    private String breed;
    private double weight;
    private LocalDate dateOfBirth;
    private String status;
    private boolean isCalf;
    private Owner owner;

}
