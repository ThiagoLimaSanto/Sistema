package com.sistemadegerenciamento.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemadegerenciamento.demo.controller.dto.RelatorioDTO;
import com.sistemadegerenciamento.demo.model.Relatorios;
import com.sistemadegerenciamento.demo.services.RelatoriosService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/relatorios")
public class RelatoriosController implements GenericController {

    private final RelatoriosService service;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody RelatorioDTO entity) {
        service.insert(entity);
        return ResponseEntity.created(gerarHeaderLocation(entity.getId())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Relatorios> findById(@PathVariable Long id) {
        return service.findById(id).map(relatorios -> {
            return ResponseEntity.ok(relatorios);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}