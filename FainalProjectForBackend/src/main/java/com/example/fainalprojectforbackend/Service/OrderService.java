package com.example.fainalprojectforbackend.Service;

import com.example.fainalprojectforbackend.Exception.ApiException;
import com.example.fainalprojectforbackend.Model.AmbulanceCenter;
import com.example.fainalprojectforbackend.Model.Hospital;
import com.example.fainalprojectforbackend.Model.Orders;
import com.example.fainalprojectforbackend.Model.Patients;
import com.example.fainalprojectforbackend.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void orderAdd(Orders orders) {
        orderRepository.save(orders);
    }

    public List<Orders> getOrders(Integer patientId) {
        return orderRepository.findAllByPatientid(patientId);
    }

    public List<Orders> getOrdersHospital(String hospitalName) {
        return orderRepository.findAllByHospitalname(hospitalName);
    }

    public List<Orders> getOrdersAmbulance(String ambulanceName) {
        return orderRepository.findAllByAmbulancename(ambulanceName);
    }

    public void deleteOrder(Integer IdOrder, Integer patientId) {
        Orders deleteOrder = orderRepository.findOrdersById(IdOrder);
        if (deleteOrder.getPatientid().equals(patientId)) {
            orderRepository.deleteById(IdOrder);
        } else {
            throw new ApiException("you do not have this order");
        }

    }

    //------------------------------------------------------------------------------

    public void updateOrderDestinationLocation(Integer ordersId, String destination, Integer patientId) {
        Orders newOrder = orderRepository.findOrdersById(ordersId);
        if (newOrder.getPatientid().equals(patientId)) {
            newOrder.setEstination(destination);
            System.out.println(newOrder.getEstination());
        } else {
            throw new ApiException("you do not have this order");
        }
    }

    public void updateOrderPatientLocation(Integer ordersId, String patientLocation, Integer patientId) {
        Orders newOrder = orderRepository.findOrdersById(ordersId);
        if (newOrder.getPatientid().equals(patientId)) {
            newOrder.setPatientlocation(patientLocation);
        } else {
            throw new ApiException("you do not have this order");
        }
    }

    public String updateOrderHealthStatus(Integer orderId, String healthStatus,Integer patientId) {
        Orders newOrder = orderRepository.findOrdersById(orderId);
        if (newOrder.getPatientid().equals(patientId)) {
            newOrder.setPatienthealthstatus(healthStatus);
            return "health status  updated";
        } else {
            throw new ApiException("you do not have this order");
        }
    }

    public void updateOrderType(Integer orderId, String orderType, Integer patientId) {
        Orders newOrder = orderRepository.findOrdersById(orderId);
        if (newOrder.getPatientid().equals(patientId)) {
            newOrder.setOrdert(orderType);
        } else {
            throw new ApiException("you do not have this order");
        }
    }

    public void updateOrderAmbulanceInfo(Integer orderId, String ambulanceName, Integer patientId) {
        Orders newOrder = orderRepository.findOrdersById(orderId);
        if (newOrder.getPatientid().equals(patientId)) {
            newOrder.setAmbulancename(ambulanceName);

        } else {
            throw new ApiException("you do not have this order");
        }
    }

    public void updateOrderHospitalInfo(Integer orderId,  String hospitalName, Integer patientId) {
        Orders newOrder = orderRepository.findOrdersById(orderId);
        if (newOrder.getPatientid().equals(patientId)) {

            newOrder.setHospitalname(hospitalName);
        } else {
            throw new ApiException("you do not have this order");
        }
    }

    public void updateAcceptStatusAmbulance(Integer orderId, boolean acceptStatus, String ambulanceName) {
        Orders newOrder = orderRepository.findOrdersById(orderId);
        if (newOrder.getAmbulancename().equals(ambulanceName)) {
            newOrder.setOrderacceptambulance(acceptStatus);
        } else {
            throw new ApiException("you do not have this order");
        }

    }

    public void updateAcceptStatusHospital(Integer orderId, boolean acceptStatus, String hospitalName) {
        Orders newOrder = orderRepository.findOrdersById(orderId);
        if (newOrder.getHospitalname().equals(hospitalName)) {
            newOrder.setOrderaccepthospital(acceptStatus);
        } else {
            throw new ApiException("you do not have this order");
        }

    }
}