package org.devinhouse.senai.API;

import org.devinhouse.senai.API.model.Multa;
import org.devinhouse.senai.API.model.TipoVeiculo;
import org.devinhouse.senai.API.model.Veiculo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class M2S07ListaApplication {

	public static void main(String[] args) {
		SpringApplication.run(M2S07ListaApplication.class, args);
	}

	@Bean
	CommandLineRunner run(APIController apiController) {
		return args -> {

			Veiculo veiculo1 = new Veiculo("ABC-1234", TipoVeiculo.AUTOMOVEL,
					"Bat-Movel", 2022, "preto",null);
			Veiculo veiculo2 = new Veiculo("BCA-4321", TipoVeiculo.ONIBUS,
					"Enterprise", 1960, "prata",null);

			List<Veiculo> veiculos = List.of(veiculo1, veiculo2);
			apiController.getVeiculoRepo().saveAll(veiculos);


			List<Multa> multas = List.of( new Multa("Gothan City", "Farol apagado", 250F, veiculo1),
					new Multa("Gothan City", "Insulfilm", 100F, veiculo1),
					new Multa("Hiper-espaço", "Excesso velocidade", 400F, veiculo2));
			apiController.getMultaRepo().saveAll(multas);
		};
	}



}

