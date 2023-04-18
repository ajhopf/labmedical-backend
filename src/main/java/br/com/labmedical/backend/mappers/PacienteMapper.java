package br.com.labmedical.backend.mappers;

import br.com.labmedical.backend.dtos.paciente.PacientePostRequestDto;
import br.com.labmedical.backend.dtos.paciente.PacienteResponseDto;
import br.com.labmedical.backend.models.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface PacienteMapper {
    @Mapping(target = "endereco.id", source = "enderecoId")
    Paciente map(PacientePostRequestDto source);

    @Mapping(target = "identificador", source = "id")
    PacienteResponseDto map(Paciente source);

    @Mapping(target = "identificador", source = "id")
    List<PacienteResponseDto> map(List<Paciente> source);
}
