package com.example.PetShop.TestOwner;

import com.example.PetShop.Entitiy.Owner;
import com.example.PetShop.Entitiy.Pet;
import com.example.PetShop.Repository.OwnerRepository;
import com.example.PetShop.Repository.PetRepository;
import com.example.PetShop.Service.OwnerService;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OwnerServiceTest {

    //Create a mocking database for Owner and Pet repo
    @Mock
    private OwnerRepository ownerRepository;

    @Mock
    private PetRepository petRepository;

    //specify the test object
    private OwnerService underTest;

    //Before all tests, do as follows..
    @BeforeEach
    void setUp() {
        underTest = new OwnerService(ownerRepository);
    }

    //User can create new owner using API
    @Test
    void userCanCreateNewOwner() {

        /** given this data **/
        Owner owner = new Owner(
                "Kenzi",
                "Ng",
                LocalDate.now(),
                LocalDate.now()
        );

        /**when this operation occurs**/
        underTest.addNewOwner(owner);

        /**
         then
         1. Check that owner repo invoked is same as the owner we passed in test.
         2. ArgumentCaptor allows us to capture an argument passed to a method to inspect
         **/

        /**ArgumentCaptor store type of Owner data field to capture the Owner from Owner class**/
        ArgumentCaptor<Owner> ownerArgumentCaptor =
                ArgumentCaptor.forClass(Owner.class);


        verify(ownerRepository).save(ownerArgumentCaptor.capture());

        /** After getting the captured value, it will be stored in this capturedOwner **/
        Owner capturedOwner = ownerArgumentCaptor.getValue();

        /** If this captured value is same as passed in value then return true **/
        assertThat(capturedOwner).isEqualTo(owner);
    }



}
