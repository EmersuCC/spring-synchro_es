package com.emerson.springsynchro_es.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("Aluno com matricula " + id + " não foi encontrado");

    }
}
