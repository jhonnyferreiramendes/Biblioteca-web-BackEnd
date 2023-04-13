package edu.com.fafic.ppi.bibliotecaWeb.services;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Aluno;
import edu.com.fafic.ppi.bibliotecaWeb.domain.exceptions.ObjetoNaoEncontradoException;
import edu.com.fafic.ppi.bibliotecaWeb.dto.AlunoDTO;
import edu.com.fafic.ppi.bibliotecaWeb.repositories.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AlunoService {

    private final AlunoRepository alunoRepository;

    public Aluno save(AlunoDTO alunoDTO){
        var aluno = new Aluno(
                alunoDTO.getNome(),
                alunoDTO.getCpf(),
                alunoDTO.getGenero(),
                alunoDTO.getMatricula(),
                alunoDTO.getEndereco(),
                alunoDTO.getContato(),
                alunoDTO.getLogin(),
                alunoDTO.getCurso(),
                alunoDTO.getPeriodo());
                return alunoRepository.save(aluno);
    }

    public Aluno findByNome(String nome){
        return alunoRepository.findByNome(nome).orElseThrow(() -> new ObjetoNaoEncontradoException
                (" ' "+ nome + " ' não existe na base de dados"));
    }

    public Aluno findByMatricula(String matricula){
        return alunoRepository.findByMatricula(matricula).orElseThrow(() -> new ObjetoNaoEncontradoException
                (" ' "+ matricula + " ' não existe na base de dados"));
    }


}
