package iscae.mpiag.tp1.cours.services;

import iscae.mpiag.tp1.cours.dtos.CoursDto;
import iscae.mpiag.tp1.dao.entities.CoursEntity;
import iscae.mpiag.tp1.dao.repositories.CoursRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoursService {

    private final CoursRepository repository;

    public CoursService(CoursRepository repository) {
        this.repository = repository;
    }

    public List<CoursDto> getAll() {
        return repository.findAll().stream()
                .map(CoursEntity::toCoursDto)
                .collect(Collectors.toList());
    }

    public CoursDto getById(Long id) {
        return repository.findById(id)
                .map(CoursEntity::toCoursDto)
                .orElse(null);
    }

    public void add(CoursDto dto) {
        CoursEntity entity = new CoursEntity();
        entity.setNom(dto.getNom());
        entity.setFiliereId(dto.getFiliereId());
        repository.save(entity);
    }

    public void update(CoursDto dto, Long id) {
        CoursEntity entity = repository.findById(id).orElse(null);
        if (entity != null) {
            entity.setNom(dto.getNom());
            entity.setFiliereId(dto.getFiliereId());
            repository.save(entity);
        }
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
