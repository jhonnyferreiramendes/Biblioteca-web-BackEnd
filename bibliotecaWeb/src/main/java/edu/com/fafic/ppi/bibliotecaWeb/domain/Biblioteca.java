package edu.com.fafic.ppi.bibliotecaWeb.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    private List <Usuario> usuarios;




}
