package iscae.mpiag.tp1.etudiant.controllers;

import iscae.mpiag.tp1.etudiant.dtos.EtudiantDto;
import iscae.mpiag.tp1.etudiant.services.EtudiantService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("etudiant")
public class EtudiantController {

    private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping
    public List<EtudiantDto> getAll() {
        return etudiantService.getAll();
    }

    @GetMapping("/{id}")
    public EtudiantDto getById(@PathVariable("id") Long id) {
        return etudiantService.getById(id);
    }

    @PostMapping
    public void add(@Valid @RequestBody EtudiantDto etudiantDto) {
        etudiantService.add(etudiantDto);
    }

    @PutMapping("/{id}")
    public void update(@Valid @RequestBody EtudiantDto etudiantDto, @PathVariable("id") Long id) {
        etudiantService.update(etudiantDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        etudiantService.delete(id);
    }
}
