package com.example.fainalprojectforbackend.Service;

import com.example.fainalprojectforbackend.Model.MyUsers;
import com.example.fainalprojectforbackend.Model.Patients;
import com.example.fainalprojectforbackend.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;



    public Patients PatientAccount(Integer id){
        if (patientRepository.findPatientsByPatientid(id)==null){
            System.out.println("some thing wrong here");
        }
   return patientRepository.findPatientsByPatientid(id);}



    public void updateContact(String phoneNumber,String RelativePhoneNumber,String Email , Integer id){
        Patients oldPatient=patientRepository.findPatientsByPatientid(id);
        if (oldPatient==null){
            System.out.println("there is nothing to update some thing wrong");
        }
        oldPatient.setPhoneNumber(phoneNumber);
        oldPatient.setRelativePhoneNumber(RelativePhoneNumber);
        oldPatient.setEmail(Email);
        patientRepository.save(oldPatient);

    }

    public void updateLocation(String Location, Integer id){
        Patients oldPatient=patientRepository.findPatientsByPatientid(id);
        if (oldPatient==null){
            System.out.println("there is nothing to update some thing wrong");
        }
     oldPatient.setLocation(Location);
        patientRepository.save(oldPatient);

    }

    public void updateHealthStatus(String HealthStatus, Integer id){
        Patients oldPatient=patientRepository.findPatientsByPatientid(id);
        if (oldPatient==null){
            System.out.println("there is nothing to update some thing wrong");
        }
        oldPatient.setHealthStatus(HealthStatus);
        patientRepository.save(oldPatient);

    }
}

