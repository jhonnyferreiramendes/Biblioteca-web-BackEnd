package edu.com.fafic.ppi.bibliotecaWeb.domain;


import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Embeddable
public class Curso {

    @NotBlank
    private String nomeDoCurso;

    @NotBlank
    private String AreaDoCurso;
}


