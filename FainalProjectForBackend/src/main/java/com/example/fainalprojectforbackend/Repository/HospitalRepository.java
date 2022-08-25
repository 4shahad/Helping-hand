package com.example.fainalprojectforbackend.Repository;
import com.example.fainalprojectforbackend.Model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
    Hospital findHospitalByName(String name);
    List<Hospital> findHospitalByLocation(String location);
}
