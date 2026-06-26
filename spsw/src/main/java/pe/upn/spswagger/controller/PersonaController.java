package pe.upn.spswagger.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import pe.upn.spswagger.dto.PersonaDTO;
import pe.upn.spswagger.service.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    private final PersonaService service;

    public PersonaController(PersonaService service) {
        this.service = service;
    }

    @GetMapping
    public Page<PersonaDTO> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @GetMapping("/{id}")
    public PersonaDTO obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public PersonaDTO crear(@Valid @RequestBody PersonaDTO dto) {
        return service.crear(dto);
    }

    @PutMapping("/{id}")
    public PersonaDTO actualizar(
            @PathVariable Long id,
            @Valid @RequestBody PersonaDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @PostMapping("/sembrar")
    public String sembrar() {
        int cantidad = service.sembrarDatosDemo();
        if (cantidad == 0) {
            return "Ya existen datos en la base de datos";
        }
        return "Se sembraron " + cantidad + " personas correctamente";
    }

}