package br.com.labmedical.backend.services;

import br.com.labmedical.backend.dtos.exame.ExamePostRequestDto;
import br.com.labmedical.backend.dtos.exame.ExameResponseDto;
import br.com.labmedical.backend.mappers.ExameMapper;
import br.com.labmedical.backend.models.Exame;
import br.com.labmedical.backend.models.Paciente;
import br.com.labmedical.backend.repositories.ExameRepository;
import br.com.labmedical.backend.repositories.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ExameService {
    @Autowired
    ExameRepository repository;
    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    ExameMapper mapper;

    public ExameResponseDto cadastrarExame(ExamePostRequestDto requestDto) {
        Paciente paciente = pacienteRepository.findById(requestDto.getPacienteId())
                .orElseThrow(() -> new EntityNotFoundException("Exame não cadastrado. Não foi possível encontrar o paciente com id " + requestDto.getPacienteId() + " para vincular ao exame."));

        Exame exame = mapper.map(requestDto);

        String dataEHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

        exame.setHoraEData(dataEHora);
        exame = repository.save(exame);

        return mapper.map(exame);
    }
}
