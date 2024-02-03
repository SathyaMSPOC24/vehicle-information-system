package com.jade.transportmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleStudentInfo {
    @GeneratedValue
    @Id
    private int id;


    private Integer vehicleId;
    private Integer studentId;
    private String studentName;

}
