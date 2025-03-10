package com.example.cows.Services;

import com.example.cows.Repositories.UserRepository;
import com.example.cows.dtos.UserCredentialDto;
import com.example.cows.mappers.UserCredentialsDtoMapper;
import com.example.cows.models.UserPerson;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private  final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserPerson> findAll() {
        return userRepository.findAll();
    }
    public Optional<UserCredentialDto> findCredentialByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserCredentialsDtoMapper::userCredentialsDtoMapper);
    }
}
