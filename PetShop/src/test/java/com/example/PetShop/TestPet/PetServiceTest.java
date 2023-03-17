package com.example.PetShop.TestPet;

import com.example.PetShop.Entitiy.Pet;
import com.example.PetShop.Repository.OwnerRepository;
import com.example.PetShop.Repository.PetRepository;
import com.example.PetShop.Service.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class PetServiceTest {

    @Mock
    private PetRepository petRepository;

    @Mock private OwnerRepository ownerRepository;

    private PetService underTest;

    @BeforeEach
    void setUp() {
        underTest = new PetService(petRepository, ownerRepository);
    }

    @Test
    void canCreatePetForExistingOwner() {
        /**given this data**/
        Pet pet = new Pet(
                "Poppy",
                1L,
                "dog",
                LocalDate.now(),
                LocalDate.now()
        );

//        if (ownerRepository.existsById(pet.getOwnerId())){
//            underTest.addNewPet(pet);
//
//            ArgumentCaptor<Pet> petArgumentCaptor =
//                    ArgumentCaptor.forClass(Pet.class);
//
//            verify(petRepository).save(petArgumentCaptor.capture());
//
//            Pet capturedPet = petArgumentCaptor.getValue();
//            assertThat(capturedPet).isEqualTo(pet);
//        } else {
//            assertThatThrownBy(() -> underTest.addNewPet(pet))
//                    .isInstanceOf(Exception.class)
//                    .hasMessageContaining("Owner "
//                            + pet.getOwnerId() + " does not exists");
//
//            verify(petRepository, never()).save(any());
//        }



    }

}
