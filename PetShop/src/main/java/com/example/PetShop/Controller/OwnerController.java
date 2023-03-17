package com.example.PetShop.Controller;

import com.example.PetShop.Entitiy.Owner;
import com.example.PetShop.Service.OwnerService;
import com.example.PetShop.Service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "api/v1/petshop/owner")
public class OwnerController {

    private final OwnerService ownerService;
    private final PetService petService;

    @Autowired
    public OwnerController(OwnerService ownerService, PetService petService) {
        this.ownerService = ownerService;
        this.petService = petService;
    }

    @GetMapping
    public List<Owner> getOwners() {
        return ownerService.getOwners();
    }

    @PostMapping
    public void registerNewUser(@RequestBody Owner owner) {
        ownerService.addNewOwner(owner);}



}






