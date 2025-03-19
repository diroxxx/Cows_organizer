package com.example.cows.Services;

import com.example.cows.Repositories.CattleRepository;
import com.example.cows.models.Cattle;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CattleService {
    private final CattleRepository cattleRepository;


    public CattleService(CattleRepository cattleRepository) {
        this.cattleRepository = cattleRepository;
    }

    public Optional<List<Cattle>> getCattlesByOwnerId(Long ownerId) {
        return cattleRepository.getCattlesByOwnerId(ownerId);
    }

    public Optional<Cattle> getCattleByCattleId(Long cattleId) {
        return cattleRepository.findById(cattleId);
    }

    @Transactional
    public void save(Cattle cattle) {
        cattleRepository.save(cattle);
    }


}
