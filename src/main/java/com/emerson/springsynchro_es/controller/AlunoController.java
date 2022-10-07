package com.emerson.springsynchro_es.controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emerson.springsynchro_es.model.Aluno;
import com.emerson.springsynchro_es.repository.AlunoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    
    @Autowired
    private AlunoRepository alunoRepository;


    @GetMapping
    public List<Aluno> getInfo(){
        //Aluno aluno = new Aluno(1L, "Emerson Santos", "1234-5678", "example@gmail.com", Instant.now());
        return alunoRepository.findAll();
    }

    @PostMapping
    public void incluir(@RequestBody Aluno aluno){
        alunoRepository.save(aluno);
    }

    @PutMapping
    public void alterar(@RequestBody Aluno aluno){
        alunoRepository.save(aluno);
    }

    @DeleteMapping("/{matricula}")
    public void deletar(@PathVariable Long matricula){
        alunoRepository.deleteById(matricula);
    }

    @GetMapping("/{matricula}")
    public Optional<Aluno> ler(@PathVariable Long matricula){
        return alunoRepository.findById(matricula);
    }
}
