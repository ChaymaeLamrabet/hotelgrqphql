package ma.emsi.graphqlhotel.controller;

import lombok.RequiredArgsConstructor;
import ma.emsi.graphqlhotel.dto.req.ClientRequestDTO;
import ma.emsi.graphqlhotel.dto.res.ClientResponseDTO;
import ma.emsi.graphqlhotel.services.ClientService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @QueryMapping
    public List<ClientResponseDTO> findAllClients() {
        return clientService.findAll();
    }

    @QueryMapping
    public ClientResponseDTO findClientById(@Argument Long id) {
        return clientService.findById(id)
                .orElseThrow(() -> new RuntimeException("Client with ID " + id + " not found"));
    }

    @QueryMapping
    public List<ClientResponseDTO> findClientsByKeyword(@Argument String keyword) {
        return clientService.findByEmailOrName(keyword);
    }

    @MutationMapping
    public ClientResponseDTO createClient(@Argument ClientRequestDTO client) {
        return clientService.save(client)
                .orElseThrow(() -> new RuntimeException("Error creating client"));
    }

    @MutationMapping
    public ClientResponseDTO updateClient(@Argument Long id, @Argument ClientRequestDTO client) {
        return clientService.update(client, id)
                .orElseThrow(() -> new RuntimeException("Error  updating client"));
    }

    @MutationMapping
    public ClientResponseDTO deleteClient(@Argument Long id) {
        return clientService.delete(id)
                .orElseThrow(() -> new RuntimeException("Error  deleting client"));
    }
}
