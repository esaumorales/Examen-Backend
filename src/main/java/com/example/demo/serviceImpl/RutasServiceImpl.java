package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RutasEntity;
import com.example.demo.repository.RutasRepository;
import com.example.demo.service.RutasService;
@Component
@Service
public class RutasServiceImpl implements RutasService{
	
	@Autowired
	public RutasRepository rutasRepository;

	@Override
	public RutasEntity create(RutasEntity r) {
		// TODO Auto-generated method stub
		return rutasRepository.save(r);
	}

	@Override
	public RutasEntity update(RutasEntity r) {
		// TODO Auto-generated method stub
		return rutasRepository.save(r);
	}

	@Override
	public void delete(Long id) {
		rutasRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public RutasEntity read(Long id) {
		// TODO Auto-generated method stub
		return rutasRepository.findById(id).get();
	}

	@Override
	public List<RutasEntity> readAll() {
		// TODO Auto-generated method stub
		return rutasRepository.findAll();
	}

}
