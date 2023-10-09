package com.salesianostriana.dam.EjemploDTOCasa.repositories;

import com.salesianostriana.dam.EjemploDTOCasa.entities.Categoria;
import com.salesianostriana.dam.EjemploDTOCasa.entities.Dificultad;
import com.salesianostriana.dam.EjemploDTOCasa.entities.Monumento;
import com.salesianostriana.dam.EjemploDTOCasa.entities.Ruta;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {

    private final MonumentoRepository monumentoRepository;
    private final RutaRepository rutaRepository;
    private final CategoriaRepository categoriaRepository;

    @PostConstruct
    public void init(){
        Categoria c1 = Categoria.builder()
                .nombre("Históricos")
                .build();
        Categoria c2 = Categoria.builder()
                .nombre("Estadios")
                .build();

        categoriaRepository.save(c1);
        categoriaRepository.save(c2);


        Monumento m1= Monumento.builder()
                .nombre("Giralda")
                .codigoPais("es")
                .direccion("Calle Triana, 2")
                .localizacion("123, 123")
                .build();

        Monumento m2= Monumento.builder()
                .nombre("Torre del oro")
                .codigoPais("es")
                .direccion("Calle Betis, 2")
                .localizacion("122, 124")
                .build();

        Monumento m3= Monumento.builder()
                .nombre("Mezquita de Córdoba")
                .codigoPais("es")
                .direccion("Calle Joaquín, 2")
                .localizacion("101, 123")
                .build();

        Monumento m4= Monumento.builder()
                .nombre("Los Cármenes")
                .codigoPais("es")
                .direccion("Avenida de la Constitución, 2")
                .localizacion("113, 123")
                .build();

        monumentoRepository.saveAll(List.of(m1, m2, m3, m4));

        Ruta r = Ruta.builder()
                .nombre("Iglesias wenas de verdá")
                .dificultad(Dificultad.BAJA)
                .minutos(20)
                .monumentos(List.of(m1, m2))
                .build();

        rutaRepository.save(r);
    }

}
