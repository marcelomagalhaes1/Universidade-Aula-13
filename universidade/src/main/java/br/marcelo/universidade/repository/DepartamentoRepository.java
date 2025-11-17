package br.marcelo.universidade.repository;

import br.marcelo.universidade.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, UUID> {
}