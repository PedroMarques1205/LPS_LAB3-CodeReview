package com.lps.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lps.api.models.Company;
import com.lps.api.repositories.CompanyRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    // É preferível injetar o PasswordEncoder através do construtor para facilitar a testabilidade da classe e evitar dependências fortes.
    // Outra opção é usar PasswordEncoder como um bean configurado na aplicação para maior flexibilidade.
    @Autowired
    private final PasswordEncoder encoder = new BCryptPasswordEncoder();

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company findById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    public Company save(Company company) {
        var newPassword = encoder.encode(company.getPassword());
        company.setPassword(newPassword);
        
        return companyRepository.save(company);
    }

    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }

    // Use Optional.orElseThrow() para evitar um bloco condicional if/else e tornar o código mais direto.
    public Company updateCompany(Long id, Company company) {
        Optional<Company> existingCompany = companyRepository.findById(id);
        if (existingCompany.isPresent()) {
            Company updatedCompany = existingCompany.get();
            updatedCompany.setName(company.getName());

            return companyRepository.save(updatedCompany);
        } else {
            throw new RuntimeException("Professor not found with id " + id);
        }
    }

}
