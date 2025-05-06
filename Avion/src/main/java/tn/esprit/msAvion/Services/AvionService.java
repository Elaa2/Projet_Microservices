package tn.esprit.msAvion.Services;

import lombok.RequiredArgsConstructor;
import tn.esprit.msAvion.DAO.Entities.Avion;
import tn.esprit.msAvion.DAO.Repositories.AvionRepository;
import tn.esprit.msAvion.dto.AvionDto;
import tn.esprit.msAvion.mappers.AvionMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;


import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AvionService implements IAvionService {
    private final AvionRepository avionRepository;
    private final AvionMapper avionMapper;

    @Override
    public List<AvionDto> getAvionsByAeroport(Long aeroportId) {
        return avionRepository.findByAeroportId(aeroportId)
                .stream()
                .map(avionMapper::mapToDto)
                .toList();
    }

    @Override
    public AvionDto add(AvionDto avionDto) {
        Avion avion = avionMapper.mapToEntity(avionDto);
        avion.setDateAjout(LocalDateTime.now());
        return avionMapper.mapToDto(avionRepository.save(avion));
    }

    @Override
    public AvionDto update(String idAvion, Map<Object, Object> fields) {
        Avion avion = avionRepository.findById(idAvion)
                .orElseThrow(() -> new IllegalArgumentException("Avion not found: " + idAvion));

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Avion.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, avion, value);
        });

        return avionMapper.mapToDto(avionRepository.save(avion));
    }

    @Override
    public boolean delete(String idAvion) {
        avionRepository.deleteById(idAvion);
        return !avionRepository.existsById(idAvion);
    }

    @Override
    public Page<AvionDto> getAvions(int pageNbr, int pageSize) {
        return avionRepository.findAll(PageRequest.of(pageNbr, pageSize))
                .map(avionMapper::mapToDto);
    }

    @Override
    public AvionDto getAvion(String id) {
        return avionRepository.findById(id)
                .map(avionMapper::mapToDto)
                .orElseThrow(() -> new IllegalArgumentException("Avion not found"));
    }

    @Override
    public AvionDto getAvionByModele(String modele) {
        return avionRepository.findByModele(modele)
                .map(avionMapper::mapToDto)
                .orElseThrow(() -> new IllegalArgumentException("Avion not found with this modele"));
    }
}
