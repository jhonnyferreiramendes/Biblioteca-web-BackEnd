package edu.com.fafic.ppi.bibliotecaWeb.domain;

import edu.com.fafic.ppi.bibliotecaWeb.enums.Area;
import edu.com.fafic.ppi.bibliotecaWeb.enums.Periodo;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
