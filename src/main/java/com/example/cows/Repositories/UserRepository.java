package com.example.cows.Repositories;

import com.example.cows.models.UserPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserPerson, Long> {
    Optional<UserPerson> findByEmail(String email);
}
