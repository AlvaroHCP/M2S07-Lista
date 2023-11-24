package org.devinhouse.senai.API.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "VEICULOS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Veiculo {
    @Id
    private String placa;
    @Enumerated(EnumType.STRING)
    private TipoVeiculo tipo;
    private String nome;
    private Integer anoFabricacao;
    private String cor;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "veiculo")
    private List<Multa> multas;

    public Veiculo(String placa){
        this.placa = placa;
    }
}
