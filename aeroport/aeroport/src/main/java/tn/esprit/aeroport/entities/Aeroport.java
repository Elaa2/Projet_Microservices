package tn.esprit.aeroport.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "aeroports")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aeroport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String ville;
    private String pays;
    private String codeIATA;
}
