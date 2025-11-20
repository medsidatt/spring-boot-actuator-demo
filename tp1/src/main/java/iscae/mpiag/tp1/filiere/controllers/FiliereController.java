package iscae.mpiag.tp1.filiere.controllers;

import iscae.mpiag.tp1.filiere.dtos.FiliereDto;
import iscae.mpiag.tp1.filiere.services.FiliereService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("filiere")
public class FiliereController {

    private final FiliereService service;

    public FiliereController(FiliereService service) {
        this.service = service;
    }

    @GetMapping
    public List<FiliereDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public FiliereDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public void add(@RequestBody FiliereDto dto) {
        service.add(dto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody FiliereDto dto) {
        service.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
