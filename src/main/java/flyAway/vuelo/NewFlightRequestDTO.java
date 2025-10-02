package flyAway.vuelo;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.time.ZonedDateTime;

//Dani : para endpoint GET byAirline
@Getter
@Setter
@NoArgsConstructor
public class NewFlightRequestDTO {
    private String numeroDeVuelo;

    @Check(constraints = "horaSalida < horaLlegada")
    @NotNull
    private ZonedDateTime horaSalida;

    @NotNull
    private ZonedDateTime horaLlegada;

    @NotNull
    @Check(constraints = "numeroDeVueloUnicos > 0")
    private Integer numeroDeVueloUnicos;

}
