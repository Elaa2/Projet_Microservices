package tn.esprit.aeroport.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import tn.esprit.aeroport.clients.AvionClient;
import tn.esprit.aeroport.dto.AeroportDTO;
import tn.esprit.aeroport.dto.AvionDto;
import tn.esprit.aeroport.entities.Aeroport;
import tn.esprit.aeroport.mappers.AeroportMapper;
import tn.esprit.aeroport.repositories.AeroportRepository;


import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AeroportServiceImpl implements IAeroportService {

    private final AeroportRepository aeroportRepository;
    private  final AeroportMapper aeroportMapper;
    private final AvionClient avionClient; // <-- Ajout

    // Exemple de méthode
    @Override
    public AvionDto getAvionDepuisAeroport(String idAvion) {
        return avionClient.getAvionById(idAvion);
    }

    public List<AvionDto> getAvionsAffectes(Long aeroportId) {
        // Vérifie que l'aéroport existe
        if (!aeroportRepository.existsById(aeroportId)) {
            throw new IllegalArgumentException("Aéroport non trouvé");
        }

        return avionClient.getAvionsByAeroport(aeroportId);
    }

    public AvionDto ajouterAvionPourAeroport(Long aeroportId, AvionDto avionDto) {
        Aeroport aeroport = aeroportRepository.findById(aeroportId)
                .orElseThrow(() -> new IllegalArgumentException("Aéroport non trouvé"));

        // Créer un nouvel avionDto avec le champ aeroportId mis à jour
        AvionDto avionAvecAeroport = new AvionDto(
                avionDto.id(),
                avionDto.modele(),
                avionDto.capacite(),
                avionDto.dateAjout(),
                aeroport.getId() // on ajoute l'id de l'aéroport ici
        );

        return avionClient.addAvion(avionAvecAeroport);
    }



    @Override
    @Transactional
    public AeroportDTO add(AeroportDTO aeroportDTO) {
        Aeroport aeroport = aeroportMapper.toEntity(aeroportDTO);
        // Ajouter un log pour vérifier les valeurs avant la sauvegarde
        System.out.println("Aeroport to be saved: " + aeroport);
        return aeroportMapper.toDto(aeroportRepository.save(aeroport));
    }

    @Override
    @Transactional
    public AeroportDTO update(Long id, Map<Object, Object> fields) {
        Aeroport aeroport = aeroportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aéroport non trouvé"));

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Aeroport.class, (String) key);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, aeroport, value);
            }
        });

        return aeroportMapper.toDto(aeroportRepository.save(aeroport));
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        aeroportRepository.deleteById(id);
        return !aeroportRepository.existsById(id);
    }

    @Override
    public Page<AeroportDTO> getAeroports(int pageNbr, int pageSize) {
        return aeroportRepository.findAll(PageRequest.of(pageNbr, pageSize))
                .map(aeroportMapper::toDto);
    }

    @Override
    public AeroportDTO getAeroport(Long id) {
        return aeroportRepository.findById(id)
                .map(aeroportMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Aéroport non trouvé"));
    }

    @Override
    public AeroportDTO getAeroportByNom(String nom) {
        return aeroportRepository.findByNom(nom)
                .map(aeroportMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Aéroport non trouvé avec ce nom"));
    }
}
