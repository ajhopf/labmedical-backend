package br.com.labmedical.backend.services;

import br.com.labmedical.backend.models.Alergia;
import br.com.labmedical.backend.models.Paciente;
import br.com.labmedical.backend.repositories.AlergiaRepository;
import br.com.labmedical.backend.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlergiaService {
    @Autowired
    AlergiaRepository repository;
    @Autowired
    PacienteRepository pacienteRepository;

    public Alergia criarAlergia(Paciente paciente, String nomeAlergia) {
        Alergia alergia  = new Alergia();

        alergia.setAlergia(nomeAlergia);
        alergia.setPaciente(paciente);

        alergia = repository.save(alergia);

        return alergia;
    }

    public List<String> getAlergiasDePaciente(Long pacienteId) {
        List<Alergia> alergias = repository.getAlergiasDoPaciente(pacienteId);
        List<String> nomesAlergias = new ArrayList<>();

        for (Alergia alergia : alergias) {
            nomesAlergias.add(alergia.getAlergia());
        }

        return nomesAlergias;
    }

    public void deletarAlergiasDePaciente(Paciente paciente) {
        List<Alergia> alergias = repository.findAll();

        for (Alergia alergia : alergias) {
            if (alergia.getPaciente() == paciente) {
                repository.delete(alergia);
            }
        }
    }

}
