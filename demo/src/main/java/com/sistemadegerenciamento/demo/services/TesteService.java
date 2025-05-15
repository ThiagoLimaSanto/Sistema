package com.sistemadegerenciamento.demo.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sistemadegerenciamento.demo.controller.dto.TesteDTO;
import com.sistemadegerenciamento.demo.model.Teste;
import com.sistemadegerenciamento.demo.repositories.TesteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TesteService {

    private final TesteRepository repository;
    private final UsuarioService usuarioService;

    public void insert(TesteDTO entity) {
        Teste teste = entity.toEntity(entity);
        teste.setUsuario(usuarioService.findById(entity.getUsuario()).get());
        repository.save(teste);
    }

    public Optional<Teste> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}