package com.example.fainalprojectforbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Data
public class RegisterForm {
    //
    @NotEmpty(message = "userName mandatory ")
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "password is mandatory")
   // @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$"
    //        ,message = "put strong password ")
    private String password;
    @NotEmpty(message = "role is mandatory")
  // @Pattern(regexp = "(Patients|Hospital|AmbulanceCenter)")
    private String role;
//
    private String ambulancename ;
    private String  ambulancestatus;
    private String ambulancelocation;
    private String ambulancephonenumber;

    //
    private String hospitalname ;
    private String hospitalstatus;
    private String hospitallocation;
    private String hospitalphonenumber ;
//


    private String patientname ;
    private Integer patientid;
    private String patientphonenumber ;
    private String patientrelativephonenumber ;
    private String patientemail;
    private String patienthealthstatus;
    private String patientlocation;


}
