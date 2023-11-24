package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ConductoresEntity;
@Service
public interface ConductoresService {
	ConductoresEntity create (ConductoresEntity c);
	ConductoresEntity update (ConductoresEntity c);
	void delete (Long id);
	ConductoresEntity read (Long id);
	List<ConductoresEntity> readAll();
}
