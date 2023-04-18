package br.com.labmedical.backend.services;

import br.com.labmedical.backend.dtos.paciente.PacientePostRequestDto;
import br.com.labmedical.backend.dtos.paciente.PacienteResponseDto;
import br.com.labmedical.backend.exceptions.EnderecoNaoCadastradoException;
import br.com.labmedical.backend.exceptions.EntidadeExistenteException;
import br.com.labmedical.backend.mappers.PacienteMapper;
import br.com.labmedical.backend.models.Endereco;
import br.com.labmedical.backend.models.Paciente;
import br.com.labmedical.backend.repositories.EnderecoRepository;
import br.com.labmedical.backend.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository repository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    PacienteMapper mapper;

    public PacienteResponseDto cadastrarPaciente(PacientePostRequestDto requestDto) {
       Endereco endereco = enderecoRepository.findById(requestDto.getEnderecoId())
                .orElseThrow(() -> new EnderecoNaoCadastradoException(requestDto.getEnderecoId()));

        if (repository.findByCpf(requestDto.getCpf()) != null){
            throw new EntidadeExistenteException("Paciente com cpf " + requestDto.getCpf() + " já cadastrado!");
        }

       Paciente paciente = mapper.map(requestDto);

       paciente.setExames(0);
       
       paciente = repository.save(paciente);

       paciente.setEndereco(endereco);


       return mapper.map(paciente);
    }

    public List<PacienteResponseDto> getPacientes() {
        List<Paciente> pacientes = repository.findAll();

        return mapper.map(pacientes);
    }
}
