
package com.lps.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lps.api.models.PasswordResetToken;
import com.lps.api.models.User;

//É uma boa prática manter o padrão para interfaces o caracter "I" em maiúsculo antes dos nomes das classes, por mais que se trate de uma classe vazia
@Repository
public interface PasswordTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
    PasswordResetToken findByUserAndToken(User User, String token);

    PasswordResetToken findByUser(User User);
}