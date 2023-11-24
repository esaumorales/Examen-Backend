package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ViajesEntity;
@Service
public interface ViajesService {
	ViajesEntity create (ViajesEntity v);
	ViajesEntity update (ViajesEntity v);
	void delete (Long id);
	ViajesEntity read (Long id);
	List<ViajesEntity> readAll();
}
