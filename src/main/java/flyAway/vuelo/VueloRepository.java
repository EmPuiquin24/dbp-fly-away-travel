package flyAway.vuelo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {
    NewIdDTO findBynumeroDeVuelo (String numeroDeVuelo);
}
