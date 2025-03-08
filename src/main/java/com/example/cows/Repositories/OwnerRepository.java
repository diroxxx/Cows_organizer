package com.example.cows.Repositories;

import com.example.cows.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
