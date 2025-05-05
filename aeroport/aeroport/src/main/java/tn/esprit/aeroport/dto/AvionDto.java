package tn.esprit.aeroport.dto;



import java.time.LocalDateTime;


public record AvionDto (
         String id,
         String modele,
         int capacite,
         LocalDateTime dateAjout,
         Long aeroportId

)
{}
