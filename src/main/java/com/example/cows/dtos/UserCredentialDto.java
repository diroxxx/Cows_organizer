package com.example.cows.dtos;

import com.example.cows.models.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserCredentialDto {
    private final String email;
    private final String password;
    private final Set<String> roles;

    public UserCredentialDto(String email, String password, Set<String> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }


}
