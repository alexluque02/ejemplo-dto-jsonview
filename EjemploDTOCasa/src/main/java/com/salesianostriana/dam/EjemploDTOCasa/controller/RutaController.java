package com.salesianostriana.dam.EjemploDTOCasa.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.salesianostriana.dam.EjemploDTOCasa.dto.EditRutaDto;
import com.salesianostriana.dam.EjemploDTOCasa.dto.GetRutaDto;
import com.salesianostriana.dam.EjemploDTOCasa.entities.Ruta;
import com.salesianostriana.dam.EjemploDTOCasa.entities.RutaView;
import com.salesianostriana.dam.EjemploDTOCasa.repositories.RutaRepository;
import com.salesianostriana.dam.EjemploDTOCasa.service.RutaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ruta")
public class RutaController {

    private final RutaRepository rutaRepository;
    private final RutaService rutaService;

    @GetMapping("/")
    @JsonView({RutaView.RutaList.class})
    public ResponseEntity<List<Ruta>> findAll(){

        List<Ruta> result = rutaRepository.findAll();

        if (result.isEmpty())
            return ResponseEntity.notFound().build();

        /*List<GetRutaDto> result = data.stream()
                .map(GetRutaDto::of)
                .toList();*/

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    @JsonView({RutaView.RutaDetails.class})
    public ResponseEntity<Ruta> findById (@PathVariable Long id){
        return ResponseEntity.of(
                rutaRepository.findById(id)
        );
    }

    @PostMapping("/")
    @JsonView({RutaView.RutaEdit.class})
    public ResponseEntity<Ruta> save(@RequestBody Ruta nueva){

        return ResponseEntity.status(HttpStatus.CREATED).body(rutaRepository.save(nueva));
    }

}
