package org.devinhouse.senai.API.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MULTAS")
@NoArgsConstructor
@AllArgsConstructor
public class Multa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String local;
    private String motivo;
    private Float valor;
    @ManyToOne
    @JoinColumn(name = "PLACA", referencedColumnName = "PLACA")
    private Veiculo veiculo;

}