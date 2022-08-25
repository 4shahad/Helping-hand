package com.example.fainalprojectforbackend.Controller;

import com.example.fainalprojectforbackend.Model.MyUsers;
import com.example.fainalprojectforbackend.Model.Patients;
import com.example.fainalprojectforbackend.Service.PatientService;
import com.example.fainalprojectforbackend.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ipa/v1/patient")
public class PatientController {
    private final PatientService patientService;



    @GetMapping("/account")
    public Patients getPatientAccount(@RequestParam @Valid Integer patientid){
     Patients patients= patientService.PatientAccount(patientid);
     return patients;
    }

    @PutMapping("/update/contact")
    public ResponseEntity updateContact(@RequestParam @Valid String phoneNumber,@RequestParam @Valid String RelativePhoneNumber, @RequestParam @Valid String Email , @RequestParam @Valid Integer id){
        patientService.updateContact(phoneNumber,RelativePhoneNumber,Email,id);
        return ResponseEntity.status(200).body(new ApiResponse("contact updated",200));
    }

    @PutMapping("/update/location")
    public ResponseEntity updateLocation(@RequestParam @Valid String location, @RequestParam @Valid Integer id){
        patientService.updateLocation(location,id);
        return ResponseEntity.status(200).body(new ApiResponse("location updated",200));
    }
    @PutMapping("/update/health/status")
    public ResponseEntity updateHealthStatus(@RequestParam @Valid String HealthStatus, @RequestParam @Valid Integer id){
        patientService.updateHealthStatus(HealthStatus,id);
        return ResponseEntity.status(200).body(new ApiResponse("HealthStatus updated",200));
    }
}
