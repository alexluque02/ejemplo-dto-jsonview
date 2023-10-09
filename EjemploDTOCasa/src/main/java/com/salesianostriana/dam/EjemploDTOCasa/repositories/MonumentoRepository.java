package com.salesianostriana.dam.EjemploDTOCasa.repositories;

import com.salesianostriana.dam.EjemploDTOCasa.entities.Monumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonumentoRepository extends JpaRepository<Monumento, Long> {
}
