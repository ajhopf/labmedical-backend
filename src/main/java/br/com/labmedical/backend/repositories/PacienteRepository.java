package br.com.labmedical.backend.repositories;

import br.com.labmedical.backend.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Paciente findByCpf(String cpf);
    @Query("SELECT p FROM Paciente p WHERE upper(p.nomeCompleto) like :nome%")
    List<Paciente> findByNome(@Param("nome") String nome);
}
