package com.npci.adminservice.controller1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.adminservice.service.AdminServiceImpl;

@RestController
@RequestMapping("/api2")
public class AdminController {
   @Autowired 
   private AdminServiceImpl service;
   
   // to get the value associated pass by/ received by config server
   @Value("${message}")
   private String property;
   
   @GetMapping(path="/v1/greetings")
   public String getMessage()
   {
	   return property;
   }
   
   @GetMapping(path="/employee/{id}")
   public ResponseEntity<String>finder(@PathVariable("id") int ids)
   {
	   String result = service.findingEmployee(ids);
	   return ResponseEntity.status(200).body(result);
   }
   
}
