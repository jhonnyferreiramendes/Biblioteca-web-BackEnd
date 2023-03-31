package edu.com.fafic.ppi.bibliotecaWeb.domain;

import edu.com.fafic.ppi.bibliotecaWeb.enums.Area;
import edu.com.fafic.ppi.bibliotecaWeb.enums.Periodo;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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

    @NotBlank
    @Min(1)
    @Max(10)
    private int periodo;

    @Enumerated(EnumType.STRING)
    private Area area;




}
