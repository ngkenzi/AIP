package com.example.PetShop.Service;

import com.example.PetShop.Entitiy.Owner;
import com.example.PetShop.Repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> getOwners() {
        return ownerRepository.findAll();
    }

    public void addNewOwner(Owner owner) {
        owner.setId(null);
        owner.setDateCreated(LocalDate.now());
        owner.setDateModified(LocalDate.now());
        ownerRepository.save(owner);

    }

    public void addNewExisting(Owner owner) {
        boolean exists = ownerRepository.existsById(owner.getId());
        if (exists) {
            //petR.save(owner);
        }

    }


}
