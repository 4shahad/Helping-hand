package com.example.fainalprojectforbackend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class AmbulanceCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private Integer userId;
    @NotEmpty(message = "Name is mandatory")
    @Column(unique = true)
    private String name ;
    @NotEmpty(message = "Type is mandatory")
   // @Pattern(regexp = "( true | false )")
    private String status;
    @NotEmpty(message = "location is mandatory")
    private String location;
    @NotEmpty(message = "Phone Number mandatory")
    // @Pattern(regexp = "/^(009665|9665|\\+9665|05|5)(5|0|3|6|4|9|1|8|7)([0-9]{7})$/",message = "Put valid PhoneNumber")
    private String phoneNumber ;

}
