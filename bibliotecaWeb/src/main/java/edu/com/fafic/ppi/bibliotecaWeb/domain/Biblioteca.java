package edu.com.fafic.ppi.bibliotecaWeb.domain;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String nomeInstituicao;

    @OneToOne
    private Bibliotecario bibliotecario;

    @OneToMany
    private List <Livro> livros;

    @OneToMany
    private List <Professor> professor;

    @OneToMany
    private List <Aluno> aluno;






    public Biblioteca( String nome, String nomeInstituicao, Bibliotecario bibliotecario, List<Livro> livros, List <Professor> professor, List<Aluno> aluno) {
        this.nome = nome;
        this.nomeInstituicao = nomeInstituicao;
        this.bibliotecario = bibliotecario;
        this.livros = livros;
        this.professor = professor;
        this.aluno = aluno;
    }
}
