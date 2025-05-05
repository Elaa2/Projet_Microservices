package tn.esprit.aeroport.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.aeroport.dto.AvionDto;

import java.util.List;

@FeignClient(name = "Ms", url = "http://localhost:9091") // le nom doit correspondre à spring.application.name de MS avion
public interface AvionClient {

    @GetMapping("/avion/{id}")
    AvionDto getAvionById(@PathVariable("id") String id);

    @GetMapping("/avion/byAeroport/{aeroportId}")
    List<AvionDto> getAvionsByAeroport(@PathVariable("aeroportId") Long aeroportId);

    @PostMapping("/avion/addAvion")
    AvionDto addAvion(@RequestBody AvionDto avionDto);


}
