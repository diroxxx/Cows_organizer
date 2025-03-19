package com.example.cows.Services;

import com.example.cows.Repositories.CattleRepository;
import com.example.cows.Repositories.OwnerRepository;
import com.example.cows.dtos.CattleRegisterDto;
import com.example.cows.mappers.CattleMapper;
import com.example.cows.models.Cattle;
import com.example.cows.models.Owner;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;
    private final CattleRepository cattleRepository;

    public OwnerService(OwnerRepository ownerRepository, CattleRepository cattleRepository) {
        this.ownerRepository = ownerRepository;
        this.cattleRepository = cattleRepository;
    }

    public Optional<Owner> findOwnerByEmail(String email) {
        return ownerRepository.findByEmail(email);
    }

}
