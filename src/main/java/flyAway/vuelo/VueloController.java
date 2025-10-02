package flyAway.vuelo;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class VueloController {
    private final VueloService service;

    @PostMapping()
    public ResponseEntity<NewIdDTO> createFlight(@Valid NewIdDTO flight) {
        NewIdDTO createdFlight = service.createFlight(flight);
        return ResponseEntity.ok(createdFlight);
    }

    @GetMapping("/search") //protegido
    public ResponseEntity<NewIdDTO> encontrarPorNumeroDeVuelo(@Valid String numeroDeVuelo) {
        NewIdDTO flight = service.findBynumeroDeVuelo(numeroDeVuelo);
        return ResponseEntity.ok(flight);
    }


}
