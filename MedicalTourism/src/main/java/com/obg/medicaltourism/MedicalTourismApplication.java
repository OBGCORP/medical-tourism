package com.obg.medicaltourism;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MedicalTourismApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalTourismApplication.class, args);
    }

}