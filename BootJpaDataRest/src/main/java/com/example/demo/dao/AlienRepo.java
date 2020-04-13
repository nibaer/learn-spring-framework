package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Alien;


//test with http://localhost:8080/aliens. You don't need a controller
@RepositoryRestResource(collectionResourceRel="aliens", path="aliens")
public interface AlienRepo extends JpaRepository<Alien, Integer> {

}
