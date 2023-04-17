package br.com.labmedical.backend.services;

import br.com.labmedical.backend.dtos.endereco.EnderecoPostRequestDto;
import br.com.labmedical.backend.dtos.endereco.EnderecoResponseDto;
import br.com.labmedical.backend.exceptions.EntidadeExistenteException;
import br.com.labmedical.backend.mappers.EnderecoMapper;
import br.com.labmedical.backend.models.Endereco;
import br.com.labmedical.backend.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository repository;

    @Autowired
    EnderecoMapper mapper;

    public EnderecoResponseDto cadastrarEndereco(EnderecoPostRequestDto requestDto) {
        Endereco endereco = mapper.map(requestDto);

        if (repository.findByCep(endereco.getCep()) != null) {
            throw new EntidadeExistenteException("Cep já cadastrado!");
        }

        endereco = repository.save(endereco);

        return mapper.map(endereco);
    }

    public List<EnderecoResponseDto> getEnderecos() {
        List<Endereco> enderecos = repository.findAll();

        return mapper.map(enderecos);
    }
}
