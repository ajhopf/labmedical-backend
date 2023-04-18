package br.com.labmedical.backend.services;

import br.com.labmedical.backend.dtos.medico.MedicoAtualizaSenhaDto;
import br.com.labmedical.backend.dtos.medico.MedicoPostRequestDto;
import br.com.labmedical.backend.dtos.medico.MedicoPutRequestDto;
import br.com.labmedical.backend.dtos.medico.MedicoResponseDto;
import br.com.labmedical.backend.exceptions.AlterouRgOuCpfException;
import br.com.labmedical.backend.exceptions.EntidadeExistenteException;
import br.com.labmedical.backend.mappers.MedicoMapper;
import br.com.labmedical.backend.models.Medico;
import br.com.labmedical.backend.repositories.MedicoRepository;
import br.com.labmedical.backend.services.helpers.CadastroHelper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MedicoService {
    @Autowired
    MedicoRepository repository;
    @Autowired
    MedicoMapper mapper;

    public MedicoResponseDto cadastrarMedico(MedicoPostRequestDto requestDto) {
        Medico medico = mapper.map(requestDto);

        if (repository.findByCpf(medico.getCpf()) != null){
             throw new EntidadeExistenteException("Usuário já cadastrado!");
        }

        medico = repository.save(medico);

        return mapper.map(medico);
    }

    public List<MedicoResponseDto> getMedicos() {
        return mapper.map(repository.findAll());
    }

    public MedicoResponseDto atualizarMedico(Long id, MedicoPutRequestDto requestDto) {
        Medico medico = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não foi possível encontra um usuário(médico) com o id " + id + "."));

        if (CadastroHelper.contemInformacao(requestDto.getCpf()) && !Objects.equals(medico.getCpf(), requestDto.getCpf())) {
            throw new AlterouRgOuCpfException("Não é possível alterar o CPF de um usuário.");
        }

        if (CadastroHelper.contemInformacao(requestDto.getRg()) && !Objects.equals(medico.getRg(), requestDto.getRg())) {
            throw new AlterouRgOuCpfException("Não é possível alterar o RG de um usuário.");
        }

        //Infos de pessoa

        if (CadastroHelper.contemInformacao(requestDto.getNomeCompleto())) {
            medico.setNomeCompleto(requestDto.getNomeCompleto());
        }
        if (CadastroHelper.contemInformacao(requestDto.getGenero())) {
            medico.setGenero(requestDto.getGenero());
        }
        if (CadastroHelper.contemInformacao(requestDto.getDob())) {
            medico.setDob(requestDto.getDob());
        }
        if (CadastroHelper.contemInformacao(requestDto.getEstadoCivil())) {
            medico.setEstadoCivil(requestDto.getEstadoCivil());
        }
        if (CadastroHelper.contemInformacao(requestDto.getTelefone())) {
            medico.setTelefone(requestDto.getTelefone());
        }
        if (CadastroHelper.contemInformacao(requestDto.getEmail())) {
            medico.setEmail(requestDto.getEmail());
        }
        if (CadastroHelper.contemInformacao(requestDto.getNaturalidade())) {
            medico.setNaturalidade(requestDto.getNaturalidade());
        }

        //Infos de médico

        if (CadastroHelper.contemInformacao(requestDto.getCrm())) {
            medico.setCrm(requestDto.getCrm());
        }
        if (requestDto.getEspecializacao() != null && requestDto.getEspecializacao().length() > 0) {
            medico.setEspecializacao(requestDto.getEspecializacao());
        }

        repository.save(medico);

        return mapper.map(medico);
    }

    public MedicoResponseDto atualizarSenha(Long id, MedicoAtualizaSenhaDto requestDto) {
        Medico medico = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        medico.setSenha(requestDto.getSenha());

        return mapper.map(medico);
    }
}
