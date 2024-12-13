package ma.emsi.graphqlhotel.controller;

import lombok.RequiredArgsConstructor;
import ma.emsi.graphqlhotel.dto.req.ReservationRequestDTO;
import ma.emsi.graphqlhotel.dto.res.ReservationResponseDTO;
import ma.emsi.graphqlhotel.services.ReservationService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @QueryMapping
    public List<ReservationResponseDTO> findAllReservations() {
        return reservationService.findAll();
    }

    @QueryMapping
    public ReservationResponseDTO findReservationById(@Argument Long id) {
        return reservationService.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation with ID " + id + " not found"));
    }

    @MutationMapping
    public ReservationResponseDTO createReservation(@Argument ReservationRequestDTO reservation) {
        return reservationService.save(reservation)
                .orElseThrow(() -> new RuntimeException("Error creating reservation"));
    }
    @MutationMapping
    public ReservationResponseDTO deleteReservation(@Argument Long id) {
        return reservationService.delete(id)
                .orElseThrow(() -> new RuntimeException("Error deleting reservation"));
    }

    @MutationMapping
    public ReservationResponseDTO updateReservation(@Argument Long id, @Argument ReservationRequestDTO reservation) {
        return reservationService.update(reservation, id)
                .orElseThrow(() -> new RuntimeException("Error updating reservation"));
    }


}
