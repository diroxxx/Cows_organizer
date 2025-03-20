package com.example.cows.mappers;

import com.example.cows.dtos.CattleRegisterDto;
import com.example.cows.dtos.OwnerRegistrationDto;
import com.example.cows.models.Cattle;
import com.example.cows.models.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CattleMapper {

    Cattle toCattle(CattleRegisterDto cattleRegisterDto);
}
