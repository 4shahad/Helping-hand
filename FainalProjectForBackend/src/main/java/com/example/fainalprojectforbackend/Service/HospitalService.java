package com.example.fainalprojectforbackend.Service;

import com.example.fainalprojectforbackend.Model.Hospital;
import com.example.fainalprojectforbackend.Model.Patients;
import com.example.fainalprojectforbackend.Repository.HospitalRepository;
import com.example.fainalprojectforbackend.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository hospitalRepository;
    private final PatientRepository patientRepository;

    public Hospital gitHospitalAccount(String name){
        Hospital Account= hospitalRepository.findHospitalByName(name);
        if (Account==null){
            System.out.println("there is no hospital have this name");
        }
        return Account;
    }

  public List<Hospital> gitAllHospital(){
        return hospitalRepository.findAll();
    }

    public void updateStatus (String name,String status){
        Hospital oldStatus=hospitalRepository.findHospitalByName(name);
        if (oldStatus==null){
            System.out.println("there is no hospital to update");
        }
        oldStatus.setStatus(status);
        hospitalRepository.save(oldStatus);
    }

    public List<Hospital> gitByLocation(String Location){
        List<Hospital> allHospital= hospitalRepository.findHospitalByLocation(Location);
        return allHospital;
    }
}
