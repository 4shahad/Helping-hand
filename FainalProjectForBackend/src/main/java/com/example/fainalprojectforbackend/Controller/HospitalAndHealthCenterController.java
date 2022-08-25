package com.example.fainalprojectforbackend.Controller;

import com.example.fainalprojectforbackend.Model.Hospital;
import com.example.fainalprojectforbackend.Model.Patients;
import com.example.fainalprojectforbackend.Service.HospitalService;
import com.example.fainalprojectforbackend.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hospital")
@RequiredArgsConstructor
public class HospitalAndHealthCenterController {
    private final HospitalService hospitalService;

    @GetMapping("/account")
    public Hospital gitAccount(@RequestParam @Valid String name){
        return hospitalService.gitHospitalAccount(name);
    }
    @GetMapping("/all/hospitals")
    public List<Hospital> gitAllHospitals(){
   return hospitalService.gitAllHospital();
    }
    @PutMapping("/update/status")
    public ResponseEntity updateStatus(@RequestParam @Valid String name,@RequestParam String status){
        hospitalService.updateStatus(name,status);
        return ResponseEntity.status(200).body(new ApiResponse("status updated to :"+ status,200));
    }
    @GetMapping("/git/location")
    public ResponseEntity gitByLocation(@RequestParam @Valid String Location){
      return  ResponseEntity.status(200).body( hospitalService.gitByLocation(Location));
    }
}
