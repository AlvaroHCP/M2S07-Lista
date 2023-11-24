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
					"Bat-Movel", 2022, "preto", null);
			Veiculo veiculo2 = new Veiculo("BCA-4321", TipoVeiculo.ONIBUS,
					"Enterprise", 1960, "prata", null);

			if(apiController.getVeiculoRepo().findAll().isEmpty()) {
				List<Veiculo> veiculos = List.of(veiculo1, veiculo2);
				apiController.getVeiculoRepo().saveAll(veiculos);
			}


			Multa multa1 = new Multa("Gothan City", "Farol apagado", 250F, veiculo1);
			Multa multa2 = new Multa("Gothan City", "Insulfilm", 100F, veiculo1);
			Multa multa3 = new Multa("Hiper-espaço", "Excesso velocidade", 400F, veiculo2);

			if(apiController.getMultaRepo().findAll().isEmpty()) {
				List<Multa> multas = List.of(multa1, multa2, multa3);
				apiController.getMultaRepo().saveAll(multas);
			}

			Multa multaGravada = apiController.getMultaRepo().findAll().stream()
					.filter(multa -> multa.getValor().equals(400F)).toList().get(0);
			if (multaGravada.getValor().equals(multa3.getValor())) {
				multaGravada.setValor(380F);
				apiController.getMultaRepo().save(multaGravada);
			}

			List<Veiculo> veiculosGravados = apiController.getVeiculoRepo().findAll();
			System.out.println(veiculosGravados);

		};
	}


}

