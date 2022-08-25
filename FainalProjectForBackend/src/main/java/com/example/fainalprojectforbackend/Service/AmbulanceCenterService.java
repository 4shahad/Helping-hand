package com.example.fainalprojectforbackend.Service;

import com.example.fainalprojectforbackend.Model.AmbulanceCenter;
import com.example.fainalprojectforbackend.Model.Patients;
import com.example.fainalprojectforbackend.Repository.AmbulanceRepository;
import com.example.fainalprojectforbackend.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AmbulanceCenterService {
private final AmbulanceRepository ambulanceRepository;



    public AmbulanceCenter gitAccountAmbulance(String name){
        AmbulanceCenter account = ambulanceRepository.findAmbulanceCenterByName(name);
        if (account==null){
            System.out.println("there is no AmbulanceCenter have this name");
        }
        return account;
    }

    public List<AmbulanceCenter> gitAllAmbulanceCenter(){
        return ambulanceRepository.findAll();
    }

    public void updateStatus (String name,String status){
        AmbulanceCenter oldStatus=ambulanceRepository.findAmbulanceCenterByName(name);
        if (oldStatus==null){
            System.out.println("there is no AmbulanceCenter to update");
        }
        oldStatus.setStatus(status);
        ambulanceRepository.save(oldStatus);
    }
    public List<AmbulanceCenter> gitByLocation(String Location){
        List<AmbulanceCenter> allAmbulance= ambulanceRepository.findAllByLocation(Location);
        return allAmbulance;
    }
}
