package tn.esprit.aeroport.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AeroportDTO {
    private Long id;
    private String nom;
    private String ville;
    private String pays;

    @JsonProperty("codeIATA")
    private String codeIATA;
}
