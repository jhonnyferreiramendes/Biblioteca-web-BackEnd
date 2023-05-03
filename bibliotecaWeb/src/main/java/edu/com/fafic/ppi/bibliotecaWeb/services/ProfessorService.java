package edu.com.fafic.ppi.bibliotecaWeb.services;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Aluno;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Livro;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Professor;
import edu.com.fafic.ppi.bibliotecaWeb.domain.exceptions.ObjetoNaoEncontradoException;
import edu.com.fafic.ppi.bibliotecaWeb.dto.ProfessorDTO;
import edu.com.fafic.ppi.bibliotecaWeb.repositories.BibliotecaRepository;
import edu.com.fafic.ppi.bibliotecaWeb.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    private final BibliotecaRepository bibliotecaRepository;


    public Professor save(ProfessorDTO professorDTO) {
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

    public Professor findByNome(String nome) {
        return professorRepository.findByNome(nome).orElseThrow(() -> new ObjetoNaoEncontradoException
                (" ' " + nome + " ' não existe na base de dados"));
    }

    public Professor findByMatricula(String matricula) {
        return professorRepository.findByMatricula(matricula).orElseThrow(() -> new ObjetoNaoEncontradoException
                (" ' " + matricula + " ' não existe na base de dados"));
    }

    public Professor update(Professor professor) {
        return professorRepository.save(professor);
    }


    public void remover(String matricula) {
        Professor professor = professorRepository.findByMatricula(matricula).orElseThrow(() -> new ObjetoNaoEncontradoException("Livro nao encontrado"));
        var biblioteca = bibliotecaRepository.findBy();
        biblioteca.getProfessor().remove(professor);
        professorRepository.delete(professor);
    }


}
