package tn.esprit.ms.DAO.Entities;


import lombok.*;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Avion {

    @Id
    @Indexed(unique=true)
    @Setter(AccessLevel.MODULE)
    private String id;


    private String modele;
    private int capacite;

    private LocalDateTime dateAjout;
    private Long aeroportId; // identifiant de l'aéroport auquel cet avion est affecté


}

