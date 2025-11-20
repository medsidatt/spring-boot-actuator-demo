package iscae.mpiag.tp1.cours.controllers;

import iscae.mpiag.tp1.cours.dtos.CoursDto;
import iscae.mpiag.tp1.cours.services.CoursService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cours")
public class CoursController {

    private final CoursService service;

    public CoursController(CoursService service) {
        this.service = service;
    }

    @GetMapping
    public List<CoursDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CoursDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public void add(@RequestBody CoursDto dto) {
        service.add(dto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CoursDto dto) {
        service.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
