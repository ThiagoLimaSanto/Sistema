package com.sistemadegerenciamento.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemadegerenciamento.demo.controller.dto.TesteDTO;
import com.sistemadegerenciamento.demo.model.Teste;
import com.sistemadegerenciamento.demo.services.TesteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/testes")
public class TesteController implements GenericController {

    private final TesteService service;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody TesteDTO entity) {
        service.insert(entity);
        return ResponseEntity.created(gerarHeaderLocation(entity.getId())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teste> findById(@PathVariable Long id) {
        return service.findById(id).map(teste -> {
            return ResponseEntity.ok(teste);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}