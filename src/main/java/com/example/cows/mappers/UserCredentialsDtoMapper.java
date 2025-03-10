package com.example.cows.mappers;

import com.example.cows.dtos.UserCredentialDto;
import com.example.cows.models.UserPerson;
import com.example.cows.models.UserRole;

import java.util.Set;
import java.util.stream.Collectors;

public class UserCredentialsDtoMapper {
   public static UserCredentialDto userCredentialsDtoMapper(UserPerson userPerson) {
        String email = userPerson.getEmail();
        String password = userPerson.getPassword();
        Set<String> roles = userPerson.getRoles()
                .stream()
                .map(UserRole::getName)
                .collect(Collectors.toSet());
        return new UserCredentialDto(email, password, roles);
    }
    }

