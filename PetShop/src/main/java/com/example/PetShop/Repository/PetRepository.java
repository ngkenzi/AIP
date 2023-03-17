package com.example.PetShop.Repository;


import com.example.PetShop.Entitiy.Pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findPetsByOwnerId(Long ownerId);

    //Optional<Object> findById(Long petId, String petName);

    @Query("" +
            "SELECT CASE WHEN COUNT(s) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Pet s " +
            "WHERE s.ownerId = ?1"
    )

    boolean selectExistsOwnerId(Long ownerId);


}
