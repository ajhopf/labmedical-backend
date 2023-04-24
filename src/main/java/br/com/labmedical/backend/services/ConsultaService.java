package br.com.labmedical.backend.services;

import br.com.labmedical.backend.dtos.consulta.ConsultaPostRequestDto;
import br.com.labmedical.backend.dtos.consulta.ConsultaPutRequestDto;
import br.com.labmedical.backend.dtos.consulta.ConsultaResponseDto;
import br.com.labmedical.backend.mappers.ConsultaMapper;
import br.com.labmedical.backend.models.Consulta;
import br.com.labmedical.backend.models.Usuario;
import br.com.labmedical.backend.models.Paciente;
import br.com.labmedical.backend.repositories.ConsultaRepository;
import br.com.labmedical.backend.repositories.UsuarioRepository;
import br.com.labmedical.backend.repositories.PacienteRepository;
import br.com.labmedical.backend.services.helpers.CadastroHelper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ConsultaService {
    @Autowired
    ConsultaRepository repository;
    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ConsultaMapper mapper;

    public ConsultaResponseDto getConsulta(Long identificador) {
        Consulta consulta = repository.findById(identificador)
                .orElseThrow(() -> new EntityNotFoundException("Não foi possível econtrar uma consulta com o id " + identificador + "."));

        return mapper.map(consulta);
    }

    public ConsultaResponseDto cadastrarConsulta(ConsultaPostRequestDto requestDto) {
        Paciente paciente = pacienteRepository.findById(requestDto.getPacienteId())
                .orElseThrow(() -> new EntityNotFoundException("A consulta não foi cadastrada pois não foi possível encontrar um paciente com o id " + requestDto.getPacienteId() + "."));

        Usuario usuario = usuarioRepository.findById(requestDto.getMedicoId())
                .orElseThrow(() -> new EntityNotFoundException("A consulta não foi cadastrada pois não foi possível encontrar um medico com o id " + requestDto.getMedicoId() + "."));

        Consulta consulta = mapper.map(requestDto);

        String dataEHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

        consulta.setHoraEData(dataEHora);
        consulta = repository.save(consulta);
//        consulta.setPaciente(paciente);

        return mapper.map(consulta);
    }

    public ConsultaResponseDto atualizarConsulta(Long identificador, ConsultaPutRequestDto requestDto) {
        Consulta consulta = repository.findById(identificador)
                .orElseThrow(() -> new EntityNotFoundException("Não foi possível encontrar uma consulta com o id " + identificador + ". Atualização não realizada."));

        if (CadastroHelper.contemInformacao(requestDto.getMotivoDaConsulta())) {
            consulta.setMotivoDaConsulta(requestDto.getMotivoDaConsulta());
        }
        if (CadastroHelper.contemInformacao(requestDto.getDescricaoDoProblema())) {
            consulta.setDescricaoDoProblema(requestDto.getDescricaoDoProblema());
        }
        if (CadastroHelper.contemInformacao(requestDto.getMedicacaoReceitada())) {
            consulta.setMedicacaoReceitada(requestDto.getMedicacaoReceitada());
        }
        if(CadastroHelper.contemInformacao(requestDto.getDosagensEPrecaucoes())) {
            consulta.setDosagensEPrecaucoes(requestDto.getDosagensEPrecaucoes());
        }
        if (requestDto.getPacienteId() != null) {
            Paciente paciente = pacienteRepository.findById(requestDto.getPacienteId())
                    .orElseThrow(() -> new EntityNotFoundException("Atualização de consulta não realizada. Não foi possível encontrar um paciente com o id " + requestDto.getPacienteId() + "."));

            consulta.setPaciente(paciente);
        }
        if (requestDto.getMedicoId() != null) {
            Usuario usuario = usuarioRepository.findById(requestDto.getMedicoId())
                    .orElseThrow(() -> new EntityNotFoundException("Atualização de consulta não realizada. Não foi possível encontrar um médico com o id " + requestDto.getMedicoId() + "."));

            consulta.setMedico(usuario);
        }

        consulta = repository.save(consulta);

        return mapper.map(consulta);
    }

    public void deletarConsulta(Long identificador) {
        Consulta consulta = repository.findById(identificador)
                .orElseThrow(() -> new EntityNotFoundException("Não foi possível excluir a consulta pois não foi encontrada nenhuma consulta com o id " + identificador + "."));

        repository.delete(consulta);
    }


}
