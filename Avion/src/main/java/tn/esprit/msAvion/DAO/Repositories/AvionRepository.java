package tn.esprit.msAvion.DAO.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.msAvion.DAO.Entities.Avion;

import java.util.List;
import java.util.Optional;


public interface AvionRepository extends MongoRepository<Avion, String> {
    Optional<Avion> findByModele(String modele);

    List<Avion> findByAeroportId(Long aeroportId);

}
