package com.jade.transportmanagement.service;

import com.jade.transportmanagement.entity.Vehicle;
import com.jade.transportmanagement.entity.VehicleStudentInfo;
import com.jade.transportmanagement.model.StudentInfo;
import com.jade.transportmanagement.model.StudentVehicleInfo;
import com.jade.transportmanagement.repo.VehicleRepository;
import com.jade.transportmanagement.repo.VehicleStudentInfoRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransportService {

    private static final Logger logger = LoggerFactory.getLogger(TransportService.class);
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleStudentInfoRepo vehicleStudentInfoRepo;

    public void saveVehicle(Vehicle  vehicle){
        vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAll(){
        return vehicleRepository.findAll();
    }

    public void saveVehicleStudentInfo(VehicleStudentInfo vehicleStudentInfo){
        String url = "http://localhost:8080/getById/";
        RestTemplate restTemplate = new RestTemplate();
        StudentInfo studentInfo= restTemplate.getForEntity(url+vehicleStudentInfo.getStudentId(), StudentInfo.class).getBody();
        logger.info("  studentInfo {}",studentInfo);
        vehicleStudentInfo.setStudentName(studentInfo.getStudentName());
        vehicleStudentInfoRepo.save(vehicleStudentInfo);
        logger.info("VehicleStudentInfo Saved Sucessfully {}",vehicleStudentInfo.getId());

    }

    public List<StudentVehicleInfo> getStudentVehicleInfo(Integer studentId) {
        List<StudentVehicleInfo> studentVehicleInfos = new ArrayList<>();
        List<VehicleStudentInfo> studentInfos=vehicleStudentInfoRepo.findByStudentId(studentId);
        for(VehicleStudentInfo vehicleStudentInfo :studentInfos) {
            StudentVehicleInfo studentVehicleInfo =new StudentVehicleInfo();
            studentVehicleInfo.setStudentId(vehicleStudentInfo.getStudentId());
            studentVehicleInfo.setStudentName(vehicleStudentInfo.getStudentName());
            Optional<Vehicle> vehicleOptional=vehicleRepository.findById(vehicleStudentInfo.getVehicleId());
            if(vehicleOptional.isPresent()) {
                studentVehicleInfo.setVehicle(vehicleOptional.get());
            }
            studentVehicleInfos.add(studentVehicleInfo);
        }
        return studentVehicleInfos;
    }

    public List<StudentVehicleInfo> getStudentInfo(Integer vehicleId) {
        //TODO
        return null;
    }
}
