package iscae.mpiag.tp1.inscription.controllers;

import iscae.mpiag.tp1.inscription.dtos.InscriptionDto;
import iscae.mpiag.tp1.inscription.services.InscriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inscription")
public class InscriptionController {

    private final InscriptionService service;

    public InscriptionController(InscriptionService service) {
        this.service = service;
    }

    @GetMapping
    public List<InscriptionDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public InscriptionDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public void add(@RequestBody InscriptionDto dto) {
        service.add(dto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody InscriptionDto dto) {
        service.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
