package tn.esprit.aeroport.mappers;

import org.mapstruct.Mapper;
import tn.esprit.aeroport.dto.AeroportDTO;
import tn.esprit.aeroport.entities.Aeroport;


@Mapper(componentModel = "spring")
public interface AeroportMapper {
    AeroportDTO toDto(Aeroport aeroport);
    Aeroport toEntity(AeroportDTO aeroportDTO);
}
