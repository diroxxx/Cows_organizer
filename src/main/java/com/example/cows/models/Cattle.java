package com.example.cows.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cattle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private int identificationNumber;

    @NotNull
    @Size(min = 2, max = 100)
    private String gender;

    @NotNull
    @Size(min = 2, max = 100)
    private String breed;

    @Min(1)
    private double weight;

    @PastOrPresent
    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    @Size(min = 2, max = 100)
    private String status;

    @NotNull
    private Boolean isCalf;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne()
    @JoinColumn(name = "mother_id")
    @Nullable
    private Cattle mother;

}
