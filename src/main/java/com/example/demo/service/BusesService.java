package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.BusesEntity;
@Service
public interface BusesService {
	BusesEntity create (BusesEntity b);
	BusesEntity update (BusesEntity b);
	void delete (Long id);
	BusesEntity read (Long id);
	List<BusesEntity> readAll();
}
