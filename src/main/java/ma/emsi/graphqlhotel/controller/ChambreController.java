package ma.emsi.graphqlhotel.controller;

import lombok.RequiredArgsConstructor;
import ma.emsi.graphqlhotel.dto.req.ChambreRequestDTO;
import ma.emsi.graphqlhotel.dto.res.ChambreResponseDTO;
import ma.emsi.graphqlhotel.services.ChambreService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChambreController {

    private final ChambreService chambreService;

    @QueryMapping
    public List<ChambreResponseDTO> findAllChambres() {
        return chambreService.findAll();
    }

    @MutationMapping
    public ChambreResponseDTO createChambre(@Argument ChambreRequestDTO chambre) {
        return chambreService.save(chambre).orElseThrow(() -> new RuntimeException("Error creating chambre"));
    }

    @MutationMapping
    public ChambreResponseDTO deleteChambre(@Argument Long id) {
        return chambreService.delete(id).orElseThrow(() -> new RuntimeException("Error deleting chambre"));
    }

    @QueryMapping
    public ChambreResponseDTO findChambreById(@Argument Long id) {
        return chambreService.findById(id).orElseThrow(() -> new RuntimeException("Chambre not found"));
    }


    @MutationMapping
    public ChambreResponseDTO updateChambre(@Argument Long id, @Argument ChambreRequestDTO chambre) {
        return chambreService.update(chambre, id).orElseThrow(() -> new RuntimeException("Error updating chambre"));
    }
}
