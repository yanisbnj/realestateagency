package com.yanis.realestateagency.repository;

import com.yanis.realestateagency.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
