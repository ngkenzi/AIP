package com.example.PetShop;

import com.example.PetShop.Entitiy.Owner;
import com.example.PetShop.Repository.OwnerRepository;
import com.example.PetShop.Repository.PetRepository;
import org.springframework.boot.CommandLineRunner;;
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

            Owner yongkin = new Owner(
                    "yong",
                    "kin",
                    LocalDate.of(2022, Month.JANUARY, 3),
                    LocalDate.of(2023, Month.JANUARY, 8)
            );

            ownerRepository.saveAll(
                    List.of(mariam, kong)
            );
        };
    }
}
