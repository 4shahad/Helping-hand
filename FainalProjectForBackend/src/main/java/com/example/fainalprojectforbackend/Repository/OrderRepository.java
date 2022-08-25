package com.example.fainalprojectforbackend.Repository;

import com.example.fainalprojectforbackend.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {
 List<Orders>  findAllByPatientid(Integer id);
 List<Orders> findAllByHospitalname(String hospitalName);
 List<Orders> findAllByAmbulancename(String ambulanceName);

 Orders findOrdersById(Integer id);



}
