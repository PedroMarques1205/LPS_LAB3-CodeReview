package com.lps.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lps.api.models.Student;

//É uma boa prática manter o padrão para interfaces o caracter "I" em maiúsculo antes dos nomes das classes, por mais que se trate de uma classe vazia
//Foi esquecido a notação @Repository nessa classe
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmail(String email);

    Student findByCpf(String cpf);

    List<Student> findByCourse_Name(String course);
}
