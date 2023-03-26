package edu.com.fafic.ppi.bibliotecaWeb.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor



public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @ManyToOne
    private Usuario usuario;

    @NotBlank
    private LocalDateTime dataEmprestimo;


    @NotBlank
    @OneToOne
    private Livro livrosLocados;

    @Embedded
    private Devolucao devolucao;
}
