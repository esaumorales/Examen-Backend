package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.FlotaEntity;
@Service
public interface FlotaService {
	FlotaEntity create (FlotaEntity f);
	FlotaEntity update (FlotaEntity f);
	void delete (Long id);
	FlotaEntity read (Long id);
	List<FlotaEntity> readAll();
}
