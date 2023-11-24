package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.BusesEntity;
import com.example.demo.repository.BusesRepository;
import com.example.demo.service.BusesService;
@Component
public class BusesServiceImpl implements BusesService{

	@Autowired
	public BusesRepository busesRepository;

	@Override
	public BusesEntity create(BusesEntity b) {
		// TODO Auto-generated method stub
		return busesRepository.save(b);
	}

	@Override
	public BusesEntity update(BusesEntity b) {
		// TODO Auto-generated method stub
		return busesRepository.save(b);
	}

	@Override
	public void delete(Long id) {
		busesRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public BusesEntity read(Long id) {
		// TODO Auto-generated method stub
		return busesRepository.findById(id).get();
	}

	@Override
	public List<BusesEntity> readAll() {
		// TODO Auto-generated method stub
		return busesRepository.findAll();
	}
}
