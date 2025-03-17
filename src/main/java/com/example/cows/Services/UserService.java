package com.example.cows.Services;

import com.example.cows.Repositories.OwnerRepository;
import com.example.cows.Repositories.UserRepository;
import com.example.cows.dtos.UserCredentialDto;
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
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private OwnerRepository ownerRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, OwnerRepository ownerRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.ownerRepository = ownerRepository;
    }

    public List<UserPerson> findAll() {
        return userRepository.findAll();
    }
    public Optional<UserPerson> findCredentialByEmail(String email) {
        return userRepository.findByEmail(email);
//                .map(UserCredentialsDtoMapper::userCredentialsDtoMapper);
    }

    @Transactional
    public void registerOwner(String firstName, String lastName, LocalDate dateOfBirth,
                               String email, String phoneNumber,
                              String password, String address) {

        Optional<UserPerson> existingUser = userRepository.findByEmail(email);
        System.out.println(existingUser.isPresent());

        if (existingUser.isPresent()) {
            logger.error("User with email {} already exists!", email);
            throw new RuntimeException("User with this email already exists!");
        }

        Owner owner = new Owner();
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        owner.setDateOfBirth(dateOfBirth);
        owner.setEmail(email);
        owner.setPhoneNumber(phoneNumber);
        owner.setPassword(passwordEncoder.encode(password));
        owner.setAddress(address);
//        System.out.println("asdasdasdasd");


        userRepository.saveAndFlush(owner);
    }
}
