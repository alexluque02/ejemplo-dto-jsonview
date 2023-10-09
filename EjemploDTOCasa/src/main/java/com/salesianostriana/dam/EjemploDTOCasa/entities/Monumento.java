package com.salesianostriana.dam.EjemploDTOCasa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Monumento {

    @Id
    @GeneratedValue
    @JsonView({MonumentoView.MonumentoDetails.class})
    private Long id;

    @JsonView({MonumentoView.MonumentoList.class})
    private String nombre, codigoPais, direccion, localidad, localizacion;

    @ElementCollection
    @JsonIgnore
    private List<String> imagenes;

    @ManyToOne
    @JsonView({MonumentoView.MonumentoList.class})
    private Categoria categoria;

    @ManyToMany
    @JsonIgnore
    List<Ruta> rutas;

}
