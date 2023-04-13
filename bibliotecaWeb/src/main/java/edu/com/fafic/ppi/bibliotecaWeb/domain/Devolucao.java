package edu.com.fafic.ppi.bibliotecaWeb.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;


import java.time.LocalDateTime;


@Data
@Embeddable

public class Devolucao {


    private LocalDateTime dataDevolucao;

    @NotBlank
    private Boolean devolvido;



}
