package com.asml.acms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asml.acms.entity.HelloWorldEntity;

@Repository
public interface HelloWorldRepository extends JpaRepository<HelloWorldEntity, Integer>{
	
	

}
