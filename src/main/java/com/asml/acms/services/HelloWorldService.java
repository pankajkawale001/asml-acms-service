package com.asml.acms.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.asml.acms.dto.HelloWorldDTO;
import com.asml.acms.entity.HelloWorldEntity;
import com.asml.acms.mapper.HelloWorldMapper;
import com.asml.acms.repositories.HelloWorldRepository;

@Service
public class HelloWorldService {

	@Autowired
	HelloWorldRepository helloWorldRepository;
	
	//url: http://localhost:8090/helloWorld/addUser
	
	/* Request
	 * { "userName": "Pankaj", "userPassword": "Pankaj", "address":
	 * "Airoli, Sector 20", "city": "New Mumbai" }
	 */

	public HelloWorldDTO addDetails(HelloWorldDTO userDTO) {
		HelloWorldEntity savedUser = helloWorldRepository
				.save(HelloWorldMapper.INSTANCE.mapHelloWorldDTOHelloWorldEntity(userDTO));
		return HelloWorldMapper.INSTANCE.mapHelloWorldToHelloWorldDTO(savedUser);
	}

	//Get details url: http://localhost:8090/helloWorld/fetchUserById/1
	public ResponseEntity<HelloWorldDTO> fetchDetailsById(Integer id) {
		Optional<HelloWorldEntity> fetchInfo = helloWorldRepository.findById(id);
		if (fetchInfo.isPresent()) {
			return new ResponseEntity<>(HelloWorldMapper.INSTANCE.mapHelloWorldToHelloWorldDTO(fetchInfo.get()),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	public List<HelloWorldDTO> findAllDetails() {
		List<HelloWorldEntity> helloWorld = helloWorldRepository.findAll();
		List<HelloWorldDTO> helloWorldDTOList = helloWorld.stream()
				.map(helloWorldDetails -> HelloWorldMapper.INSTANCE.mapHelloWorldToHelloWorldDTO(helloWorldDetails))
				.collect(Collectors.toList());
		return helloWorldDTOList;
	}
}
