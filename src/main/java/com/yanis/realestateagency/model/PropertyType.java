package com.yanis.realestateagency.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "property_type")
public class PropertyType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
}
