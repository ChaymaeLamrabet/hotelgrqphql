package ma.emsi.graphqlhotel.map;

import ma.emsi.graphqlhotel.dto.req.ClientRequestDTO;
import ma.emsi.graphqlhotel.dto.res.ClientResponseDTO;
import ma.emsi.graphqlhotel.entities.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMap {

    public static ClientResponseDTO toResponseDTO(Client client) {
        return ClientResponseDTO.builder()
                .id(client.getId())
                .nom(client.getNom())
                .email(client.getEmail())
                .tel(client.getTel())
                .build();
    }

    public static Client toEntity(ClientRequestDTO dto) {
        return Client.builder()
                .nom(dto.nom())
                .email(dto.email())
                .tel(dto.tel())
                .build();
    }
}
