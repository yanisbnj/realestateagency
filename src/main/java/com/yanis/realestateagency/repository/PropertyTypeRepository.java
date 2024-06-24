package com.yanis.realestateagency.repository;

import com.yanis.realestateagency.model.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyTypeRepository extends JpaRepository<PropertyType, Long> {
}
