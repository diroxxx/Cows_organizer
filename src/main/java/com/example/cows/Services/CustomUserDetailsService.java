package com.example.cows.Services;

import com.example.cows.dtos.UserCredentialDto;
import com.example.cows.models.Owner;
import com.example.cows.models.UserPerson;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if (email == null || email.isBlank()) {
            throw new UsernameNotFoundException("Invalid email provided.");
        }
        UserPerson userPerson =  userService.findCredentialByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));

        String role;
        if (userPerson instanceof Owner) {
            role = "OWNER";
        } else {
            role = "VET";
        }

        return User.builder()
                .username(userPerson.getEmail())
                .password(userPerson.getPassword())
                .roles(role)
                .build();
    }
}
