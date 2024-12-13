package ma.emsi.graphqlhotel.dto.req;



public record ReservationRequestDTO(
        Long clientId,
        Long chambreId,
        String dateDebut,
        String dateFin,
        String preferences
) {}
