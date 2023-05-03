package edu.com.fafic.ppi.bibliotecaWeb.services;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Aluno;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Biblioteca;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Bibliotecario;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Livro;
import edu.com.fafic.ppi.bibliotecaWeb.domain.exceptions.ObjetoNaoEncontradoException;
import edu.com.fafic.ppi.bibliotecaWeb.dto.BibliotecaDTO;
import edu.com.fafic.ppi.bibliotecaWeb.repositories.BibliotecaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BibliotecaService {

    private final BibliotecaRepository bibliotecaRepository;

    public Biblioteca save(BibliotecaDTO bibliotecaDTO){
        var biblioteca = new Biblioteca(
               bibliotecaDTO.getNome(),
               bibliotecaDTO.getNomeInstituicao(),
               bibliotecaDTO.getBibliotecario(),
               bibliotecaDTO.getLivros(),
               bibliotecaDTO.getProfessor(),
               bibliotecaDTO.getAluno());
        return bibliotecaRepository.save(biblioteca);

    }

    public Biblioteca update (Biblioteca biblioteca){
        return bibliotecaRepository.save(biblioteca);
    }

    public Biblioteca findByNome(String nome){
        return bibliotecaRepository.findByNome(nome).orElseThrow(
            () -> new ObjetoNaoEncontradoException
                    (" ' "+ nome + " ' não existe na base de dados"));
    }

    public void remover(Long id){
        Biblioteca biblioteca = bibliotecaRepository.findById(id).orElseThrow(()-> new ObjetoNaoEncontradoException("Livro nao encontrado"));
        bibliotecaRepository.delete(biblioteca);
    }


}
