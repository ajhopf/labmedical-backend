package br.com.labmedical.backend.mappers;

import br.com.labmedical.backend.dtos.exame.ExamePostRequestDto;
import br.com.labmedical.backend.dtos.exame.ExameResponseDto;
import br.com.labmedical.backend.models.Exame;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExameMapper {
    @Mappings ({
            @Mapping(target = "paciente.id", source = "pacienteId"),
            @Mapping(target = "medico.id", source = "medicoId")
    })
    Exame map(ExamePostRequestDto source);

    @Mappings({
            @Mapping(target = "indicador_paciente", source = "paciente.id"),
            @Mapping(target = "indicador_medico", source = "medico.id"),
            @Mapping(target = "identificador", source = "id")
    })
    ExameResponseDto map(Exame source);
}
