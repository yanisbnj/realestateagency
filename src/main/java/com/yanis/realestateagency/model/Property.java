package com.yanis.realestateagency.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id")
    private String propertyId;

    @Column(name = "address")
    private String address;

    @Column(name = "sale_date")
    private Date saleDate;

    @Column(name = "sale_price")
    private BigDecimal salePrice;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PropertyType propertyType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
