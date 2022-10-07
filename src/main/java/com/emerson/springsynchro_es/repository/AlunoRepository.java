package com.emerson.springsynchro_es.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emerson.springsynchro_es.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    
}
