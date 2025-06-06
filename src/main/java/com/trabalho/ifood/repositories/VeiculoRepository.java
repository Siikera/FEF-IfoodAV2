package com.trabalho.ifood.repositories;

import com.trabalho.ifood.domains.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    Optional<Veiculo> findBycpf(String cpf);
}
