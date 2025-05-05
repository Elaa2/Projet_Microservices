package tn.esprit.aeroport.services;
import org.springframework.data.domain.Page;
import tn.esprit.aeroport.dto.AeroportDTO;
import tn.esprit.aeroport.dto.AvionDto;

import java.util.List;
import java.util.Map;

public interface IAeroportService {
    AeroportDTO add(AeroportDTO aeroportDTO);
    AeroportDTO update(Long id, Map<Object, Object> fields);
    boolean delete(Long id);
    Page<AeroportDTO> getAeroports(int pageNbr, int pageSize);
    AeroportDTO getAeroport(Long id);
    AeroportDTO getAeroportByNom(String nom);
    AvionDto getAvionDepuisAeroport(String idAvion);

    List<AvionDto> getAvionsAffectes(Long id);

    AvionDto ajouterAvionPourAeroport(Long id, AvionDto avionDto);
}

