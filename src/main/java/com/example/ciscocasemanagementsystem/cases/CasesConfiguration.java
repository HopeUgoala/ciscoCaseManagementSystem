package com.example.ciscocasemanagementsystem.cases;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDate;
import java.util.List;


@Configuration
public class CasesConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    CommandLineRunner commandLineRunner(CasesRepository repository) {
        return args -> {

            Cases case1 = new Cases(
                    "Printer failed",
                    "Hello, we noticed that our printer failed why printing multiple document",
                    "medium",
                    "in progress",
                     LocalDate.of(2022, 5, 23)
            );

            Cases case2 = new Cases(
                    "WiFI connection failed",
                    "Hello, Can you please check my network with IP address 192.0.2.1.445 it has been down for two hours now. it is very urgent",
                    "High",
                    "new",
                    LocalDate.of(2022, 5, 24)
            );
            repository.saveAll(
                    List.of(case1, case2)
            );
        };

    }
}
