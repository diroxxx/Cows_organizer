package com.example.cows.Services;

import com.example.cows.Repositories.CattleRepository;
import com.example.cows.dtos.CattleRegisterDto;
import com.example.cows.mappers.CattleMapper;
import com.example.cows.models.Cattle;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CattleService {
    private final CattleRepository cattleRepository;
    private final CattleMapper cattleMapper;



    public CattleService(CattleRepository cattleRepository, CattleMapper cattleMapper) {
        this.cattleRepository = cattleRepository;
        this.cattleMapper = cattleMapper;
    }

    public Optional<List<Cattle>> getCattlesByOwnerId(Long ownerId) {
        return cattleRepository.getCattlesByOwnerId(ownerId);
    }

    public Optional<Cattle> getCattleByCattleId(Long cattleId) {
        return cattleRepository.findById(cattleId);
    }

    @Transactional
    public void save(CattleRegisterDto cattleDto) {

        Cattle cattle = cattleMapper.toCattle(cattleDto);

        cattleRepository.save(cattle);
    }


}
