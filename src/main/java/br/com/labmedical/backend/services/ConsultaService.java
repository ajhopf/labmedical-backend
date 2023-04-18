package br.com.labmedical.backend.services;

import br.com.labmedical.backend.dtos.consulta.ConsultaPostRequestDto;
import br.com.labmedical.backend.dtos.consulta.ConsultaResponseDto;
import br.com.labmedical.backend.mappers.ConsultaMapper;
import br.com.labmedical.backend.models.Consulta;
import br.com.labmedical.backend.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ConsultaService {
    @Autowired
    ConsultaRepository repository;
    @Autowired
    ConsultaMapper mapper;

    public ConsultaResponseDto cadastrarConsulta(ConsultaPostRequestDto requestDto) {
        Consulta consulta = mapper.map(requestDto);

        String dataEHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        consulta.setHoraEData(dataEHora);


        consulta = repository.save(consulta);

        return mapper.map(consulta);
    }
}
