package com.example.fainalprojectforbackend.Service;

import com.example.fainalprojectforbackend.Exception.ApiException;
import com.example.fainalprojectforbackend.Model.AmbulanceCenter;
import com.example.fainalprojectforbackend.Model.Hospital;
import com.example.fainalprojectforbackend.Model.MyUsers;
import com.example.fainalprojectforbackend.Model.Patients;
import com.example.fainalprojectforbackend.Repository.AmbulanceRepository;
import com.example.fainalprojectforbackend.Repository.HospitalRepository;
import com.example.fainalprojectforbackend.Repository.MyUserRepository;
import com.example.fainalprojectforbackend.Repository.PatientRepository;
import com.example.fainalprojectforbackend.dto.RegisterForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserService {
    private final MyUserRepository myUserRepository;
    private final AmbulanceRepository ambulanceRepository;
    private final HospitalRepository hospitalRepository;
    private final PatientRepository patientRepository;
    public void Register(RegisterForm registerForm){
        String hashedPassword= new BCryptPasswordEncoder().encode(registerForm.getPassword());
        registerForm.setPassword(hashedPassword);
        MyUsers myUsers=new MyUsers(null,registerForm.getUsername(),registerForm.getPassword(),registerForm.getRole());
        MyUsers newMyUsers= myUserRepository.save(myUsers);
        //System.out.println(myUsers.getRole().equals("Patients"));
            if (registerForm.getRole().equals("Patients")){
                Patients newPatients = new Patients(null,registerForm.getPatientid(),newMyUsers.getId(),registerForm.getPatientname(),
                        registerForm.getPatientphonenumber(),registerForm.getPatientrelativephonenumber(),
                        registerForm.getPatientemail(),registerForm.getPatienthealthstatus(),registerForm.getPatientlocation());
                patientRepository.save(newPatients);
            }

        else if (registerForm.getRole().equals("Hospital")){
                Hospital hospital = new Hospital(null,newMyUsers.getId(),registerForm.getHospitalname(),registerForm.getHospitalstatus(),registerForm.getHospitallocation(),registerForm.getHospitalphonenumber());
                hospitalRepository.save(hospital);
            }

             else if (myUsers.getRole().equals("AmbulanceCenter"))    {
                AmbulanceCenter ambulanceCenter = new AmbulanceCenter(null, newMyUsers.getId(),registerForm.getAmbulancename(), registerForm.getAmbulancestatus(),
                        registerForm.getAmbulancelocation(),registerForm.getAmbulancephonenumber());
                ambulanceRepository.save(ambulanceCenter);
            }
        }
    public void updatePassword (String username ,String password){
        MyUsers oldUser=myUserRepository.findMyUsersByUserName(username);
        if (oldUser==null){
            throw new ApiException("wrong you can not update the password") ;
        }
        oldUser.setPassword(new BCryptPasswordEncoder().encode(password));
        myUserRepository.save(oldUser);
    }
}
