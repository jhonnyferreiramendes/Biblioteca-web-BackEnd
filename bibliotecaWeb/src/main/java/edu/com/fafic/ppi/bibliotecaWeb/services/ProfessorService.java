package edu.com.fafic.ppi.bibliotecaWeb.services;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Professor;
import edu.com.fafic.ppi.bibliotecaWeb.dto.ProfessorDTO;
import edu.com.fafic.ppi.bibliotecaWeb.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;


    public Professor save(ProfessorDTO professorDTO){
        var professor = new Professor(
                professorDTO.getNome(),
                professorDTO.getCpf(),
                professorDTO.getGenero(),
                professorDTO.getMatricula(),
                professorDTO.getEndereco(),
                professorDTO.getContato(),
                professorDTO.getLogin(),
                professorDTO.getCurso(),
                professorDTO.getArea());
        return professorRepository.save(professor);
    }

    public Professor findByNome(String nome){
        return professorRepository.findByNome(nome);
    }

    public Professor findByMatricula(String matricula){
        return professorRepository.findByNome(matricula);
    }

}
