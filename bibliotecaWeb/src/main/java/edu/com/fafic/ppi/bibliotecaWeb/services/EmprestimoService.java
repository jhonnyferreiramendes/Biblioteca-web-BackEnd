package edu.com.fafic.ppi.bibliotecaWeb.services;

import edu.com.fafic.ppi.bibliotecaWeb.domain.*;
import edu.com.fafic.ppi.bibliotecaWeb.domain.exceptions.ObjetoNaoEncontradoException;
import edu.com.fafic.ppi.bibliotecaWeb.dto.AlunoDTO;
import edu.com.fafic.ppi.bibliotecaWeb.dto.DevolucaoDTO;
import edu.com.fafic.ppi.bibliotecaWeb.dto.EmprestimoDTO;
import edu.com.fafic.ppi.bibliotecaWeb.repositories.EmprestimoRepository;
import edu.com.fafic.ppi.bibliotecaWeb.repositories.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;


    public Emprestimo saveEmprestimo(EmprestimoDTO emprestimoDTO) {
        //var listLivros = livroRepository.findAll();
       // emprestimoDTO.setLivrosLocados(listLivros);
        var emprestimo = new Emprestimo(
                emprestimoDTO.getAluno(),
                emprestimoDTO.getProfessor(),
                emprestimoDTO.getDataEmprestimo(),
                emprestimoDTO.getLivrosLocados());
        return emprestimoRepository.save(emprestimo);

    }

    public Emprestimo update (Emprestimo emprestimo){
        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo findById(Long id){
        return emprestimoRepository.findById(id).orElseThrow(
                () -> new ObjetoNaoEncontradoException
                        (" ' "+ id + " ' não existe na base de dados"));
    }

    public void remover(Long id){
        Emprestimo emprestimo = emprestimoRepository.findById(id).orElseThrow(()-> new ObjetoNaoEncontradoException("Livro nao encontrado"));
        emprestimoRepository.delete(emprestimo);
    }


}
