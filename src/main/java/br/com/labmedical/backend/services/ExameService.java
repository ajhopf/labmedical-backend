package br.com.labmedical.backend.services;

import br.com.labmedical.backend.dtos.exame.ExamePostRequestDto;
import br.com.labmedical.backend.dtos.exame.ExamePutRequestDto;
import br.com.labmedical.backend.dtos.exame.ExameResponseDto;
import br.com.labmedical.backend.mappers.ExameMapper;
import br.com.labmedical.backend.models.Exame;
import br.com.labmedical.backend.models.Paciente;
import br.com.labmedical.backend.repositories.ExameRepository;
import br.com.labmedical.backend.repositories.PacienteRepository;
import br.com.labmedical.backend.services.helpers.CadastroHelper;
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

    public ExameResponseDto getExame(Long identificador) {
        Exame exame = repository.findById(identificador)
                .orElseThrow(() -> new EntityNotFoundException("Não foi possível econtrar um exame com o id " + identificador + "."));

        return mapper.map(exame);
    }

    public ExameResponseDto cadastrarExame(ExamePostRequestDto requestDto) {
        Paciente paciente = pacienteRepository.findById(requestDto.getPacienteId())
                .orElseThrow(() -> new EntityNotFoundException("Exame não cadastrado. Não foi possível encontrar o paciente com id " + requestDto.getPacienteId() + " para vincular ao exame."));

        Exame exame = mapper.map(requestDto);

        String dataEHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

        exame.setHoraEData(dataEHora);
        exame = repository.save(exame);

        return mapper.map(exame);
    }

    public ExameResponseDto atualizarExame(Long identificador, ExamePutRequestDto requestDto) {
        Exame exame = repository.findById(identificador)
                .orElseThrow(() -> new EntityNotFoundException("Não foi possível encontra um exame com o id " + identificador + ". Atualização não realizada."));

        if (CadastroHelper.contemInformacao(requestDto.getNomeDoExame())) {
            exame.setNomeDoExame(requestDto.getNomeDoExame());
        }
        if (CadastroHelper.contemInformacao(requestDto.getTipoDoExame())) {
            exame.setTipoDoExame(requestDto.getTipoDoExame());
        }
        if (CadastroHelper.contemInformacao(requestDto.getLaboratorio())) {
            exame.setLaboratorio(requestDto.getLaboratorio());
        }
        if (CadastroHelper.contemInformacao(requestDto.getArquivoDeExame())) {
            exame.setArquivoDeExame(requestDto.getArquivoDeExame());
        }
        if (CadastroHelper.contemInformacao(requestDto.getResultadoDoExame())) {
            exame.setResultadoDoExame(requestDto.getResultadoDoExame());
        }
        if (requestDto.getPacienteId() != null) {
            Paciente paciente = pacienteRepository.findById(requestDto.getPacienteId())
                    .orElseThrow(() -> new EntityNotFoundException("Atualização de exame não realizada. Não foi possível encontrar um paciente com o id " + requestDto.getPacienteId() + "."));

            exame.setPaciente(paciente);
        }

        exame = repository.save(exame);

        return mapper.map(exame);
    }


}
