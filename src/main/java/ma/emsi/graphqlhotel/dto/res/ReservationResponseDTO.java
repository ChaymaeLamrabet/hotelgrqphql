package ma.emsi.graphqlhotel.dto.res;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationResponseDTO {
    private Long id;
    private ClientResponseDTO client;
    private ChambreResponseDTO chambre;
    private String dateDebut;
    private String dateFin;
    private String preferences;
}