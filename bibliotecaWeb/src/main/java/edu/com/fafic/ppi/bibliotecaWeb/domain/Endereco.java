package edu.com.fafic.ppi.bibliotecaWeb.domain;


import javax.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Endereco {

    private String UF;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
}
