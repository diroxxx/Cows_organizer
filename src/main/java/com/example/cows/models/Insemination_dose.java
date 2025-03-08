package com.example.cows.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Insemination_dose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 1, max = 50)
    private String name;

    @NotBlank
    @Size(min = 1, max = 50)
    private String breed;

    @NotNull
    @OneToMany
    @JoinColumn(name = "insemination_id")
    private List<Pregnancy> pregnancyList = new ArrayList<>();

    @OneToOne
    private InseminationDoseUsage usage;

}
