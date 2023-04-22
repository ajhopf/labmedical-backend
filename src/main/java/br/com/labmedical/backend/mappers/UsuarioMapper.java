package br.com.labmedical.backend.mappers;

import br.com.labmedical.backend.dtos.medico.UsuarioPostRequestDto;
import br.com.labmedical.backend.dtos.medico.UsuarioResponseDto;
import br.com.labmedical.backend.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper {
    Usuario map(UsuarioPostRequestDto source);
    UsuarioResponseDto map(Usuario source);
    List<UsuarioResponseDto> map(List<Usuario> source);
}
