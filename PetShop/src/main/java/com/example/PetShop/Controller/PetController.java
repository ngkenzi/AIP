package com.example.PetShop.Controller;

import com.example.PetShop.Entitiy.Pet;
import com.example.PetShop.Service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/petshop/pet")
public class PetController<pet> {

    @Autowired
    private final PetService petService;


    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<Pet> getPets() {
        return petService.getPets();
    }

    @PostMapping
    public void registerNewPet (@RequestBody Pet pet) {
        petService.addNewPet(pet);
    }

    @DeleteMapping(path = "{petId}")
    public void deletePet(@PathVariable("petId")Long petId) {
        petService.deletePet(petId);
    }

//    @PutMapping
//    public void updatePet(
//            @RequestParam("ownerId") Long ownerId,
////            @RequestParam(required = false) String breed,
////            @RequestParam(required = false) String petName
//            @RequestBody Pet pet){
//        petService.updatePet(ownerId, pet);
//    }

//    @GetMapping(path = "{ownerId}")
//    public List<Pet> getPetsIdOwner(
//            @RequestParam(
//                    "ownerId") Long ownerId) {
//        return petService.getPetsByOwnerId(ownerId);
//    }

    @PutMapping (value = "/{ownerId}")
    public Pet updatePet (@PathVariable("ownerId") Long ownerId, @RequestBody Pet pet) {
        return petService.updatePet(ownerId, pet);
    }
}
