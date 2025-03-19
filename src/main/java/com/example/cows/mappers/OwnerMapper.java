package com.example.cows.mappers;

import com.example.cows.dtos.OwnerRegistrationDto;
import com.example.cows.models.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface OwnerMapper {


    @Mapping(target = "password", ignore = true)
    Owner toOwner(OwnerRegistrationDto registrationDto);

//    public  Owner  toOwnerMapper(OwnerRegistrationDto ownerDto, PasswordEncoder passwordEncoder) {
//        Owner owner = new Owner();
//        owner.setFirstName(ownerDto.getFirstName());
//        owner.setLastName(ownerDto.getLastName());
//        owner.setDateOfBirth(ownerDto.getDateOfBirth());
//        owner.setEmail(ownerDto.getEmail());
//        owner.setPhoneNumber(ownerDto.getPhoneNumber());
//        owner.setPassword(passwordEncoder.encode(ownerDto.getPassword()));
//        owner.setAddress(ownerDto.getAddress());
//        return owner;
//    }


}
