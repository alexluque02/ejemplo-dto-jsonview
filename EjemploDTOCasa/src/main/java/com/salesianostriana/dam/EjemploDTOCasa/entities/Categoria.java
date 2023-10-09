package com.salesianostriana.dam.EjemploDTOCasa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue
    private int id;

    private String nombre;

}
