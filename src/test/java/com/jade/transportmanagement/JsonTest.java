package com.jade.transportmanagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jade.transportmanagement.entity.Vehicle;
import com.jade.transportmanagement.entity.VehicleStudentInfo;

import java.math.BigDecimal;

public class JsonTest {
    public  static  void main(String arg[]) throws Exception{
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Vechile-K");
        vehicle.setRouteName("Kolathur");
        vehicle.setDriverName("Raman");
        vehicle.setCost(new BigDecimal(19000));


        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(" Json String "+ objectMapper.writeValueAsString(vehicle));

        VehicleStudentInfo vehicleStudentInfo = new VehicleStudentInfo();
        vehicleStudentInfo.setStudentId(1);
        vehicleStudentInfo.setVehicleId(1);
        System.out.println(" ==>"+objectMapper.writeValueAsString(vehicleStudentInfo));

    }
}
