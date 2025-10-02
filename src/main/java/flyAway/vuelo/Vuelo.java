package flyAway.vuelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Vuelo {
    @Id
    @Column(unique = true, nullable = false)
    private String flightNumber;

    @Check(constraints = "horaSalida < horaLlegada")
    @Column(nullable = false)
    private Date horaSalida;

    @Column(nullable = false)
    private Date horaLlegada;

    @Column(nullable = false)
    @Check(constraints = "asientosDisponibles > 0")
    private Integer availableSeats;

    //Dani : por corroborar
    @Column(nullable = false)
    private String airlineName;

}
