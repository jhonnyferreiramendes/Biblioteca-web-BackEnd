package edu.com.fafic.ppi.bibliotecaWeb.dto;

import edu.com.fafic.ppi.bibliotecaWeb.domain.*;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class EmprestimoDTO {

    private Aluno aluno;
    private Professor professor;
    private LocalDate dataEmprestimo;
    private List<Livro> livrosLocados;

}
