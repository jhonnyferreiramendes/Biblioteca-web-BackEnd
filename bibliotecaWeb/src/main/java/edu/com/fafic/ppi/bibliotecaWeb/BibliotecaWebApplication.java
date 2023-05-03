package edu.com.fafic.ppi.bibliotecaWeb;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Devolucao;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Emprestimo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
public class BibliotecaWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaWebApplication.class, args);
	}






}
