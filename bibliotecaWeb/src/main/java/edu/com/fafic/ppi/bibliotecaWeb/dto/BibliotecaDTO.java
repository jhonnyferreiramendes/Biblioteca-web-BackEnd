package edu.com.fafic.ppi.bibliotecaWeb.dto;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Bibliotecario;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Livro;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Usuario;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class BibliotecaDTO {

    private Long id;
    private String nome;
    private String nomeInstituicao;
    private Bibliotecario bibliotecario;
    private List<Livro> livros;
    private List <Usuario> usuarios;

}
