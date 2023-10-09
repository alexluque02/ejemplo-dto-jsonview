package com.salesianostriana.dam.EjemploDTOCasa.service;

import com.salesianostriana.dam.EjemploDTOCasa.dto.EditRutaDto;
import com.salesianostriana.dam.EjemploDTOCasa.entities.Dificultad;
import com.salesianostriana.dam.EjemploDTOCasa.entities.Monumento;
import com.salesianostriana.dam.EjemploDTOCasa.entities.Ruta;
import com.salesianostriana.dam.EjemploDTOCasa.repositories.MonumentoRepository;
import com.salesianostriana.dam.EjemploDTOCasa.repositories.RutaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RutaService {

    private final RutaRepository rutaRepository;
    private final MonumentoRepository monumentoRepository;

    public Ruta save(EditRutaDto nueva){
        Ruta r = new Ruta();
        r.setNombre(nueva.nombre());
        r.setMinutos(nueva.duracion());
        r.setDificultad(Dificultad.valueOf(nueva.dificultad()));
        List<Monumento> monumentos = nueva.monumentos()
                .stream()
                .map(monumentoRepository::getReferenceById)
                .toList();
        r.setMonumentos(monumentos);

        return rutaRepository.save(r);
    }

}
