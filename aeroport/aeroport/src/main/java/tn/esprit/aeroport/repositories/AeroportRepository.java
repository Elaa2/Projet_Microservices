package tn.esprit.aeroport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.aeroport.entities.Aeroport;

import java.util.Optional;

public interface AeroportRepository extends JpaRepository<Aeroport, Long> {
    Optional<Aeroport> findByNom(String nom);
}

