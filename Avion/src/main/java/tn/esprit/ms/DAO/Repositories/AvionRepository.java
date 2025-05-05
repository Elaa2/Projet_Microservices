package tn.esprit.ms.DAO.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.ms.DAO.Entities.Avion;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface AvionRepository extends MongoRepository<Avion, String> {
    Optional<Avion> findByModele(String modele);

    List<Avion> findByAeroportId(Long aeroportId);

}
