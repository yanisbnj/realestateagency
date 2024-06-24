package com.yanis.realestateagency.service;

import com.yanis.realestateagency.model.PropertyType;
import com.yanis.realestateagency.repository.PropertyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyTypeService {
    @Autowired
    PropertyTypeRepository propertyTypeRepository;

    public List<PropertyType> getAll() {
        return propertyTypeRepository.findAll();
    }

    public void add(PropertyType propertyType) {
        propertyTypeRepository.save(propertyType);
    }

    public void update(PropertyType propertyType) {
        if (findById(propertyType.getId()) != null) {
            propertyTypeRepository.save(propertyType);
        }
    }

    public void delete(Long id) {
        propertyTypeRepository.deleteById(id);
    }

    public PropertyType findById(Long id) {
        Optional<PropertyType> optionalPropertyType = propertyTypeRepository.findById(id);
        return optionalPropertyType.orElse(null);
    }
}
