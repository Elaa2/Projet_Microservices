package tn.esprit.msAvion.Services;



import org.springframework.data.domain.Page;
import tn.esprit.msAvion.dto.AvionDto;

import java.util.List;
import java.util.Map;

public interface IAvionService {
    AvionDto add(AvionDto avionDto);
    AvionDto update(String idAvion, Map<Object,Object> fields);
    boolean delete(String idAvion);
    Page<AvionDto> getAvions(int pageNbr, int pageSize);
    AvionDto getAvion(String id);
    AvionDto getAvionByModele(String modele);
    List<AvionDto> getAvionsByAeroport(Long aeroportId);

}

