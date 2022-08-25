package com.example.fainalprojectforbackend.Controller;

import com.example.fainalprojectforbackend.Model.AmbulanceCenter;
import com.example.fainalprojectforbackend.Model.Patients;
import com.example.fainalprojectforbackend.Service.AmbulanceCenterService;
import com.example.fainalprojectforbackend.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ambulance")
public class AmbulanceCenterController {
    private final AmbulanceCenterService ambulanceCenterService;

    @GetMapping("/account")
    public AmbulanceCenter gitAccount(@RequestParam @Valid String name){
        return ambulanceCenterService.gitAccountAmbulance(name);
    }

    @GetMapping("/all/ambulance/center")
    public List<AmbulanceCenter> gitAllAmbulanceCenter(){
        return ambulanceCenterService.gitAllAmbulanceCenter();
    }

    @PutMapping("/update/status")
    public ResponseEntity updateStatus(@RequestParam @Valid String name, @RequestParam @Valid String status){
        ambulanceCenterService.updateStatus(name,status);
        return ResponseEntity.status(200).body(new ApiResponse("status updated to :"+ status,200));
    }

    @GetMapping("/git/location")
    public ResponseEntity gitByLocation(@RequestParam @Valid String Location){
        return ResponseEntity.status(200).body( ambulanceCenterService.gitByLocation(Location));
    }

}
