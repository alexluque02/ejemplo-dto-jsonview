package com.salesianostriana.dam.EjemploDTOCasa.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.salesianostriana.dam.EjemploDTOCasa.dto.GetMonumentoDto;
import com.salesianostriana.dam.EjemploDTOCasa.entities.Monumento;
import com.salesianostriana.dam.EjemploDTOCasa.entities.MonumentoView;
import com.salesianostriana.dam.EjemploDTOCasa.repositories.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/monumento")
public class MonumentoController {

    private final MonumentoRepository monumentoRepository;

    @GetMapping("/")
    @JsonView({MonumentoView.MonumentoList.class})
    public ResponseEntity<List<Monumento>> findAll(){
        List<Monumento> data = monumentoRepository.findAll();

        if(data.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        /*
        List<GetMonumentoDto> result = data.stream()
                .map(GetMonumentoDto::of)
                .toList();
    */
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    @JsonView({MonumentoView.MonumentoDetails.class})
    public ResponseEntity<Monumento> findById(@PathVariable Long id){
        return ResponseEntity.of(
                monumentoRepository.findById(id)
        );
    }

}
