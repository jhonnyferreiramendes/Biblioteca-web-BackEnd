package edu.com.fafic.ppi.bibliotecaWeb.dto;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Devolucao;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Livro;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Usuario;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class EmprestimoDTO {

    private Usuario usuario;
    private LocalDateTime dataEmprestimo;
    private Livro livrosLocados;
    private Devolucao devolucao;

}
