package edu.com.fafic.ppi.bibliotecaWeb.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@DiscriminatorValue("Bibliotecario")
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Bibliotecario extends Usuario{
     @NotBlank
     private String CIB;


}
