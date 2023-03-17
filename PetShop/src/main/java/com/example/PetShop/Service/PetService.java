package com.example.PetShop.Service;
import com.example.PetShop.Entitiy.Owner;
import com.example.PetShop.Entitiy.Pet;
import com.example.PetShop.Repository.OwnerRepository;
import com.example.PetShop.Repository.PetRepository;
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

    public void addNewPet(Pet pet) {
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
        existingPet.setBreed(updateData.getBreed());
        petRepository.save(existingPet);
        return existingPet;
    }


}
