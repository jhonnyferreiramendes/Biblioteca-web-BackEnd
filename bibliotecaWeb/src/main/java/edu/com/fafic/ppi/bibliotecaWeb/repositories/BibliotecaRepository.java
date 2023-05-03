package edu.com.fafic.ppi.bibliotecaWeb.repositories;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BibliotecaRepository extends JpaRepository<Biblioteca,Long> {

   Optional<Biblioteca> findByNome(String nome);
   Biblioteca findBy();


}
