package com.example.PetShop.Repository;

import com.example.PetShop.Entitiy.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OwnerRepository extends
        JpaRepository<Owner, Long> {
}
