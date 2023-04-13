package edu.com.fafic.ppi.bibliotecaWeb.dto;

import edu.com.fafic.ppi.bibliotecaWeb.domain.*;
import lombok.Data;


import java.util.List;

@Data

public class BibliotecaDTO {

    private String nome;
    private String nomeInstituicao;
    private Bibliotecario bibliotecario;
    private List<Livro> livros;
    private List <Professor> professor;
     private List <Aluno> aluno;


}
