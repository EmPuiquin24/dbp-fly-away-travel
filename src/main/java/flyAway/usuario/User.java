package flyAway.usuario;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @NotNull
    @Size(min = 1, max = 500)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 500)
    private String lastName;

    @NotNull
    @Size(min = 1, max = 8)
    private String password;
}
