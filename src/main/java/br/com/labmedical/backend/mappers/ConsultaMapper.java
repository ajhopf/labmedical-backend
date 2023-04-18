package br.com.labmedical.backend.mappers;

import br.com.labmedical.backend.dtos.consulta.ConsultaPostRequestDto;
import br.com.labmedical.backend.dtos.consulta.ConsultaResponseDto;
import br.com.labmedical.backend.models.Consulta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ConsultaMapper {
    @Mapping(target = "paciente.id", source = "pacienteId")
    Consulta map(ConsultaPostRequestDto source);

    @Mappings({
            @Mapping(target = "indicador_paciente", source = "paciente.id"),
            @Mapping(target = "identificador", source = "id")
    })
    ConsultaResponseDto map(Consulta source);
}
