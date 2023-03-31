package edu.com.fafic.ppi.bibliotecaWeb.dto;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Contato;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Curso;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Endereco;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Login;
import edu.com.fafic.ppi.bibliotecaWeb.enums.Area;
import edu.com.fafic.ppi.bibliotecaWeb.enums.Genero;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AlunoDTO {

    private String nome;
    private String cpf;
    private Genero genero;
    private String matricula;
    private Endereco endereco;
    private Contato contato;
    private Login login;
    private Curso curso;
    private int periodo;
}
