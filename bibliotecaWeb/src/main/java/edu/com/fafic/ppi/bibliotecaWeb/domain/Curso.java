package edu.com.fafic.ppi.bibliotecaWeb.domain;


import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Embeddable
public class Curso {

    @NotBlank
    private String nomeDoCurso;

    @NotBlank
    private String AreaDoCurso;
}


