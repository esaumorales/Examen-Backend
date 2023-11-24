package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.ConductoresEntity;
import com.example.demo.repository.ConductoresRepository;
import com.example.demo.service.ConductoresService;
@Component
public class ConductoresServiceImpl implements ConductoresService{

	@Autowired
	public ConductoresRepository conductoresRepository;

	@Override
	public ConductoresEntity create(ConductoresEntity c) {
		// TODO Auto-generated method stub
		return conductoresRepository.save(c);
	}

	@Override
	public ConductoresEntity update(ConductoresEntity c) {
		// TODO Auto-generated method stub
		return conductoresRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		conductoresRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public ConductoresEntity read(Long id) {
		// TODO Auto-generated method stub
		return conductoresRepository.findById(id).get();
	}

	@Override
	public List<ConductoresEntity> readAll() {
		// TODO Auto-generated method stub
		return conductoresRepository.findAll();
	}
}
