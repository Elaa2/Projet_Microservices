package tn.esprit.ms.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ms.DAO.Entities.Avion;
import tn.esprit.ms.Services.AvionService;
import tn.esprit.ms.Services.IAvionService;
import tn.esprit.ms.dto.AvionDto;

import java.util.List;

@RestController
@RequestMapping("avion")
@AllArgsConstructor
public class AvionController {

    private IAvionService avionService;

    @PostMapping("addAvion")
    static void addAvion(@RequestBody Avion avion){

    };

    @GetMapping("/byAeroport/{aeroportId}")
    public List<AvionDto> getAvionsByAeroport(@PathVariable Long aeroportId) {
        return avionService.getAvionsByAeroport(aeroportId);
    }


}
