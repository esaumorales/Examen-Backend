package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.TerminalEntity;
import com.example.demo.repository.TerminalRepository;
import com.example.demo.service.TerminalService;
@Component
public class TerminalServiceImpl implements TerminalService{

	@Autowired
	public TerminalRepository terminalRepository;

	@Override
	public TerminalEntity create(TerminalEntity t) {
		// TODO Auto-generated method stub
		return terminalRepository.save(t);
	}
	

	@Override
	public TerminalEntity update(TerminalEntity t) {
		// TODO Auto-generated method stub
		return terminalRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		terminalRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public TerminalEntity read(Long id) {
		// TODO Auto-generated method stub
		return terminalRepository.findById(id).get();
	}

	@Override
	public List<TerminalEntity> readAll() {
		// TODO Auto-generated method stub
		return terminalRepository.findAll();
	}
}
