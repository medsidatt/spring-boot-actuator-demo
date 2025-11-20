package iscae.mpiag.tp1.etudiant.services;

import iscae.mpiag.tp1.dao.entities.EtudiantEntity;
import iscae.mpiag.tp1.dao.repositories.EtudiantRepository;
import iscae.mpiag.tp1.etudiant.dtos.EtudiantDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EtudiantService {

    private final EtudiantRepository repository;

    public EtudiantService(EtudiantRepository repository) {
        this.repository = repository;
    }

    public List<EtudiantDto> getAll() {
        return repository.findAll().stream()
                .map(EtudiantEntity::toEtudiantDto)
                .collect(Collectors.toList());
    }

    public EtudiantDto getById(Long id) {
        return repository.findById(id)
                .map(EtudiantEntity::toEtudiantDto)
                .orElse(null);
    }

    public void add(EtudiantDto dto) {
        EtudiantEntity entity = new EtudiantEntity();
        entity.setPrenom(dto.getPrenom());
        entity.setNom(dto.getNom());
        entity.setTel(dto.getTel());
        entity.setEmail(dto.getEmail());
        entity.setGenreId(dto.getGenreId());
        entity.setFiliereId(dto.getFiliereId());
        repository.save(entity);
    }

    public void update(EtudiantDto dto, Long id) {
        EtudiantEntity entity = repository.findById(id).orElse(null);
        if (entity != null) {
            entity.setPrenom(dto.getPrenom());
            entity.setNom(dto.getNom());
            entity.setTel(dto.getTel());
            entity.setEmail(dto.getEmail());
            entity.setGenreId(dto.getGenreId());
            entity.setFiliereId(dto.getFiliereId());
            repository.save(entity);
        }
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
