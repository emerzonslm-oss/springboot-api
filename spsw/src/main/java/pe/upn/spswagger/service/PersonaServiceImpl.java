package pe.upn.spswagger.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.upn.spswagger.dto.PersonaDTO;
import pe.upn.spswagger.model.Persona;
import pe.upn.spswagger.repository.PersonaRepository;
import pe.upn.spswagger.seeder.PersonaSeeder;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository repo;
    private final PersonaSeeder seeder;

    public PersonaServiceImpl(PersonaRepository repo, PersonaSeeder seeder) {
        this.repo = repo;
        this.seeder = seeder;
    }

    @Override
    public Page<PersonaDTO> listar(Pageable pageable) {
        return repo.findAll(pageable).map(this::toDTO);
    }

    @Override
    public PersonaDTO obtenerPorId(Long id) {
        Persona persona = repo.findById(id.intValue()).orElse(null);
        if (persona == null) return null;
        return toDTO(persona);
    }

    @Override
    public PersonaDTO crear(PersonaDTO dto) {
        Persona persona = toEntity(dto);
        return toDTO(repo.save(persona));
    }

    @Override
    public PersonaDTO actualizar(Long id, PersonaDTO dto) {
        Persona persona = repo.findById(id.intValue()).orElse(null);
        if (persona == null) return null;
        persona.setDni(dto.getDni());
        persona.setApellidoPaterno(dto.getApellidoPaterno());
        persona.setApellidoMaterno(dto.getApellidoMaterno());
        persona.setNombres(dto.getNombres());
        persona.setCorreo(dto.getCorreo());
        return toDTO(repo.save(persona));
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id.intValue());
    }

    @Override
    public int sembrarDatosDemo() {
        if (repo.count() > 0) return 0;
        List<Persona> personas = seeder.obtenerPersonasDemo();
        repo.saveAll(personas);
        return personas.size();
    }

    private PersonaDTO toDTO(Persona p) {
        PersonaDTO dto = new PersonaDTO();
        dto.setDni(p.getDni());
        dto.setApellidoPaterno(p.getApellidoPaterno());
        dto.setApellidoMaterno(p.getApellidoMaterno());
        dto.setNombres(p.getNombres());
        dto.setCorreo(p.getCorreo());
        return dto;
    }

    private Persona toEntity(PersonaDTO dto) {
        Persona persona = new Persona();
        persona.setDni(dto.getDni());
        persona.setApellidoPaterno(dto.getApellidoPaterno());
        persona.setApellidoMaterno(dto.getApellidoMaterno());
        persona.setNombres(dto.getNombres());
        persona.setCorreo(dto.getCorreo());
        return persona;
    }

}