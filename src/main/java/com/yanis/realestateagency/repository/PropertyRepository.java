package com.yanis.realestateagency.repository;

import com.yanis.realestateagency.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, String> {
    List<Property> findByPropertyType_Id(Long typeId);
    List<Property> findBySaleDateBetween(Date startDate, Date endDate);
    List<Property> findByAddressContaining(String city);
}
