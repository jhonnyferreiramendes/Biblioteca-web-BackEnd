package edu.com.fafic.ppi.bibliotecaWeb.repositories;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor,Long> {

    Professor findByNome(String nome);
    Professor findByMatricula(String matricula);
}
