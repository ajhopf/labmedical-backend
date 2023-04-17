package br.com.labmedical.backend.mappers;

import br.com.labmedical.backend.dtos.endereco.EnderecoPostRequestDto;
import br.com.labmedical.backend.dtos.endereco.EnderecoResponseDto;
import br.com.labmedical.backend.models.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EnderecoMapper {
    Endereco map(EnderecoPostRequestDto source);
    EnderecoResponseDto map(Endereco source);
    List<EnderecoResponseDto> map(List<Endereco> source);
}
