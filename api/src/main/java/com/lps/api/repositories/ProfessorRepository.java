package com.lps.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lps.api.models.Professor;

//É uma boa prática manter o padrão para interfaces o caracter "I" em maiúsculo antes dos nomes das classes, por mais que se trate de uma classe vazia
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
