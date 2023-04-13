package edu.com.fafic.ppi.bibliotecaWeb.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @OneToOne
    private Aluno aluno;

    @OneToOne
    private Professor professor;


    @NotNull
    private LocalDateTime dataEmprestimo;

    @OneToMany
    private List <Livro> livrosLocados;

    @Embedded
    private Devolucao devolucao;

    public Emprestimo(Aluno aluno,Professor professor, LocalDateTime dataEmprestimo, List<Livro> livrosLocados, Devolucao devolucao) {
        this.aluno = aluno;
        this.professor = professor;
        this.dataEmprestimo = dataEmprestimo;
        this.livrosLocados = livrosLocados;
        this.devolucao = devolucao;
    }
}
