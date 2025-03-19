package com.example.cows.dtos;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OwnerRegistrationDto {
    @NotBlank(message = "First name cannot be blank")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @NotNull(message = "Date of birth cannot be empty")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    @Size(min = 9, max = 9, message = "Phone number must be exactly 9 digits")
    @Pattern(regexp = "\\d{9}", message = "Phone number must contain exactly 9 digits")
    @NotBlank(message = "Phone number cannot be empty")
    private String phoneNumber;

    @NotBlank(message = "Password cannot be blank")
//    @Size(min = 8, max = 30, message = "Password must be between 8 and 30 characters")
    private String password;

    @NotBlank(message = "Address cannot be empty")
    private String address;
}
