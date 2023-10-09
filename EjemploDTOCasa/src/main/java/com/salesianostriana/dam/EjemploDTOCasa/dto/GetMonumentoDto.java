package com.salesianostriana.dam.EjemploDTOCasa.dto;

import com.salesianostriana.dam.EjemploDTOCasa.entities.Monumento;

import java.util.List;

public record GetMonumentoDto(

        String nombre,
        String codigoPais,
        String direccion,
        String localidad,
        String localizacion,
        String imagen1,
        String imagen2,
        String imagen3,

        String categoria
) {

    public static GetMonumentoDto of(Monumento m){
        return new GetMonumentoDto(
                m.getNombre(),
                m.getCodigoPais(),
                m.getDireccion(),
                m.getLocalidad(),
                m.getLocalizacion(),
                m.getImagenes().isEmpty() ?
                        "https://youtube.com" : m.getImagenes().get(0),
                !m.getImagenes().isEmpty() && m.getImagenes().size()>1 ?
                        m.getImagenes().get(1) : null,
                !m.getImagenes().isEmpty() && m.getImagenes().size()>2 ?
                        m.getImagenes().get(2) : null,
                m.getCategoria()!=null ?
                        m.getCategoria().getNombre():
                        "Sin categoría"

        );
    }

}
