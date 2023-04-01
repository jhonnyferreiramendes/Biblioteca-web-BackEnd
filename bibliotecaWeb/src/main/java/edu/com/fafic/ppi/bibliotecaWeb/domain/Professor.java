package edu.com.fafic.ppi.bibliotecaWeb.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
}
