package edu.com.fafic.ppi.bibliotecaWeb.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.com.fafic.ppi.bibliotecaWeb.enums.Area;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Column(unique = true)
    private String isbn;

    @Enumerated(EnumType.STRING)
    private Area area;




    public Livro(String nome, String isbn, Area area) {
        this.nome = nome;
        this.isbn = isbn;
        this.area = area;
    }

}
