package com.sistemadegerenciamento.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemadegerenciamento.demo.controller.dto.RefatoracaoDTO;
import com.sistemadegerenciamento.demo.model.Refatoracao;
import com.sistemadegerenciamento.demo.services.RefatoracaoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/refatoracoes")
public class RefatoracaoController implements GenericController {

    private final RefatoracaoService service;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody RefatoracaoDTO entity) {
        service.insert(entity);
        return ResponseEntity.created(gerarHeaderLocation(entity.getId())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Refatoracao> findById(@PathVariable Long id) {
        return service.findById(id).map(relatorios -> {
            return ResponseEntity.ok(relatorios);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}