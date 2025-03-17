package com.example.cows.mappers;

import com.example.cows.dtos.UserCredentialDto;
import com.example.cows.models.UserPerson;

import java.util.Set;
import java.util.stream.Collectors;

public class UserCredentialsDtoMapper {
   public static UserCredentialDto userCredentialsDtoMapper(UserPerson userPerson) {
        String email = userPerson.getEmail();
        String password = userPerson.getPassword();
        return new UserCredentialDto(email, password);
    }
    }

