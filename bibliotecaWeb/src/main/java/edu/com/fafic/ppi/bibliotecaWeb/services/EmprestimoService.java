package edu.com.fafic.ppi.bibliotecaWeb.services;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Aluno;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Devolucao;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Emprestimo;
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


}
