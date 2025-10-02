package flyAway.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserDto {

    @NotNull
    @Size(min = 1)
    @Pattern(regexp = ".*[A-Z].*", message = "First name debe tener al menos una mayúscula")
    private String firstName;

    @NotNull
    @Size(min = 1)
    @Pattern(regexp = ".*[A-Z].*", message = "Last name debe tener al menos una mayúscula")
    private String lastName;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 8, message = "La contraseña debe tener mínimo 8 caracteres")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d).{8,}$",
            message = "La contraseña debe tener al menos una letra y un número")
    private String password;
}
