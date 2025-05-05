package tn.esprit.ms.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AvionDto {
    private String id;
    private String modele;
    private int capacite;
    private LocalDateTime dateAjout;
    private Long aeroportId;
}