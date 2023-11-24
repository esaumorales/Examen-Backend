package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BusesEntity;

public interface BusesRepository extends JpaRepository<BusesEntity, Long>{

}
