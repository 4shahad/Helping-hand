package com.example.fainalprojectforbackend.Repository;

import com.example.fainalprojectforbackend.Model.MyUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<MyUsers,Integer> {
MyUsers findMyUsersByUserName(String username);
}
