package pe.upn.spswagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upn.spswagger.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    Persona findByDni(String dni);

    Persona findByCorreo(String correo);

}