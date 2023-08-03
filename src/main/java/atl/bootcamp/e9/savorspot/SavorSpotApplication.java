package atl.bootcamp.e9.savorspot;

import atl.bootcamp.e9.savorspot.dto.RegisterUserFoodStallDto;
import atl.bootcamp.e9.savorspot.dto.UserFoodStallDto;
import atl.bootcamp.e9.savorspot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
public class SavorSpotApplication implements CommandLineRunner {

	@Autowired
	private RegisterFoodStallService registerFoodService;
	@Autowired
	private ListAllFoodStallService listAllFoodStallService;
	@Autowired
	private FindUserFoodStallByIdService findUserFoodStallByIdService;
	@Autowired
	private UpdateFoodStallService updateFoodStallService;
	@Autowired
	private DeleteFoodStallByIdService deleteFoodStallByIdService;


	public static void main(String[] args) {
		SpringApplication.run(SavorSpotApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		registerFoodService.register(
				new RegisterUserFoodStallDto(
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
