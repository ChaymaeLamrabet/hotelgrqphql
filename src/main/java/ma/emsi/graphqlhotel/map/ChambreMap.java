package ma.emsi.graphqlhotel.map;

import ma.emsi.graphqlhotel.dto.req.ChambreRequestDTO;
import ma.emsi.graphqlhotel.dto.res.ChambreResponseDTO;
import ma.emsi.graphqlhotel.entities.Chambre;
import ma.emsi.graphqlhotel.entities.TypeChambre;
import org.springframework.stereotype.Component;

@Component
public class ChambreMap {

    public static ChambreResponseDTO toResponseDTO(Chambre chambre) {
        return ChambreResponseDTO.builder()
                .id(chambre.getId())
                .type(chambre.getType().toString())
                .prix(chambre.getPrix())
                .disponible(chambre.getDisponible())
                .build();
    }

    public static Chambre toEntity(ChambreRequestDTO dto) {
        return Chambre.builder()
                .id(dto.id())
                .type(TypeChambre.valueOf(dto.type()))
                .prix(dto.prix())
                .disponible(dto.disponible())
                .build();
    }
}

