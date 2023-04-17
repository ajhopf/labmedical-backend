package br.com.labmedical.backend.services;

import br.com.labmedical.backend.dtos.medico.MedicoPostRequestDto;
import br.com.labmedical.backend.dtos.medico.MedicoResponseDto;
import br.com.labmedical.backend.exceptions.UsuarioExistenteException;
import br.com.labmedical.backend.mappers.MedicoMapper;
import br.com.labmedical.backend.models.Medico;
import br.com.labmedical.backend.repositories.MedicoRepository;
import br.com.labmedical.backend.services.helpers.CadastroHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
    @Autowired
    MedicoRepository repository;
    @Autowired
    MedicoMapper mapper;

    public MedicoResponseDto cadastrarMedico(MedicoPostRequestDto requestDto) {
        Medico medico = mapper.map(requestDto);

        if (repository.findByCpf(medico.getCpf()) != null){
             throw new UsuarioExistenteException("Usuário já cadastrado!");
        }

        CadastroHelper.validarEstadoCivil(medico.getEstadoCivil());
        CadastroHelper.validarEspecializacao(medico.getEspecializacao());
        CadastroHelper.validarDataDeNascimento(medico.getDob());

        medico = repository.save(medico);

        return mapper.map(medico);
    }

}
