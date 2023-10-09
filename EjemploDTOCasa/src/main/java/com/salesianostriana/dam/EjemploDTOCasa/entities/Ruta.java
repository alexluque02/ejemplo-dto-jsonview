package com.salesianostriana.dam.EjemploDTOCasa.entities;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ruta {

    @Id
    @GeneratedValue
    @JsonView({RutaView.RutaDetails.class})
    private Long id;

    @JsonView({RutaView.RutaList.class, RutaView.RutaEdit.class})
    private String nombre;

    @JsonView({RutaView.RutaList.class, RutaView.RutaEdit.class})
    private int minutos;

    @JsonView({RutaView.RutaList.class, RutaView.RutaEdit.class})
    private Dificultad dificultad;

    @ManyToMany
    @JsonView({RutaView.RutaList.class, RutaView.RutaEdit.class})
    private List<Monumento> monumentos;

}
