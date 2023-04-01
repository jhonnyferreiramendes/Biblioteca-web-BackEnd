package edu.com.fafic.ppi.bibliotecaWeb.domain;

import edu.com.fafic.ppi.bibliotecaWeb.enums.Area;
import edu.com.fafic.ppi.bibliotecaWeb.enums.Genero;
import edu.com.fafic.ppi.bibliotecaWeb.enums.Periodo;
import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@DiscriminatorValue("Aluno")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Aluno extends Usuario {

   @Embedded
   private Curso curso;

    @NotNull
    @Min(1)
    @Max(10)
    private int periodo;





    public Aluno(String nome, String cpf, Genero genero, String matricula, Endereco endereco, Contato contato, Login login, Curso curso, int periodo) {
        super(nome, cpf, genero, matricula, endereco, contato, login);
        this.curso = curso;
        this.periodo = periodo;

    }
}
