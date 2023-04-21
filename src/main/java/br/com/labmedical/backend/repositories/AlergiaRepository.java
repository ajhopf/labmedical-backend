package br.com.labmedical.backend.repositories;

import br.com.labmedical.backend.models.Alergia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlergiaRepository extends JpaRepository<Alergia, Long> {
    @Query("SELECT a FROM Alergia a WHERE a.paciente.id = :pacienteId")
    List<Alergia> getAlergiasDoPaciente(@Param("pacienteId") Long pacienteId);

}
