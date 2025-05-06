package tn.esprit.msAvion.mappers;


import org.mapstruct.Mapper;
import tn.esprit.msAvion.DAO.Entities.Avion;
import tn.esprit.msAvion.dto.AvionDto;

@Mapper(componentModel = "spring")
public interface AvionMapper {
    AvionDto mapToDto(Avion avion);
    Avion mapToEntity(AvionDto avionDto);
}

