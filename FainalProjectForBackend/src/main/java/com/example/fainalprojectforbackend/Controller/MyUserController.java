package com.example.fainalprojectforbackend.Controller;

import com.example.fainalprojectforbackend.Model.MyUsers;
import com.example.fainalprojectforbackend.Repository.MyUserRepository;
import com.example.fainalprojectforbackend.Service.MyUserDetailsService;
import com.example.fainalprojectforbackend.Service.MyUserService;
import com.example.fainalprojectforbackend.dto.ApiResponse;
import com.example.fainalprojectforbackend.dto.RegisterForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth/user")
@RequiredArgsConstructor
public class MyUserController {
    private final MyUserService myUserService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterForm registerForm){
        myUserService.Register(registerForm);
        return ResponseEntity.status(201).body(new ApiResponse("New user added !",201));
    }

    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(200).body(new ApiResponse("Welcome back !",200));
    }

    @PutMapping("/update/password")
    public ResponseEntity updatePassword(@RequestParam @Valid String password ,@RequestParam @Valid String username){
        myUserService.updatePassword(username,password);
        return ResponseEntity.status(200).body(new ApiResponse("password updated",200));
    }
}
