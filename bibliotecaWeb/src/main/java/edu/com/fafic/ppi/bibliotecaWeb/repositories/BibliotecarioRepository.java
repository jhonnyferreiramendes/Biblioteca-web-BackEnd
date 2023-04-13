package edu.com.fafic.ppi.bibliotecaWeb.repositories;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Biblioteca;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Bibliotecario;
import edu.com.fafic.ppi.bibliotecaWeb.dto.BibliotecarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {

    Bibliotecario findByNome(String nome);






}
