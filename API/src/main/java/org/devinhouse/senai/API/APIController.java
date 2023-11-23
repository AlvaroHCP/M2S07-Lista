package org.devinhouse.senai.API;

import org.devinhouse.senai.API.model.Veiculo;
import org.devinhouse.senai.API.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class APIController {

    @Autowired
    private VeiculoRepository veiculoRepo;

    @PostMapping
    public ResponseEntity<List<Veiculo>> cadastrarVeiculo(@RequestBody @Validated List<Veiculo> veiculos){
        var veiculoCadastrado = veiculos.stream().map(veiculo -> veiculoRepo.save(veiculo)).toList();
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoCadastrado);
    }

}
