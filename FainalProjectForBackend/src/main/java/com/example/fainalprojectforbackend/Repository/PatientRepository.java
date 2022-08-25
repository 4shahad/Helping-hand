package com.example.fainalprojectforbackend.Repository;

import com.example.fainalprojectforbackend.Model.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patients,Integer> {
    Patients findPatientsByPatientid(Integer id);


}
