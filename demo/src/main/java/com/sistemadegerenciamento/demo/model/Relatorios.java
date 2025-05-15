package com.sistemadegerenciamento.demo.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_relatorios")
@EntityListeners(AuditingEntityListener.class)
public class Relatorios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @CreatedDate
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario responsavel;

    @ManyToOne
    @JoinColumn(name = "id_refatoracao")
    private Refatoracao refatoracao;

    @ManyToOne
    @JoinColumn(name = "id_teste")
    private Teste teste;

    @Column(name = "observacoes_gerais")
    private String observacoesGerais;

    private String conclusao;
}