package com.petshop.demo.owner;

import com.petshop.demo.owner.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends
        JpaRepository<Owner, Long> {
}
