package atl.bootcamp.e9.savorspot;

import atl.bootcamp.e9.savorspot.dto.RegisterFoodStallDto;
import atl.bootcamp.e9.savorspot.service.RegisterFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SavorSpotApplication implements CommandLineRunner {

	@Autowired
	private RegisterFoodService registerFoodService;


	public static void main(String[] args) {
		SpringApplication.run(SavorSpotApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		registerFoodService.create(
				new RegisterFoodStallDto(
						"Alejandro Fernandez",
						"alejandro@email.com",
						"12345678",
						"El rincón del sabor",
						"Calle número 1234",
						"Comidas caseras",
						"desde 08:00hs hasta 00:00hs ",
						"1234345678",
						null,
						null,
						null
				)
		);
	}
}
