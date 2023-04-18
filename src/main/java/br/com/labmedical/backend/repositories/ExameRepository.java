package br.com.labmedical.backend.repositories;

import br.com.labmedical.backend.models.Exame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {
    @Query("SELECT e FROM Exame e WHERE e.paciente.id = :pacienteId")
    List<Exame> findByPacienteId(Long pacienteId);
}
