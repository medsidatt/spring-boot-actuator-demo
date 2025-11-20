package iscae.mpiag.tp1.filiere.services;

import iscae.mpiag.tp1.dao.entities.FiliereEntity;
import iscae.mpiag.tp1.dao.repositories.FiliereRepository;
import iscae.mpiag.tp1.filiere.dtos.FiliereDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FiliereService {

    private final FiliereRepository repository;

    public FiliereService(FiliereRepository repository) {
        this.repository = repository;
    }

    public List<FiliereDto> getAll() {
        return repository.findAll().stream()
                .map(FiliereEntity::toFiliereDto)
                .collect(Collectors.toList());
    }

    public FiliereDto getById(Long id) {
        return repository.findById(id)
                .map(FiliereEntity::toFiliereDto)
                .orElse(null);
    }

    public void add(FiliereDto dto) {
        FiliereEntity entity = new FiliereEntity();
        entity.setNom(dto.getNom());
        repository.save(entity);
    }

    public void update(FiliereDto dto, Long id) {
        FiliereEntity entity = repository.findById(id).orElse(null);
        if (entity != null) {
            entity.setNom(dto.getNom());
            repository.save(entity);
        }
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
