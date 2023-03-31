package edu.com.fafic.ppi.bibliotecaWeb.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import edu.com.fafic.ppi.bibliotecaWeb.enums.Genero;
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
     @Column(unique = true)
     private String cib;

     public Bibliotecario(String nome, String cpf, Genero genero, String matricula, Endereco endereco, Contato contato, Login login, String cib) {
          super(nome, cpf, genero, matricula, endereco, contato, login);
          this.cib = cib;
     }
}
