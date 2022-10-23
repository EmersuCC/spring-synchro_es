package com.emerson.springsynchro_es.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emerson.springsynchro_es.exception.UserNotFoundException;

import com.emerson.springsynchro_es.model.Aluno;
import com.emerson.springsynchro_es.repository.AlunoRepository;

import java.time.Instant;
import java.util.List;


@RestController
@RequestMapping("/alunos")
@CrossOrigin
public class AlunoController {
 
    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public List<Aluno> getInfo() {
        // Aluno aluno = new Aluno(1L, "Emerson Santos", "1234-5678",
        // "example@gmail.com", Instant.now());
        return alunoRepository.findAll();
    }

    @PostMapping
    public void incluir(@RequestBody Aluno aluno) {
        alunoRepository.save(aluno);
    }

    @PutMapping("/{matricula}")
    Aluno alterar(@RequestBody Aluno aluno, @PathVariable Long matricula) {
        
        return alunoRepository.findById(matricula)
        .map(user -> {
            user.setName(aluno.getName());
            user.setEmail(aluno.getEmail());
            user.setTelefone(aluno.getTelefone());
            user.setMatricula(matricula);
            user.setDataCadastro(Instant.now());

            return alunoRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(matricula));
    }

    @DeleteMapping("/{matricula}")
    public String deletar(@PathVariable Long matricula) {
        if(!alunoRepository.existsById(matricula))
            throw new UserNotFoundException(matricula);
        alunoRepository.deleteById(matricula);
        return("Aluno deletado com sucesso, matricula: " + matricula);
    }

    @GetMapping("/{matricula}")
    Aluno ler(@PathVariable Long matricula) {
        return alunoRepository.findById(matricula)
        .orElseThrow(()-> new UserNotFoundException(matricula));
    }
}
