package com.example.PetShop.TestOwner;

import com.example.PetShop.Repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest

public class OwnerRepositoryTests {

    @Autowired
    private OwnerRepository ownerRepository;

    //JUnit test for saveEmployee
//    @Test
//    public void saveOwnerTest() {
//        Owner owner
//    }

}
