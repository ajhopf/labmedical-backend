package br.com.labmedical.backend.services;

import br.com.labmedical.backend.dtos.paciente.PacientePostRequestDto;
import br.com.labmedical.backend.dtos.paciente.PacientePutRequestDto;
import br.com.labmedical.backend.dtos.paciente.PacienteResponseDto;
import br.com.labmedical.backend.exceptions.AlterouRgOuCpfException;
import br.com.labmedical.backend.exceptions.EnderecoNaoCadastradoException;
import br.com.labmedical.backend.exceptions.EntidadeExistenteException;
import br.com.labmedical.backend.mappers.PacienteMapper;
import br.com.labmedical.backend.models.Endereco;
import br.com.labmedical.backend.models.Paciente;
import br.com.labmedical.backend.repositories.EnderecoRepository;
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

    public List<PacienteResponseDto> getPacientes(String nome) {
        if (nome != null) {
            List<Paciente> pacientes = repository.findByNome(nome.toUpperCase());
            return mapper.map(pacientes);
        }

        List<Paciente> pacientes = repository.findAll();

        return mapper.map(pacientes);
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

        //private String alergias;
        //    private String cuidadosEspecificos;
        //    private String contatoDeEmergencia;
        //    private String convenio;
        //    private String numeroConvenio;
        //    @DataValida
        //    private String validadeConvenio;
        //    private Long enderecoId;

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

        return mapper.map(paciente);
    }
}
