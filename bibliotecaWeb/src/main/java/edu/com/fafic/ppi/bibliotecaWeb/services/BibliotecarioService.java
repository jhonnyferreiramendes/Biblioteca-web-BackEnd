package edu.com.fafic.ppi.bibliotecaWeb.services;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Aluno;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Bibliotecario;
import edu.com.fafic.ppi.bibliotecaWeb.domain.exceptions.ObjetoNaoEncontradoException;
import edu.com.fafic.ppi.bibliotecaWeb.dto.AlunoDTO;
import edu.com.fafic.ppi.bibliotecaWeb.dto.BibliotecarioDTO;
import edu.com.fafic.ppi.bibliotecaWeb.repositories.AlunoRepository;
import edu.com.fafic.ppi.bibliotecaWeb.repositories.BibliotecarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class BibliotecarioService {

    private final BibliotecarioRepository bibliotecarioRepository;

    public Bibliotecario save(BibliotecarioDTO bibliotecarioDTO) {
        var bibliotecario = new Bibliotecario(
                bibliotecarioDTO.getNome(),
                bibliotecarioDTO.getCpf(),
                bibliotecarioDTO.getGenero(),
                bibliotecarioDTO.getMatricula(),
                bibliotecarioDTO.getEndereco(),
                bibliotecarioDTO.getContato(),
                bibliotecarioDTO.getLogin(),
                bibliotecarioDTO.getCib());
        return bibliotecarioRepository.save(bibliotecario);
    }


    public Bibliotecario findByNome(String nome) {
        return bibliotecarioRepository.findByNome(nome).orElseThrow(() -> new ObjetoNaoEncontradoException
                (" ' "+ nome + " ' não existe na base de dados"));
    }




}
