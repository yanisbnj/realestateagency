package com.yanis.realestateagency.service;

import com.yanis.realestateagency.model.Owner;
import com.yanis.realestateagency.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public Owner getOwnerById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    public Owner addOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Owner updateOwner(Long id, Owner ownerDetails) {
        Owner owner = ownerRepository.findById(id).orElse(null);
        if (owner != null) {
            owner.setFirstName(ownerDetails.getFirstName());
            owner.setLastName(ownerDetails.getLastName());
            return ownerRepository.save(owner);
        }
        return null;
    }

    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }
}
