package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.ViajesEntity;
import com.example.demo.repository.ViajesRepository;
import com.example.demo.service.ViajesService;
@Component
public class ViajesServiceImpl implements ViajesService{

	@Autowired
	public ViajesRepository viajesRepository;

	@Override
	public ViajesEntity create(ViajesEntity v) {
		// TODO Auto-generated method stub
		return viajesRepository.save(v);
	}

	@Override
	public ViajesEntity update(ViajesEntity v) {
		// TODO Auto-generated method stub
		return viajesRepository.save(v);
	}

	@Override
	public void delete(Long id) {
		viajesRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public ViajesEntity read(Long id) {
		// TODO Auto-generated method stub
		return viajesRepository.findById(id).get();
	}

	@Override
	public List<ViajesEntity> readAll() {
		// TODO Auto-generated method stub
		return viajesRepository.findAll();
	}
}
