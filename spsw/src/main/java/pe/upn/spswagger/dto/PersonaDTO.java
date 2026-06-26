package pe.upn.spswagger.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Datos de la persona")
public class PersonaDTO {

    @NotBlank(message = "DNI requerido")
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 dígitos")
    @Schema(description = "DNI de la persona", example = "12345678")
    private String dni;

    @NotBlank(message = "Apellido paterno requerido")
    @Size(max = 50, message = "Máximo 50 caracteres")
    @Schema(description = "Apellido paterno", example = "García")
    private String apellidoPaterno;

    @NotBlank(message = "Apellido materno requerido")
    @Size(max = 50, message = "Máximo 50 caracteres")
    @Schema(description = "Apellido materno", example = "López")
    private String apellidoMaterno;

    @NotBlank(message = "Nombres requerido")
    @Size(max = 100, message = "Máximo 100 caracteres")
    @Schema(description = "Nombres completos", example = "Juan Carlos")
    private String nombres;

    @NotBlank(message = "Correo requerido")
    @Size(max = 100, message = "Máximo 100 caracteres")
    @Schema(description = "Correo electrónico", example = "juan@correo.com")
    private String correo;

}