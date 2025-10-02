package flyAway.vuelo;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VueloService {
    private final VueloRepository vueloRepository;
    private final ModelMapper modelMapper;

    public Vuelo createFlight(Vuelo flight) {
        return vueloRepository.save(flight);
    }

    public NewIdDTO findBynumeroDeVuelo(String numeroDeVuelo) {
        return null;
    }

}
