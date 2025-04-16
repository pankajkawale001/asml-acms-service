package com.asml.acms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asml.acms.dto.HelloWorldDTO;
import com.asml.acms.services.HelloWorldService;

@RestController
@RequestMapping("/helloWorld")
public class HelloWorldController {
	
	@Autowired
	HelloWorldService helloWorldService;
	
	@GetMapping("/fetch")
	public String home(){
        return "Hello World!";
    }
	
	@PostMapping("/addUser")
	public ResponseEntity<HelloWorldDTO> addUser(@RequestBody HelloWorldDTO helloWorldDTO){
		HelloWorldDTO savedDetails = helloWorldService.addDetails(helloWorldDTO);
		return new ResponseEntity<>(savedDetails, HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchUserById/{id}")
	public ResponseEntity<HelloWorldDTO> fetchDetailsById(@PathVariable Integer id ){
		return helloWorldService.fetchDetailsById(id);
	}
	
	@GetMapping("/fetchAllDetails")
	public ResponseEntity<List<HelloWorldDTO>> fetchAllRestaurants() {
		List<HelloWorldDTO> getAllDetails = helloWorldService.findAllDetails();
		return new ResponseEntity<>(getAllDetails, HttpStatus.OK);
	}

}
