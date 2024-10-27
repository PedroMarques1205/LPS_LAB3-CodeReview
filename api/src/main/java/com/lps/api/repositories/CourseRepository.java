package com.lps.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lps.api.models.Course;

//É uma boa prática manter o padrão para interfaces o caracter "I" em maiúsculo antes dos nomes das classes, por mais que se trate de uma classe vazia
//Foi esquecido a notação @Repository nessa classe
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByName(String name);

}
