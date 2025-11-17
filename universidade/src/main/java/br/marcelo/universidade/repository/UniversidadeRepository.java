package br.marcelo.universidade.repository;

import br.marcelo.universidade.model.Universidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface UniversidadeRepository extends JpaRepository<Universidade, UUID> {
}