package com.emerson.springsynchro_es.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Aluno {
    @Id
    private Long matricula;
    private String name;
    private String telefone;
    private String email;
    private Instant dataCadastro;

}
