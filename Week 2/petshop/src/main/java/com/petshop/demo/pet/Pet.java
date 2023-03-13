package com.petshop.demo.pet;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Pet {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )

    private Long petId;
    private String petName;
    private Long ownerId;

    String breed;
    private LocalDate dateCreated;
    private LocalDate dateModified;

    public Pet() {
    }

    public Pet(String petName, Long ownerId, String breed, LocalDate dateCreated, LocalDate dateModified) {
        this.petName = petName;
        this.ownerId = ownerId;
        this.breed = breed;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    public Pet(Long petId, String petName, Long ownerId, String breed, LocalDate dateCreated, LocalDate dateModified) {
        this.petId = petId;
        this.petName = petName;
        this.ownerId = ownerId;
        this.breed = breed;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    public Long getId() {
        return petId;
    }

    public void setId(Long petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDate dateModified) {
        this.dateModified = dateModified;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", petName='" + petName + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", breed='" + breed + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                '}';
    }
}
