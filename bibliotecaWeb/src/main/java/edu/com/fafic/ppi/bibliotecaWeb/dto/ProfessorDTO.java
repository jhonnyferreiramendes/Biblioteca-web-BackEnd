package edu.com.fafic.ppi.bibliotecaWeb.dto;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Contato;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Curso;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Endereco;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Login;
import edu.com.fafic.ppi.bibliotecaWeb.enums.Genero;
import lombok.Data;

@Data
public class ProfessorDTO {

    private String nome;
    private String cpf;
    private Genero genero;
    private String matricula;
    private Endereco endereco;
    private Contato contato;
    private Login login;
    private Curso curso;
    private String area;
}
