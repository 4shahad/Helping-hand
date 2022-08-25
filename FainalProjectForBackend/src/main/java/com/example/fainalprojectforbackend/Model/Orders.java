package com.example.fainalprojectforbackend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id ;

    @NotEmpty(message = "OrderType is mandatory")
    @Pattern(regexp = "(Emergency|NotEmergency)")
    private String ordert;
//    @NotEmpty(message = "OrderAccept by hospital or healthCenter is mandatory")
    private boolean orderaccepthospital=false;
 //  @NotEmpty(message = "OrderAccept by hospital or healthCenter is mandatory")
    private boolean orderacceptambulance=false;

    @NotNull(message = "Id is mandatory")
//    @Size(min = 10 , max = 10 , message = "Put valid  Id ")
//    @UniqueElements(message = "Id has to be unique")
    private Integer patientid ;

    @NotEmpty(message = "Name is mandatory")
    private String patientname ;

    @NotEmpty(message = "Gender is mandatory")
    @Pattern(regexp = "(male|female)")
    private String patientgender;

    @NotNull(message = "age is mandatory")
    private Integer patientage;

    @NotEmpty(message = "Tell us about your HealthStatus ")
    @Column(columnDefinition = "TEXT",nullable = false)
    private String patienthealthstatus;

    @NotEmpty(message = "Phone Number mandatory")
    //@Pattern(regexp = "(?:\\+?0*?966)?0?(5[0-9]{8})",message = "Put valid PhoneNumber")
    private String patientPhoneNumber ;

    @NotEmpty(message = "Relative Phone Number mandatory")
  //  @Pattern(regexp = "(?:\\+?0*?966)?0?(5[0-9]{8})",message = "Put valid Relative PhoneNumber")
    private String patientrelativephonenumber ;

    @NotEmpty(message = "Email is mandatory")
    @Email(message = "put valid email")
    private String patientemail;

    @NotEmpty(message = "location is mandatory")
    private String patientlocation;

  @NotEmpty(message = "AmbulanceCenterName is mandatory")
    private String ambulancename ;

   // private String ambulancelocation;
//    @NotEmpty(message = "HospitalOrHealthCenterName is mandatory")
    private String hospitalname ;
  //  private String hospitallocation;

    @NotEmpty(message = "destinationLocation is mandatory")
    private String estination;
}
