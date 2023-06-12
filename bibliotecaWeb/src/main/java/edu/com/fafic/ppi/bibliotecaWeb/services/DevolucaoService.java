package edu.com.fafic.ppi.bibliotecaWeb.services;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Devolucao;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Emprestimo;
import edu.com.fafic.ppi.bibliotecaWeb.domain.exceptions.ObjetoNaoEncontradoException;
import edu.com.fafic.ppi.bibliotecaWeb.dto.DevolucaoDTO;
import edu.com.fafic.ppi.bibliotecaWeb.repositories.DevolucaoRepository;
import edu.com.fafic.ppi.bibliotecaWeb.repositories.EmprestimoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Period;


@Service
@RequiredArgsConstructor
public class DevolucaoService {

    private final DevolucaoRepository devolucaoRepository;
    private final EmprestimoRepository emprestimoRepository;

    public Devolucao saveDevolucao(DevolucaoDTO devolucaoDTO) {
        var devolucao = new Devolucao(
                devolucaoDTO.getEmprestimo(),
                devolucaoDTO.getDataDevolucao(),
                devolucaoDTO.getDevolvido(),
                devolucaoDTO.getDiasAtrasados(),
                devolucaoDTO.getValorDaMulta());
        Emprestimo emprestimo = emprestimoRepository.findById(devolucaoDTO.getEmprestimo().getId()).orElseThrow((() -> new ObjetoNaoEncontradoException("Emprestimo nao encontrado")));
        Period resultado = Period.between(emprestimo.getDataEmprestimo(), devolucaoDTO.getDataDevolucao());
        devolucao.setDiasAtrasados(resultado.getDays());
        if (devolucao.getDiasAtrasados() > 2) {
            double multa = 2.5 * devolucao.getDiasAtrasados();
            devolucao.setValorTotal(multa);
        }
        return devolucaoRepository.save(devolucao);

    }

    public Devolucao update(Devolucao devolucao) {
        return devolucaoRepository.save(devolucao);
    }

    public Devolucao findById(Long id) {
        return devolucaoRepository.findById(id).orElseThrow(
                () -> new ObjetoNaoEncontradoException
                        (" ' " + id + " ' não existe na base de dados"));
    }

    public void remover(Long id) {
        Devolucao devolucao = devolucaoRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException("Livro nao encontrado"));
        devolucaoRepository.delete(devolucao);
    }

}
