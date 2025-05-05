package tn.esprit.ms.mappers;


import org.mapstruct.Mapper;
import tn.esprit.ms.DAO.Entities.Avion;
import tn.esprit.ms.dto.AvionDto;

@Mapper(componentModel = "spring")
public interface AvionMapper {
    AvionDto mapToDto(Avion avion);
    Avion mapToEntity(AvionDto avionDto);
}

