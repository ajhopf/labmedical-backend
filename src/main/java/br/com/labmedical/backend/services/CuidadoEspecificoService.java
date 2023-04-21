package br.com.labmedical.backend.services;

import br.com.labmedical.backend.models.CuidadoEspecifico;
import br.com.labmedical.backend.models.Paciente;
import br.com.labmedical.backend.repositories.CuidadoEspecificoRepository;
import br.com.labmedical.backend.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CuidadoEspecificoService {
    @Autowired
    CuidadoEspecificoRepository repository;
    @Autowired
    PacienteRepository pacienteRepository;

    public CuidadoEspecifico cadastrarCuidado(Paciente paciente, String cuidadoNome) {
        CuidadoEspecifico cuidado  = new CuidadoEspecifico();

        cuidado.setCuidadoEspecial(cuidadoNome);
        cuidado.setPaciente(paciente);

        cuidado = repository.save(cuidado);

        return cuidado;
    }

    public List<String> getCuidadosDePaciente(Long pacienteId) {
        List<CuidadoEspecifico> cuidadoEspecificos = repository.getCuidadosDoPaciente(pacienteId);
        List<String> nomesCuidados = new ArrayList<>();

        for (CuidadoEspecifico cuidado : cuidadoEspecificos) {
            nomesCuidados.add(cuidado.getCuidadoEspecial());
        }

        return nomesCuidados;
    }

    public void deletarCuidadosDePaciente(Paciente paciente) {
        List<CuidadoEspecifico> cuidadosEspecificos = repository.findAll();

        for (CuidadoEspecifico cuidado : cuidadosEspecificos) {
            if (cuidado.getPaciente() == paciente) {
                repository.delete(cuidado);
            }
        }
    }
}
