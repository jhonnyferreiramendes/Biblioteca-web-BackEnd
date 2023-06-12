package edu.com.fafic.ppi.bibliotecaWeb.repositories;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Login;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {

    @Query("select u from Usuario u where u.login.email =:email and u.login.senha =:senha")
    Optional <Usuario> getByLogin(String email, String senha);


}
