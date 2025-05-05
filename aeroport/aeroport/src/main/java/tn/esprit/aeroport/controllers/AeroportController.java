package tn.esprit.aeroport.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import tn.esprit.aeroport.dto.AeroportDTO;
import tn.esprit.aeroport.dto.AvionDto;
import tn.esprit.aeroport.services.IAeroportService;
import jakarta.validation.Valid;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/aeroports")
@RequiredArgsConstructor
public class AeroportController {

    @Autowired
    private IAeroportService aeroportService;


    @PostMapping
    public AeroportDTO add(@Valid @RequestBody AeroportDTO aeroportDTO) {
        System.out.println("DEBUG REÇU : " + aeroportDTO);
        return aeroportService.add(aeroportDTO);
    }

    @PatchMapping("/{id}")
    public AeroportDTO update(@PathVariable Long id, @RequestBody Map<Object, Object> fields) {
        return aeroportService.update(id, fields);
    }

    @GetMapping("/{id}/avions")
    public List<AvionDto> getAvionsPourAeroport(@PathVariable Long id) {
        return aeroportService.getAvionsAffectes(id);
    }

    @PostMapping("/{id}/avions")
    public AvionDto ajouterAvionPourAeroport(@PathVariable Long id, @RequestBody AvionDto avionDto) {
        return aeroportService.ajouterAvionPourAeroport(id, avionDto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return aeroportService.delete(id);
    }

    @GetMapping
    public Page<AeroportDTO> getAeroports(@RequestParam int pageNbr, @RequestParam int pageSize) {
        return aeroportService.getAeroports(pageNbr, pageSize);
    }

    @GetMapping("/{id}")
    public AeroportDTO getAeroport(@PathVariable Long id) {
        return aeroportService.getAeroport(id);
    }

    @GetMapping("/nom/{nom}")
    public AeroportDTO getAeroportByNom(@PathVariable String nom) {
        return aeroportService.getAeroportByNom(nom);
    }

    @GetMapping("/avion/{idAvion}")
    public AvionDto getAvionDepuisAeroport(@PathVariable String idAvion) {
        return aeroportService.getAvionDepuisAeroport(idAvion);
    }
}
