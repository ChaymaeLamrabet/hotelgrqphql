package ma.emsi.graphqlhotel.map;

import ma.emsi.graphqlhotel.dto.res.ReservationResponseDTO;
import ma.emsi.graphqlhotel.entities.Reservation;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
@Component
public class ReservationMap {

        private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static ReservationResponseDTO toResponseDTO(Reservation reservation) {
        return ReservationResponseDTO.builder()
                .id(reservation.getId())
                .client(ClientMap.toResponseDTO(reservation.getClient()))
                .chambre(ChambreMap.toResponseDTO(reservation.getChambre()))
                .dateDebut(DATE_FORMATTER.format(reservation.getDatedebut()))
                .dateFin(DATE_FORMATTER.format(reservation.getDatefin()))
                .preferences(reservation.getPreferences())
                .build();
    }


}
