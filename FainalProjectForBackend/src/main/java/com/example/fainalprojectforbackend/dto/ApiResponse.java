package com.example.fainalprojectforbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse {
    private String Message;
    private Integer Status;
}
