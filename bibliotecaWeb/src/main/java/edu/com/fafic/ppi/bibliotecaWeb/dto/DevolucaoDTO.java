package edu.com.fafic.ppi.bibliotecaWeb.dto;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Emprestimo;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Data
public class DevolucaoDTO {


    private Emprestimo emprestimo;

    private LocalDate dataDevolucao;

    private Boolean devolvido;

    private Integer diasAtrasados;

    private double  valorDaMulta;
}
