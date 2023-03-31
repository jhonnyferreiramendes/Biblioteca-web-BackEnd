package edu.com.fafic.ppi.bibliotecaWeb.dto;

import edu.com.fafic.ppi.bibliotecaWeb.enums.Area;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@Data

public class LivroDTO {


    private String nome;


    private String isbn;


    private Area area;


}
