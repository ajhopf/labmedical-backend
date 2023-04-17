package br.com.labmedical.backend.repositories;

import br.com.labmedical.backend.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Medico findByCpf(String cpf);
}
