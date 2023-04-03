package edu.com.fafic.ppi.bibliotecaWeb.services;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Aluno;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Emprestimo;
import edu.com.fafic.ppi.bibliotecaWeb.dto.AlunoDTO;
import edu.com.fafic.ppi.bibliotecaWeb.dto.EmprestimoDTO;
import edu.com.fafic.ppi.bibliotecaWeb.repositories.EmprestimoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmprestimoService {

    public final EmprestimoRepository emprestimoRepository;

    public Emprestimo saveEmprestimo(EmprestimoDTO emprestimoDTO) {
        var emprestimo = new Emprestimo(
                emprestimoDTO.getUsuario(),
                emprestimoDTO.getDataEmprestimo(),
                emprestimoDTO.getLivrosLocados(),
                emprestimoDTO.getDevolucao());
        return emprestimoRepository.save(emprestimo);
    }

}
