package com.example.cows.Services;

import com.example.cows.Repositories.OwnerRepository;
import com.example.cows.models.Owner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    private  final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }
}
