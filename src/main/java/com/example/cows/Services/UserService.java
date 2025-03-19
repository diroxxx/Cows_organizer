package com.example.cows.Services;

import com.example.cows.Repositories.OwnerRepository;
import com.example.cows.Repositories.UserRepository;
import com.example.cows.dtos.OwnerRegistrationDto;
import com.example.cows.dtos.UserCredentialDto;
import com.example.cows.mappers.OwnerMapper;
import com.example.cows.models.Owner;
import com.example.cows.models.UserPerson;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private  final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, OwnerRepository ownerRepository, OwnerMapper ownerMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.ownerRepository = ownerRepository;
        this.ownerMapper = ownerMapper;
    }

    public List<UserPerson> findAll() {
        return userRepository.findAll();
    }
    public Optional<UserPerson> findCredentialByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<Owner> findOwnerByEmail(String email) {
        return ownerRepository.findByEmail(email);
    }


    @Transactional
    public void registerOwner(OwnerRegistrationDto ownerDto) {
        Optional<Owner> existingUser = ownerRepository.findByEmail(ownerDto.getEmail());

        if (existingUser.isPresent()) {
            throw new RuntimeException("User with this email already exists!");
        }

        Owner owner = ownerMapper.toOwner(ownerDto);
        owner.setPassword(passwordEncoder.encode(ownerDto.getPassword()));

        ownerRepository.save(owner);
    }
}
