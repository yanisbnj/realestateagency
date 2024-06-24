package com.yanis.realestateagency.service;

import com.yanis.realestateagency.model.Property;
import com.yanis.realestateagency.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Property getPropertyById(String propertyId) {
        return propertyRepository.findById(propertyId).orElse(null);
    }

    public Property addProperty(Property property) {
        return propertyRepository.save(property);
    }

    public Property updateProperty(String propertyId, Property propertyDetails) {
        Property property = propertyRepository.findById(propertyId).orElse(null);
        if (property != null) {
            property.setAddress(propertyDetails.getAddress());
            property.setSaleDate(propertyDetails.getSaleDate());
            property.setSalePrice(propertyDetails.getSalePrice());
            property.setPropertyType(propertyDetails.getPropertyType());
            property.setOwner(propertyDetails.getOwner());
            return propertyRepository.save(property);
        }
        return null;
    }

    public void deleteProperty(String propertyId) {
        propertyRepository.deleteById(propertyId);
    }

    public List<Property> getPropertiesByType(Long typeId) {
        return propertyRepository.findByPropertyType_Id(typeId);
    }

    public List<Property> getPropertiesBySaleDateBetween(Date startDate, Date endDate) {
        return propertyRepository.findBySaleDateBetween(startDate, endDate);
    }

    public List<Property> getPropertiesByCity(String city) {
        return propertyRepository.findByAddressContaining(city);
    }
}
