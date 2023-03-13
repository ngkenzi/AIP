package com.petshop.demo.pet;
import com.petshop.demo.owner.Owner;
import com.petshop.demo.owner.OwnerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    public PetService(PetRepository petRepository, OwnerRepository ownerRepository) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
    }

    public List<Pet> getPets() {
        return petRepository.findAll();
    }

    public List<Pet> findPetsByOwnerId(Long ownerId) {
        return petRepository.findPetsByOwnerId(ownerId);
    }


    public Owner existingOwner (Long ownerId) {
        return ownerRepository.findById(ownerId)
                .orElseThrow(() -> new IllegalArgumentException("OwnerId: " + ownerId + " does not exist"));
    }

    public void addNewService(Pet pet) {
        ownerRepository.findById(pet.getOwnerId())
                .orElseThrow(() -> new IllegalStateException("Owner does not exists"));

        pet.setId(null);
        pet.setDateCreated(LocalDate.now());
        pet.setDateModified(LocalDate.now());

        petRepository.save(pet);

    }

    public void deletePet(Long petId) {
        petRepository.findById(petId)
                .orElseThrow(() -> new IllegalStateException("Pet does not exists"));
        petRepository.deleteById(petId);
    }


    public Pet updatePet(Long ownerId, Pet updateData) {

        //fetch pet from db
        Pet existingPet = petRepository.findById(updateData.getId())
                .orElseThrow(() -> new IllegalStateException("Pet does not exists"));
        //update name breed
        existingPet.setPetName(updateData.getPetName());
        existingPet.breed = updateData.breed;
        petRepository.save(existingPet);
        return existingPet;
    }
}
