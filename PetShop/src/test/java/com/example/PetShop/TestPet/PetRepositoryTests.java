package com.example.PetShop.TestPet;

import com.example.PetShop.Entitiy.Pet;
import com.example.PetShop.Repository.PetRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PetRepositoryTests {
    @Autowired
    private PetRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    public void checkIfOwnerIdExists() {
        //given
        Long ownerId = 1L;
        Pet pet = new Pet(
                "popi",
                ownerId,
                "dog",
                LocalDate.now(),
                LocalDate.now()
        );

        underTest.save(pet);

        //when
        boolean expected = underTest.selectExistsOwnerId(ownerId);

        //then
        assertThat(expected).isTrue();
    }
}
