package com.npci.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.beans.Profile;
import com.npci.service.LoginService;
import com.npci.service.ProfileService;

@RestController 
@RequestMapping("/")
public class AppController {
	 // controller depends on the service layer hence autowired the login and register  service
	@Autowired
	private LoginService loginService;
	@Autowired
	private ProfileService registrationService;
	//a string of exceptions
	private List<String> exceptionList =new ArrayList<>();
		
//	 creating for to register a profile
    @PostMapping("/new")
    public ResponseEntity<Profile>createNewProfile(@RequestBody Profile pf)
    {
 	   Profile newpf=registrationService.createProfile(pf.getName(),pf.getEmail_id(),pf.getPassword(),
 			   pf.getDob(),pf.getPhone());
 	   return ResponseEntity.status(200).body(newpf);
    }
	
    
	
}
