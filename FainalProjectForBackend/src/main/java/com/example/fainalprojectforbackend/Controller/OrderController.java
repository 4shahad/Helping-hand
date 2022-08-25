package com.example.fainalprojectforbackend.Controller;

import com.example.fainalprojectforbackend.Model.AmbulanceCenter;
import com.example.fainalprojectforbackend.Model.Hospital;
import com.example.fainalprojectforbackend.Model.Orders;
import com.example.fainalprojectforbackend.Model.Patients;
import com.example.fainalprojectforbackend.Service.OrderService;
import com.example.fainalprojectforbackend.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;
    @PostMapping ("/add")
    public ResponseEntity addOrder(@RequestBody @Valid Orders orders){
        orderService.orderAdd(orders);
        return ResponseEntity.status(200).body(new ApiResponse("order added ",200));
    }
    @GetMapping("/git")
    public ResponseEntity getOrders(@RequestParam @Valid Integer patientId){
        return ResponseEntity.status(200).body(orderService.getOrders(patientId));
    }
    //_____________________________________________
    @GetMapping("/git/hospital")
    public ResponseEntity getHospitalOrder(@RequestParam @Valid String hospitalName){
        return ResponseEntity.status(200).body(orderService.getOrdersHospital(hospitalName));
    }
//_______________________________________
    @GetMapping("/git/ambulance")
    public ResponseEntity getAmbulanceOrder(@RequestParam String ambulanceName){
        return ResponseEntity.status(200).body(orderService.getOrdersAmbulance(ambulanceName));
    }
    //____________________________________________________________
    @DeleteMapping("/delete")
    public ResponseEntity deleteOrder(@RequestParam @Valid Integer patientId,@RequestParam @Valid Integer ordersId){
        orderService.deleteOrder(ordersId,patientId);
        return ResponseEntity.status(200).body(new ApiResponse("your order deleted",200));
    }
    //*****************************************************
    @PutMapping ("/destination/location")
    public ResponseEntity updateDestination(@RequestParam @Valid Integer patientId ,@RequestParam @Valid Integer ordersId, @RequestParam @Valid String destination){
        orderService.updateOrderDestinationLocation(ordersId,destination,patientId);
        return ResponseEntity.status(200).body(new ApiResponse("destination for order updated",200));
    }
    @PutMapping("/update/patient/location")
    public ResponseEntity updatePatientLocation(@RequestParam @Valid Integer patientId, @RequestParam @Valid Integer ordersId,@RequestParam @Valid String patientLocation){
        orderService.updateOrderPatientLocation(ordersId,patientLocation,patientId);
        return ResponseEntity.status(200).body(new ApiResponse("patient location updated",200));
    }
//****************************************************************************
    @PutMapping("/update/health/status")
    public ResponseEntity updateHealthStatus(@RequestParam @Valid Integer patientId,@RequestParam @Valid Integer ordersId,@RequestParam @Valid String healthStatus){
        orderService.updateOrderHealthStatus(ordersId,healthStatus,patientId);
        return ResponseEntity.status(200).body(new ApiResponse("patient health status  updated",200));
    }

    @PutMapping("/update/order/type")
    public ResponseEntity updateOrderType(@RequestParam @Valid Integer patientId,@RequestParam @Valid Integer ordersId, @RequestParam @Valid String orderType){
        orderService.updateOrderType(ordersId,orderType,patientId);
        return ResponseEntity.status(200).body(new ApiResponse("order type updated",200));
    }
    @PutMapping("/update/ambulance/info")
    public ResponseEntity updateAmbulanceInfo(@RequestParam @Valid Integer patientId,@RequestParam @Valid Integer ordersId, @RequestParam @Valid String ambulanceName){
        orderService.updateOrderAmbulanceInfo(ordersId,ambulanceName,patientId);
        return ResponseEntity.status(200).body(new ApiResponse("order ambulance information updated",200));
    }

    @PutMapping("/update/hospital/info")
    public ResponseEntity updateHospitalInfo(@RequestParam @Valid Integer patientId,@RequestParam @Valid Integer ordersId, @RequestParam @Valid String hospitalName){
        orderService.updateOrderHospitalInfo(ordersId,hospitalName,patientId);
        return ResponseEntity.status(200).body(new ApiResponse("order hospital information  updated",200));
    }

    @PutMapping("/update/accept/status/ambulance")
    public ResponseEntity updateAcceptStatusAmbulance(@RequestParam @Valid Integer orderId,@RequestParam @Valid boolean acceptStatus,@RequestParam @Valid String ambulanceName){
        orderService.updateAcceptStatusAmbulance(orderId,acceptStatus,ambulanceName);
    return ResponseEntity.status(200).body(new ApiResponse("accept status by ambulance "+acceptStatus,200));
    }

    @PutMapping("/update/accept/status/hospital")
    public ResponseEntity updateAcceptStatusHospital(@RequestParam @Valid Integer orderId,@RequestParam @Valid boolean acceptStatus,@RequestParam @Valid String hospitalName){
        orderService.updateAcceptStatusHospital(orderId,acceptStatus,hospitalName);
        return ResponseEntity.status(200).body(new ApiResponse("accept status by hospital "+acceptStatus,200));
    }
}
