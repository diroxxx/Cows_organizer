package com.example.cows.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "first name cannot be blank")
    @Size(min = 2, max = 50, message = " length of first name must be grather or equal 2 ")
    private String firstName;

    @NotBlank(message = "last name cannot be blank")
    @Size(min = 2, max = 50, message = " length of last name must be grather or equal 2 ")
    private String lastName;

    @NotNull
    @Past(message = "date of birth must be in past")
    private LocalDate dateOfBirth;

    @Email(message = "Please type valid email")
    private String email;

    @Size(min = 9, max = 9, message = "phone number length must be 9 ")
    @Pattern(regexp = "\\d{9}", message = "Phone number must contain exactly 9 digits")
    @NotNull(message = "phone number cannot be empty ")
    private String phoneNumber;

    @NotBlank(message = "password cannot be blank ")
    @Size(min = 8, max = 30, message = "Length of password must be between 8 nad 30")
    private String password;

//    @ManyToMany(fetch = FetchType.EAGER)
//    private List<Role> roles = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER) // Pobieramy role od razu
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<UserRole> roles = new HashSet<>();


//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return roles.stream()
//                .map(role -> (GrantedAuthority) () -> "ROLE_" + role.);
//    }
//
//    @Override
//    public String getUsername() {
//        return this.email;
//    }

}
