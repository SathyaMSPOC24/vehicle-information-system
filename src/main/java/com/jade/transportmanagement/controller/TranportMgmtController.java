package com.jade.transportmanagement.controller;

import com.jade.transportmanagement.entity.Vehicle;
import com.jade.transportmanagement.entity.VehicleStudentInfo;
import com.jade.transportmanagement.model.StudentVehicleInfo;
import com.jade.transportmanagement.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TranportMgmtController {

    @Autowired
    private TransportService transportService;

    @GetMapping("/")
    public String hello(){
        return "Welcome to Transport Management System";
    }

    @PostMapping("/saveVehicle")
    public String saveVehicle(@RequestBody Vehicle vehicle) {
        transportService.saveVehicle(vehicle);
        return "Vechile Information saved successfully";
    }

    @GetMapping("/getAll")
    public List<Vehicle> getAll(){
        return transportService.getAll();
    }


    @GetMapping("/student/{id}")
    public List<StudentVehicleInfo> getStudentVehiceInfo(@PathVariable Integer id){
        return transportService.getStudentVehicleInfo(id);
    }

    @PostMapping("/saveVehicleStudentInfo")
    public String saveVehcicleStudentIno(@RequestBody VehicleStudentInfo  vehicleStudentInfo) {
        transportService.saveVehicleStudentInfo(vehicleStudentInfo);
        return "Saved Sucessfully";
    }



}

