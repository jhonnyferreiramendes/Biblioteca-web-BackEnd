package edu.com.fafic.ppi.bibliotecaWeb.services;

import edu.com.fafic.ppi.bibliotecaWeb.domain.*;
import edu.com.fafic.ppi.bibliotecaWeb.domain.exceptions.ObjetoNaoEncontradoException;
import edu.com.fafic.ppi.bibliotecaWeb.dto.BibliotecaDTO;
import edu.com.fafic.ppi.bibliotecaWeb.dto.LivroDTO;
import edu.com.fafic.ppi.bibliotecaWeb.repositories.BibliotecaRepository;
import edu.com.fafic.ppi.bibliotecaWeb.repositories.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;
    private final BibliotecaRepository bibliotecaRepository;


    public Livro saveLivro(LivroDTO livroDTO) {
        var livro = new Livro(
                livroDTO.getNome(),
                livroDTO.getIsbn(),
                livroDTO.getArea());
        var livroSalvo = livroRepository.save(livro);
        var biblioteca = bibliotecaRepository.findBy();
        biblioteca.getLivros().add(livroSalvo);
        bibliotecaRepository.save(biblioteca);
        return livroSalvo;


    }


    public Livro findByNome(String nome) {
        return livroRepository.findByNome(nome).orElseThrow(
                () -> new ObjetoNaoEncontradoException
                        (" ' " + nome + " ' não existe na base de dados"));
    }

    public Livro findByIsbn(String isbn) {
        return livroRepository.findByIsbn(isbn).orElseThrow(
                () -> new ObjetoNaoEncontradoException
                        (" ' " + isbn + " ' não existe na base de dados"));
    }

    public Livro findByArea(String area) {
        return livroRepository.findByArea(area).orElseThrow(
                () -> new ObjetoNaoEncontradoException
                        (" ' " + area + " ' não existe na base de dados"));
    }

    /*public void remover2(String isbn) {
        Optional<Livro> livro = livroRepository.findByIsbn(isbn);
        var biblioteca = bibliotecaRepository.findBy();
        biblioteca.getLivros().remove(livro);
        livroRepository.delete(livro.get());

    }*/

    public void remover(String isbn){
        Livro livro = livroRepository.findByIsbn(isbn).orElseThrow(()-> new ObjetoNaoEncontradoException("Livro nao encontrado"));
        var biblioteca = bibliotecaRepository.findBy();
        biblioteca.getLivros().remove(livro);
        livroRepository.delete(livro);
    }

    public Livro update(Livro livro) {
        var biblioteca = bibliotecaRepository.findBy();
        bibliotecaRepository.save(biblioteca);
        return livroRepository.save(livro);
    }


}
