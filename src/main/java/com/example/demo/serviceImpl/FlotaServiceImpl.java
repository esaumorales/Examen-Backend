package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.FlotaEntity;
import com.example.demo.repository.FlotaRepository;
import com.example.demo.service.FlotaService;
@Component
public class FlotaServiceImpl implements FlotaService {

	@Autowired
	private FlotaRepository flotaRepository;

	@Override
	public FlotaEntity create(FlotaEntity f) {
		// TODO Auto-generated method stub
		return flotaRepository.save(f);
	}

	@Override
	public FlotaEntity update(FlotaEntity f) {
		// TODO Auto-generated method stub
		return flotaRepository.save(f);
	}

	@Override
	public void delete(Long id) {
		flotaRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public FlotaEntity read(Long id) {
		// TODO Auto-generated method stub
		return flotaRepository.findById(id).get();
	}

	@Override
	public List<FlotaEntity> readAll() {
		// TODO Auto-generated method stub
		return flotaRepository.findAll();
	};
}
