package com.jgdev.eccomerce.domain.repository;

import com.jgdev.eccomerce.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    // Definir un método para invocar el procedimiento almacenado
    @Procedure(name = "AutenticarUsuario")
    Optional<User> authenticateUser(@Param("Email") String email, @Param("Password") String password);
}
