package com.lps.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lps.api.models.Department;

//Foi esquecido a notação @Repository nessa classe
//É uma boa prática manter o padrão para interfaces o caracter "I" em maiúsculo antes dos nomes das classes, por mais que se trate de uma classe vazia
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
