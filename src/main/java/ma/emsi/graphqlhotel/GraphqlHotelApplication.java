package ma.emsi.graphqlhotel;

import lombok.RequiredArgsConstructor;
import ma.emsi.graphqlhotel.dto.req.ChambreRequestDTO;
import ma.emsi.graphqlhotel.dto.req.ClientRequestDTO;
import ma.emsi.graphqlhotel.dto.req.ReservationRequestDTO;
import ma.emsi.graphqlhotel.services.ChambreService;
import ma.emsi.graphqlhotel.services.ClientService;
import ma.emsi.graphqlhotel.services.ReservationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class GraphqlHotelApplication {
	private final ClientService clientService;
	private final ChambreService chambreService;
	private final ReservationService reservationService;

	public static void main(String[] args) {
		SpringApplication.run(GraphqlHotelApplication.class, args);
	}

	// Using CommandLineRunner to insert sample data after the application starts
	@Bean
	public CommandLineRunner run() {
		return args -> {
			for (int i = 1; i <= 5; i++) {
				clientService.save(new ClientRequestDTO("NomClient" + i, "client" + i + "@gmail.com", "0612345678"));
			}

			for (int i = 1; i <= 5; i++) {
				chambreService.save(new ChambreRequestDTO(Long.valueOf(i),  "SIMPLE" , 180.0 + i, true));
			}
			for (int i = 1; i <= 5; i++) {
				chambreService.save(new ChambreRequestDTO(Long.valueOf(i),  "DOUBLE" , 100.0 + i, true));
			}

			for (int i = 1; i <= 3; i++) {
				reservationService.save(new ReservationRequestDTO(Long.valueOf(i), Long.valueOf(i), "2024-12-02", "2024-12-06","TEXT"));
			}

		};
	}
}
