package com.sistemadegerenciamento.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemadegerenciamento.demo.model.Relatorios;

@Repository
public interface RelatoriosRepository extends JpaRepository<Relatorios, Long> {
}