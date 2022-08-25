package com.example.fainalprojectforbackend.Repository;

import com.example.fainalprojectforbackend.Model.AmbulanceCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmbulanceRepository extends JpaRepository<AmbulanceCenter,Integer> {
    AmbulanceCenter findAmbulanceCenterByName(String name);
    List<AmbulanceCenter> findAllByLocation(String location);
}
