package ma.emsi.graphqlhotel.repositories;

import ma.emsi.graphqlhotel.entities.Chambre;
import ma.emsi.graphqlhotel.entities.Client;
import ma.emsi.graphqlhotel.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByChambre(Chambre chambre);
    List<Reservation> findByClient(Client chambre);

}
