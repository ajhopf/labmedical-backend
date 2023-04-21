package br.com.labmedical.backend.repositories;

import br.com.labmedical.backend.models.CuidadoEspecifico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuidadoEspecificoRepository extends JpaRepository<CuidadoEspecifico, Long> {
    @Query("SELECT c FROM CuidadoEspecifico c WHERE c.paciente.id = :pacienteId")
    List<CuidadoEspecifico> getCuidadosDoPaciente(@Param("pacienteId") Long pacienteId);
}
