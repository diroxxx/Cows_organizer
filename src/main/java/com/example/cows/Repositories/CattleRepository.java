package com.example.cows.Repositories;

import com.example.cows.models.Cattle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CattleRepository extends JpaRepository<Cattle, Long> {
    public Optional<List<Cattle>> getCattlesByOwnerId(Long ownerId);
}
