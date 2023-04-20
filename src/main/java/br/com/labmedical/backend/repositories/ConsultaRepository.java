package br.com.labmedical.backend.repositories;

import br.com.labmedical.backend.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    @Query("SELECT c FROM Consulta c WHERE c.paciente.id = :pacienteId")
    List<Consulta> findByPacienteId(@Param("pacienteId") Long pacienteId);
}
