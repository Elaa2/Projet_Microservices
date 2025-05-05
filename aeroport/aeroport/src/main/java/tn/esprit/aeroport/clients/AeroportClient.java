package tn.esprit.aeroport.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import tn.esprit.aeroport.dto.AeroportDTO;

import java.util.Map;

@FeignClient(name = "aeroport-service", url = "http://localhost:8080/api/aeroports")
public interface AeroportClient {

    @PostMapping
    AeroportDTO add(@RequestBody AeroportDTO aeroportDTO);

    @PatchMapping("/{id}")
    AeroportDTO update(@PathVariable("id") Long id, @RequestBody Map<Object, Object> fields);

    @DeleteMapping("/{id}")
    boolean delete(@PathVariable("id") Long id);

    @GetMapping
    Page<AeroportDTO> getAeroports(@RequestParam("pageNbr") int pageNbr,
                                   @RequestParam("pageSize") int pageSize);

    @GetMapping("/{id}")
    AeroportDTO getAeroport(@PathVariable("id") Long id);

    @GetMapping("/nom/{nom}")
    AeroportDTO getAeroportByNom(@PathVariable("nom") String nom);
}
