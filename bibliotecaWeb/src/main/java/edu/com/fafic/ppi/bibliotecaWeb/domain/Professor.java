package edu.com.fafic.ppi.bibliotecaWeb.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import edu.com.fafic.ppi.bibliotecaWeb.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@DiscriminatorValue("Professor")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Professor extends Usuario {

    @Embedded
    private Curso curso;

    @NotBlank
    private String area;


    public Professor(String nome, String cpf, Genero genero, String matricula, Endereco endereco, Contato contato, Login login, Curso curso, String area) {
        super(nome, cpf, genero, matricula, endereco, contato, login);
        this.curso = curso;
        this.area = area;
    }
}
