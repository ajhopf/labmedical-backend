package br.com.labmedical.backend.services;

import br.com.labmedical.backend.dtos.medico.UsuarioAtualizaSenhaDto;
import br.com.labmedical.backend.dtos.medico.UsuarioPostRequestDto;
import br.com.labmedical.backend.dtos.medico.UsuarioPutRequestDto;
import br.com.labmedical.backend.dtos.medico.UsuarioResponseDto;
import br.com.labmedical.backend.exceptions.AlterouRgOuCpfException;
import br.com.labmedical.backend.exceptions.EntidadeExistenteException;
import br.com.labmedical.backend.mappers.UsuarioMapper;
import br.com.labmedical.backend.models.Usuario;
import br.com.labmedical.backend.repositories.UsuarioRepository;
import br.com.labmedical.backend.services.helpers.CadastroHelper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repository;
    @Autowired
    UsuarioMapper mapper;

    public UsuarioResponseDto cadastrarMedico(UsuarioPostRequestDto requestDto) {
        Usuario usuario = mapper.map(requestDto);

        if (repository.findByCpf(usuario.getCpf()) != null){
             throw new EntidadeExistenteException("Usuário com cpf " + usuario.getCpf() + " já cadastrado!");
        }

        usuario = repository.save(usuario);

        return mapper.map(usuario);
    }

    public List<UsuarioResponseDto> getMedicos() {
        return mapper.map(repository.findAll());
    }

    public UsuarioResponseDto atualizarMedico(Long id, UsuarioPutRequestDto requestDto) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não foi possível encontra um usuário(médico) com o id " + id + "."));

        if (CadastroHelper.contemInformacao(requestDto.getCpf()) && !Objects.equals(usuario.getCpf(), requestDto.getCpf())) {
            throw new AlterouRgOuCpfException("Não é possível alterar o CPF de um usuário.");
        }

        if (CadastroHelper.contemInformacao(requestDto.getRg()) && !Objects.equals(usuario.getRg(), requestDto.getRg())) {
            throw new AlterouRgOuCpfException("Não é possível alterar o RG de um usuário.");
        }

        //Infos de pessoa

        if (CadastroHelper.contemInformacao(requestDto.getNomeCompleto())) {
            usuario.setNomeCompleto(requestDto.getNomeCompleto());
        }
        if (CadastroHelper.contemInformacao(requestDto.getGenero())) {
            usuario.setGenero(requestDto.getGenero());
        }
        if (CadastroHelper.contemInformacao(requestDto.getDob())) {
            usuario.setDob(requestDto.getDob());
        }
        if (CadastroHelper.contemInformacao(requestDto.getEstadoCivil())) {
            usuario.setEstadoCivil(requestDto.getEstadoCivil());
        }
        if (CadastroHelper.contemInformacao(requestDto.getTelefone())) {
            usuario.setTelefone(requestDto.getTelefone());
        }
        if (CadastroHelper.contemInformacao(requestDto.getEmail())) {
            usuario.setEmail(requestDto.getEmail());
        }
        if (CadastroHelper.contemInformacao(requestDto.getNaturalidade())) {
            usuario.setNaturalidade(requestDto.getNaturalidade());
        }

        //Infos de médico

        if (CadastroHelper.contemInformacao(requestDto.getCrm())) {
            usuario.setCrm(requestDto.getCrm());
        }
        if (requestDto.getEspecializacao() != null && requestDto.getEspecializacao().length() > 0) {
            usuario.setEspecializacao(requestDto.getEspecializacao());
        }

        repository.save(usuario);

        return mapper.map(usuario);
    }

    public UsuarioResponseDto atualizarSenha(Long id, UsuarioAtualizaSenhaDto requestDto) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        usuario.setSenha(requestDto.getSenha());

        return mapper.map(usuario);
    }
}
