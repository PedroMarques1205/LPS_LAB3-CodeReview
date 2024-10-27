package com.lps.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lps.api.models.Course;
import com.lps.api.repositories.CourseRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    //Adicionar verificação de existência do curso retornado, sugestão: .orElse()
    public Course findById(Long id) {
        return courseRepository.findById(id).get();
    }

    public Course findByName(String name) {
        return courseRepository.findByName(name);
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

}
