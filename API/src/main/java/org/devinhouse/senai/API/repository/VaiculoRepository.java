package org.devinhouse.senai.API.repository;

import org.devinhouse.senai.API.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaiculoRepository extends JpaRepository<Veiculo, Integer> {
}
