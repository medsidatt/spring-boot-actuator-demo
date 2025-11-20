package iscae.mpiag.tp1.inscription.services;

import iscae.mpiag.tp1.inscription.dtos.InscriptionDto;
import iscae.mpiag.tp1.dao.entities.InscriptionEntity;
import iscae.mpiag.tp1.dao.repositories.InscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscriptionService {

    private final InscriptionRepository repository;

    public InscriptionService(InscriptionRepository repository) {
        this.repository = repository;
    }

    public List<InscriptionDto> getAll() {
        return repository.findAll().stream()
                .map(InscriptionEntity::toInscriptionDto)
                .collect(Collectors.toList());
    }

    public InscriptionDto getById(Long id) {
        return repository.findById(id)
                .map(InscriptionEntity::toInscriptionDto)
                .orElse(null);
    }

    public void add(InscriptionDto dto) {
        InscriptionEntity entity = new InscriptionEntity();
        entity.setEtudiantId(dto.getEtudiantId());
        entity.setFiliereId(dto.getFiliereId());
        entity.setDateInscription(dto.getDateInscription());
        repository.save(entity);
    }

    public void update(InscriptionDto dto, Long id) {
        InscriptionEntity entity = repository.findById(id).orElse(null);
        if (entity != null) {
            entity.setEtudiantId(dto.getEtudiantId());
            entity.setFiliereId(dto.getFiliereId());
            entity.setDateInscription(dto.getDateInscription());
            repository.save(entity);
        }
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
