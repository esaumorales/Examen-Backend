package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TerminalEntity;
@Component
@Service
public interface TerminalService {
	TerminalEntity create (TerminalEntity t);
	TerminalEntity update (TerminalEntity t);
	void delete (Long id);
	TerminalEntity read (Long id);
	List<TerminalEntity> readAll();
}
