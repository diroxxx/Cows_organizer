package com.example.cows.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pregnancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate inseminationDate;

    @Future
    private LocalDate expectedDueDate;

    @NotBlank
    @Size(min = 1, max = 50)
    private String status;

    @ManyToOne()
    @NotNull
    @JoinColumn(name = "cattle_id")
    private Cattle cattle;

    @ManyToOne()
    @JoinColumn(name = "insemination_id")
    @NotNull
    private Insemination_dose inseminationDose;
}
