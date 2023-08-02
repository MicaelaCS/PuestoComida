package atl.bootcamp.e9.savorspot;

import atl.bootcamp.e9.savorspot.dto.RegisterUserFoodStallDto;
import atl.bootcamp.e9.savorspot.dto.UserFoodStallDto;
import atl.bootcamp.e9.savorspot.service.FindUserFoodStallByIdService;
import atl.bootcamp.e9.savorspot.service.ListAllFoodStallService;
import atl.bootcamp.e9.savorspot.service.RegisterFoodStallService;
import atl.bootcamp.e9.savorspot.service.UpdateFoodStallService;
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


	public static void main(String[] args) {
		SpringApplication.run(SavorSpotApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		registerFoodService.create(
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

		listAllFoodStallService.list(Pageable.ofSize(10)).forEach(System.out::println);
		var result = findUserFoodStallByIdService.findWith(1L);
		System.out.println(result);
		updateFoodStallService.update(new UserFoodStallDto(
				1L,
				"Alex Pérez",
				"alejandro@email.com",
				"El rincón del sabor",
				"Calle número 3456",
				"Comidas Caseras y Ricas",
				"desde 08:00hs hasta 01:00hs ",
				"1234345678",
				null,
				null,
				null
		));
		var result2 = findUserFoodStallByIdService.findWith(1L);
		System.out.println(result2);

	}
}
