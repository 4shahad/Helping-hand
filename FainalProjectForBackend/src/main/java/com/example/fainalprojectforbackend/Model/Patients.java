package com.example.fainalprojectforbackend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.*;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Patients{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private Integer patientid;
    private Integer userId;
    @NotEmpty(message = "Name is mandatory")
    private String name ;

    @NotEmpty(message = "Phone Number mandatory")
    private String phoneNumber ;

    @NotEmpty(message = "Relative Phone Number mandatory")
    private String relativePhoneNumber ;

    @NotEmpty(message = "Email is mandatory")
   @Email(message = "Put valid email")
    private String email;

    @NotEmpty(message = "Tell us about your HealthStatus ")
    @Column(columnDefinition = "TEXT",nullable = true)
    private String healthStatus;

    @NotEmpty(message = "location is mandatory")
    private String location;
}
