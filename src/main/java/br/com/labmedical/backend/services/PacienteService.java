package br.com.labmedical.backend.services;

import br.com.labmedical.backend.dtos.paciente.PacientePostRequestDto;
import br.com.labmedical.backend.dtos.paciente.PacientePutRequestDto;
import br.com.labmedical.backend.dtos.paciente.PacienteResponseDto;
import br.com.labmedical.backend.exceptions.AlterouRgOuCpfException;
import br.com.labmedical.backend.exceptions.EnderecoNaoCadastradoException;
import br.com.labmedical.backend.exceptions.EntidadeExistenteException;
import br.com.labmedical.backend.exceptions.PacientePossuiExameOuConsultaException;
import br.com.labmedical.backend.mappers.PacienteMapper;
import br.com.labmedical.backend.models.Endereco;
import br.com.labmedical.backend.models.Paciente;
import br.com.labmedical.backend.repositories.ConsultaRepository;
import br.com.labmedical.backend.repositories.EnderecoRepository;
import br.com.labmedical.backend.repositories.ExameRepository;
import br.com.labmedical.backend.repositories.PacienteRepository;
import br.com.labmedical.backend.services.helpers.CadastroHelper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository repository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ConsultaRepository consultaRepository;

    @Autowired
    ExameRepository exameRepository;

    @Autowired
    PacienteMapper mapper;

    public PacienteResponseDto cadastrarPaciente(PacientePostRequestDto requestDto) {
       Endereco endereco = enderecoRepository.findById(requestDto.getEnderecoId())
                .orElseThrow(() -> new EnderecoNaoCadastradoException(requestDto.getEnderecoId()));

        if (repository.findByCpf(requestDto.getCpf()) != null){
            throw new EntidadeExistenteException("Paciente com cpf " + requestDto.getCpf() + " já cadastrado!");
        }

       Paciente paciente = mapper.map(requestDto);
       paciente = repository.save(paciente);

       PacienteResponseDto pacienteResponseDto = mapper.map(paciente);
       pacienteResponseDto.setEndereco(endereco);
       pacienteResponseDto = setNumeroConsultaExame(pacienteResponseDto);

       return pacienteResponseDto;
    }

    public List<PacienteResponseDto> getPacientes(String nome) {
        List<PacienteResponseDto> pacientes;

        if (nome != null) {
            pacientes = mapper.map(repository.findByNome(nome.toUpperCase()));
        } else {
            pacientes = mapper.map(repository.findAll());
        }

        pacientes.forEach(paciente -> {
            paciente = setNumeroConsultaExame(paciente);
        });

        return pacientes;
    }

    public PacienteResponseDto getPacienteById(Long id) {
        Paciente paciente = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        PacienteResponseDto pacienteResponseDto = mapper.map(paciente);
        pacienteResponseDto = setNumeroConsultaExame(pacienteResponseDto);

        return pacienteResponseDto;
    }

    public PacienteResponseDto atualizarPaciente(Long id, PacientePutRequestDto requestDto) {
        Paciente paciente = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        if (CadastroHelper.contemInformacao(requestDto.getCpf()) && !Objects.equals(paciente.getCpf(), requestDto.getCpf())) {
            throw new AlterouRgOuCpfException("Não é possível alterar o CPF de um usuário.");
        }

        if (CadastroHelper.contemInformacao(requestDto.getRg()) && !Objects.equals(paciente.getRg(), requestDto.getRg())) {
            throw new AlterouRgOuCpfException("Não é possível alterar o RG de um usuário.");
        }

        //Infos de pessoa

        if (CadastroHelper.contemInformacao(requestDto.getNomeCompleto())) {
            paciente.setNomeCompleto(requestDto.getNomeCompleto());
        }
        if (CadastroHelper.contemInformacao(requestDto.getGenero())) {
            paciente.setGenero(requestDto.getGenero());
        }
        if (CadastroHelper.contemInformacao(requestDto.getDob())) {
            paciente.setDob(requestDto.getDob());
        }
        if (CadastroHelper.contemInformacao(requestDto.getEstadoCivil())) {
            paciente.setEstadoCivil(requestDto.getEstadoCivil());
        }
        if (CadastroHelper.contemInformacao(requestDto.getTelefone())) {
            paciente.setTelefone(requestDto.getTelefone());
        }
        if (CadastroHelper.contemInformacao(requestDto.getEmail())) {
            paciente.setEmail(requestDto.getEmail());
        }
        if (CadastroHelper.contemInformacao(requestDto.getNaturalidade())) {
            paciente.setNaturalidade(requestDto.getNaturalidade());
        }

        //Infos de Paciente


        if (CadastroHelper.contemInformacao(requestDto.getAlergias())) {
            paciente.setAlergias(requestDto.getAlergias());
        }
        if (CadastroHelper.contemInformacao(requestDto.getCuidadosEspecificos())) {
            paciente.setCuidadosEspecificos(requestDto.getCuidadosEspecificos());
        }
        if (CadastroHelper.contemInformacao(requestDto.getContatoDeEmergencia())) {
            paciente.setContatoDeEmergencia(requestDto.getContatoDeEmergencia());
        }
        if (CadastroHelper.contemInformacao(requestDto.getConvenio())) {
            paciente.setConvenio(requestDto.getConvenio());
        }
        if (CadastroHelper.contemInformacao(requestDto.getNumeroConvenio())) {
            paciente.setNumeroConvenio(requestDto.getNumeroConvenio());
        }
        if (CadastroHelper.contemInformacao(requestDto.getValidadeConvenio())) {
            paciente.setValidadeConvenio(requestDto.getValidadeConvenio());
        }
        if (requestDto.getEnderecoId() != null) {
            Endereco endereco = enderecoRepository.findById(requestDto.getEnderecoId())
                    .orElseThrow(() -> new EnderecoNaoCadastradoException(requestDto.getEnderecoId()));

            paciente.setEndereco(endereco);
        }

        repository.save(paciente);

        PacienteResponseDto pacienteResponseDto = mapper.map(paciente);
        pacienteResponseDto = setNumeroConsultaExame(pacienteResponseDto);

        return pacienteResponseDto;
    }


    public void deletarPaciente(Long identificador) {
        Paciente paciente = repository.findById(identificador)
                .orElseThrow(EntityNotFoundException::new);

        if (exameRepository.findByPacienteId(identificador).size() > 0) {
            throw new PacientePossuiExameOuConsultaException("Não é possível deletar o paciente pois ele possui exames vinculados.");
        };

        if (consultaRepository.findByPacienteId(identificador).size() > 0) {
            throw new PacientePossuiExameOuConsultaException("Não é possível deletar o paciente pois ele possui consultas vinculadas.");
        }

        repository.delete(paciente);
    }

    public PacienteResponseDto setNumeroConsultaExame(PacienteResponseDto pacienteResponseDto) {
        Integer exames = exameRepository.findByPacienteId(pacienteResponseDto.getIdentificador()).size();
        Integer consultas = consultaRepository.findByPacienteId(pacienteResponseDto.getIdentificador()).size();

        pacienteResponseDto.setExames(exames);
        pacienteResponseDto.setConsultas(consultas);

        return pacienteResponseDto;
    }
}
