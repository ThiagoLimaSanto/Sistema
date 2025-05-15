package com.sistemadegerenciamento.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistemadegerenciamento.demo.model.enuns.ResultadoRefatoracao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_refatoracao")
@EntityListeners(AuditingEntityListener.class)
public class Refatoracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @JsonIgnore
    @OneToMany(mappedBy = "refatoracao")
    private List<Relatorios> relatorio = new ArrayList<>();

    @CreatedDate
    @Column(name = "data_aplicacao")
    private LocalDate dataAplicacao;

    @Enumerated(EnumType.STRING)
    private ResultadoRefatoracao status;
}