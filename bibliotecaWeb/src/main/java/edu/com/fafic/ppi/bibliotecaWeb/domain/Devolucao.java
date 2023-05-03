package edu.com.fafic.ppi.bibliotecaWeb.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Devolucao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne()
    private Emprestimo emprestimo;
    @NotNull
    private LocalDate dataDevolucao;

    @NotNull
    private Boolean devolvido;

    private Integer diasAtrasados;

    private double valorTotal;

    public Devolucao(Emprestimo emprestimo, LocalDate dataDevolucao, Boolean devolvido, Integer diasAtrasados, double valorTotal) {
        this.emprestimo = emprestimo;
        this.dataDevolucao = dataDevolucao;
        this.devolvido = devolvido;
        this.diasAtrasados = diasAtrasados;
        this.valorTotal = valorTotal;
    }
}
