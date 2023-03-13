package com.petshop.demo.pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends
        JpaRepository<Pet, Long> {
    List<Pet> findPetsByOwnerId (Long ownerId);
    //Optional<Object> findById(Long petId, String petName);
}
