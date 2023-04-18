package br.com.labmedical.backend.services;

import br.com.labmedical.backend.dtos.estatisticas.EstatisticasDto;
import br.com.labmedical.backend.repositories.ConsultaRepository;
import br.com.labmedical.backend.repositories.ExameRepository;
import br.com.labmedical.backend.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstatisticasService {
    @Autowired
    ConsultaRepository consultaRepository;
    @Autowired
    ExameRepository exameRepository;
    @Autowired
    PacienteRepository pacienteRepository;
    public EstatisticasDto getAllEstatisticas(){
        Integer pacientes = pacienteRepository.findAll().size();
        Integer consultas = consultaRepository.findAll().size();
        Integer exames = exameRepository.findAll().size();

        return new EstatisticasDto(pacientes, consultas, exames);
    }
}
