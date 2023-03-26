package edu.com.fafic.ppi.bibliotecaWeb.domain;

import edu.com.fafic.ppi.bibliotecaWeb.enums.Genero;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
@Data


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
    @Size (max = 6)
    private String matricula;

    @Embedded
    private Endereco endereco;

    @Embedded
    private  Contato contato;

    @OneToOne
    private Login login;


}
