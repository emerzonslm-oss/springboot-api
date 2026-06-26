package pe.upn.spswagger.model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "DNI requerido")
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 dígitos")
    @Column(length = 8, unique = true)
    private String dni;

    @NotBlank(message = "Apellido paterno requerido")
    @Column(name = "apellido_paterno", length = 50)
    private String apellidoPaterno;

    @NotBlank(message = "Apellido materno requerido")
    @Column(name = "apellido_materno", length = 50)
    private String apellidoMaterno;

    @NotBlank(message = "Nombres requerido")
    @Column(length = 100)
    private String nombres;

    @NotBlank(message = "Correo requerido")
    @Column(length = 100, unique = true)
    private String correo;

}