package org.devinhouse.senai.API;

import lombok.Getter;
import org.devinhouse.senai.API.model.Multa;
import org.devinhouse.senai.API.model.Veiculo;
import org.devinhouse.senai.API.repository.MultaRepository;
import org.devinhouse.senai.API.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class APIController {

    @Autowired
    @Getter
    private VeiculoRepository veiculoRepo;
    @Autowired
    @Getter
    private MultaRepository multaRepo;

    @PostMapping("/veiculos")
    public ResponseEntity<List<Veiculo>> cadastrarVeiculo(@RequestBody @Validated List<Veiculo> veiculos){
        var veiculoCadastrado = veiculos.stream().map(veiculo -> veiculoRepo.save(veiculo)).toList();
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoCadastrado);
    }

    @PostMapping("/multas/{placa}")
    public ResponseEntity<List<Multa>> cadastrarMulta(@PathVariable String placa, @RequestBody @Validated List<Multa> multas){
        var multaCadastrada = multas.stream().map(multa -> {
            List<Veiculo> veiculoEncontrado = veiculoRepo.findAll().stream().filter(veiculo -> veiculo.getPlaca().equals(placa)).toList();
            if( ! veiculoEncontrado.isEmpty())
                multa.setVeiculo(veiculoEncontrado.get(0));
            return multaRepo.save(multa);
        }).toList();
        return ResponseEntity.status(HttpStatus.CREATED).body(multaCadastrada);
    }

}
