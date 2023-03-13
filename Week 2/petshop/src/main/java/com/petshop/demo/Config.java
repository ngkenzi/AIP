package com.petshop.demo;

import com.petshop.demo.owner.OwnerRepository;
import com.petshop.demo.owner.Owner;
import com.petshop.demo.pet.PetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class Config {
    @Bean
    CommandLineRunner commandLineRunner(
            OwnerRepository ownerRepository, PetRepository petRepository) {
        return args -> {
            Owner mariam = new Owner(
                   "mariam",
                    "kim",
                    LocalDate.of(1987, Month.JANUARY, 5),
                    LocalDate.of(1987, Month.JANUARY, 12)
            );

            Owner kong = new Owner(
                    "kong",
                    "yung",
                    LocalDate.of(1876, Month.JANUARY, 3),
                    LocalDate.of(1987, Month.JANUARY, 8)
            );

            ownerRepository.saveAll(
                    List.of(mariam, kong)
            );
        };
    }
}
