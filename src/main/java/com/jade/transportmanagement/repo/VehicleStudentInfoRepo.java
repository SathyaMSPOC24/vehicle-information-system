package com.jade.transportmanagement.repo;

import com.jade.transportmanagement.entity.VehicleStudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleStudentInfoRepo extends JpaRepository<VehicleStudentInfo,Integer> {

    @Query("select u from VehicleStudentInfo u where u.studentId = ?1")
    List<VehicleStudentInfo> findByStudentId(Integer studentId);
}
