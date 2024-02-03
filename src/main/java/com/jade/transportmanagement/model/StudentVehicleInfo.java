package com.jade.transportmanagement.model;

import com.jade.transportmanagement.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVehicleInfo {
    private Integer studentId;
    private String studentName;
    private Vehicle vehicle;
}
