package com.sistemadegerenciamento.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemadegerenciamento.demo.model.Teste;

@Repository
public interface TesteRepository extends JpaRepository<Teste, Long> {
}