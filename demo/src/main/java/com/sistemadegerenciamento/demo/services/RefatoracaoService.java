package com.sistemadegerenciamento.demo.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sistemadegerenciamento.demo.controller.dto.RefatoracaoDTO;
import com.sistemadegerenciamento.demo.model.Refatoracao;
import com.sistemadegerenciamento.demo.repositories.RefatoracaoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RefatoracaoService {

    private final RefatoracaoRepository repository;
    private final UsuarioService usuarioService;

    public void insert(RefatoracaoDTO entity) {
        Refatoracao refatoracao = entity.toEntity(entity);
        refatoracao.setUsuario(usuarioService.findById(entity.getUsuario()).get());
        repository.save(refatoracao);
    }

    public Optional<Refatoracao> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}