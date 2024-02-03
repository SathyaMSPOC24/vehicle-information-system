package com.jade.transportmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @GeneratedValue
    @Id
    private int id;
    private String vehicleName;
    private String routeName;
    private String driverName;
    private BigDecimal cost;

}
