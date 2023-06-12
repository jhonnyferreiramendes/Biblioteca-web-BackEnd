package edu.com.fafic.ppi.bibliotecaWeb;

import edu.com.fafic.ppi.bibliotecaWeb.domain.Devolucao;
import edu.com.fafic.ppi.bibliotecaWeb.domain.Emprestimo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
public class BibliotecaWebApplication implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**").allowedMethods("GET", "PUT", "POST", "DELETE");
    }

    public static void main(String[] args) {
        SpringApplication.run(BibliotecaWebApplication.class, args);


    }


}
