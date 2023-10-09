package com.salesianostriana.dam.EjemploDTOCasa.repositories;

import com.salesianostriana.dam.EjemploDTOCasa.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
