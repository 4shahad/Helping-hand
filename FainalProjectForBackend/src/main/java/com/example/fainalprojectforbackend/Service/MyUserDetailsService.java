package com.example.fainalprojectforbackend.Service;


import com.example.fainalprojectforbackend.Model.MyUsers;

import com.example.fainalprojectforbackend.Repository.MyUserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
 private final MyUserRepository myUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            MyUsers user=myUserRepository.findMyUsersByUserName(username);

            if(user==null){
                throw new UsernameNotFoundException("Invalid username or password");
            }

            return user;
        }
    }

