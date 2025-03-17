package com.example.cows.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserCredentialDto {
    private final String email;
    private final String password;
    private Set<String> roles = Set.of();

    public UserCredentialDto(String email, String password) {
        this.email = email;
        this.password = password;
    }


}
