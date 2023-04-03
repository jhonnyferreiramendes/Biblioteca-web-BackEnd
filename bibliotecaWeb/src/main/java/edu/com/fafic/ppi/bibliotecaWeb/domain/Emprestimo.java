package edu.com.fafic.ppi.bibliotecaWeb.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    public Emprestimo(Usuario usuario, LocalDateTime dataEmprestimo, Livro livrosLocados, Devolucao devolucao) {
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.livrosLocados = livrosLocados;
        this.devolucao = devolucao;
    }
}
