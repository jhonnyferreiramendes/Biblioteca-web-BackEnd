package edu.com.fafic.ppi.bibliotecaWeb.repositories;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Livro;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Optional;


public interface LivroRepository extends JpaRepository<Livro,Long> {

    Optional <Livro> findByNome(String nome);
    Optional <Livro> findByIsbn(String isbn);
    Optional <Livro> findByArea(String area);


}
