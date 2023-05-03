package edu.com.fafic.ppi.bibliotecaWeb.domain;

import edu.com.fafic.ppi.bibliotecaWeb.enums.Genero;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
@Data
@NoArgsConstructor


public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2)
    private String nome;

    @NotBlank
    @CPF
    private String cpf;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @NotBlank
    @Column(unique = true)
    @Size (max = 6)
    private String matricula;

    @Embedded
    private Endereco endereco;

    @Embedded
    private  Contato contato;

    @OneToOne(cascade = CascadeType.ALL)
    private Login login;

    public Usuario(String nome, String cpf, Genero genero, String matricula, Endereco endereco, Contato contato, Login login) {
        this.nome = nome;
        this.cpf = cpf;
        this.genero = genero;
        this.matricula = matricula;
        this.endereco = endereco;
        this.contato = contato;
        this.login = login;
    }
}
