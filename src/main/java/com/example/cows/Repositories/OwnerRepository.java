package com.example.cows.Repositories;

import com.example.cows.models.Owner;
import com.example.cows.models.UserPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Optional<Owner> findByEmail(String email);
}
