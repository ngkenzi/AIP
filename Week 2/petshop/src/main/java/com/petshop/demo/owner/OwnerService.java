package com.petshop.demo.owner;

import org.springframework.beans.factory.annotation.Autowired;
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

    public void addNewService(Owner owner) {
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
