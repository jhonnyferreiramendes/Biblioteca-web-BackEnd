package edu.com.fafic.ppi.bibliotecaWeb.services;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Livro;
import edu.com.fafic.ppi.bibliotecaWeb.domain.exceptions.ObjetoNaoEncontradoException;
import edu.com.fafic.ppi.bibliotecaWeb.dto.LivroDTO;
import edu.com.fafic.ppi.bibliotecaWeb.repositories.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;


    public Livro saveLivro(LivroDTO livroDTO){
        var livro = new Livro(
                livroDTO.getNome(),
                livroDTO.getIsbn(),
                livroDTO.getArea());
        return livroRepository.save(livro);

    }

    public Livro findByNome(String nome){
        return livroRepository.findByNome(nome).orElseThrow(()-> new ObjetoNaoEncontradoException("Não existe o nome: " +nome));
    }

    public Livro findByIsbn(String isbn){
        return livroRepository.findByIsbn(isbn).orElseThrow(() -> new ObjetoNaoEncontradoException("Não existe o id: " +isbn));
    }

    public Livro findByArea(String area){
        return livroRepository.findByArea(area).orElseThrow(()-> new ObjetoNaoEncontradoException("Não existe a area: " +area));
    }


}
