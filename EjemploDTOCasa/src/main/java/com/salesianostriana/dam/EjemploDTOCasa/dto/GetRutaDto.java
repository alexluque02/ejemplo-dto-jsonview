package com.salesianostriana.dam.EjemploDTOCasa.dto;

import com.salesianostriana.dam.EjemploDTOCasa.entities.Monumento;
import com.salesianostriana.dam.EjemploDTOCasa.entities.Ruta;

import java.util.List;

public record GetRutaDto(
        String nombre,
        String tiempo,
        String dificultad,
        List<GetMonumentoDto> monumentos
) {

    public static GetRutaDto of(Ruta r){
        return new GetRutaDto(
                r.getNombre(),
                Integer.toString(r.getMinutos()),
                r.getDificultad().name(),
                r.getMonumentos().stream()
                        .map(GetMonumentoDto::of)
                        .toList()
        );
    }

}
