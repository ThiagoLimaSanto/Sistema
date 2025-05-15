package com.sistemadegerenciamento.demo.controller.dto;

import com.sistemadegerenciamento.demo.model.Relatorios;

import lombok.Data;

@Data
public class RelatorioDTO {
    private Long id;
    private String titulo;
    private Long responsavel;
    private Long fatoracao;
    private Long teste;
    private String observacoesGerais;
    private String conclusao;

    public Relatorios toEntity(RelatorioDTO dto) {
        Relatorios relatorios = new Relatorios();
        relatorios.setId(dto.id);
        relatorios.setTitulo(dto.titulo);
        relatorios.setObservacoesGerais(dto.getObservacoesGerais());
        relatorios.setConclusao(dto.conclusao);
        return relatorios;
    }
}