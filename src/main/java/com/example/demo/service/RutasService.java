package com.example.demo.service;
import com.example.demo.entity.RutasEntity;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface RutasService {
	RutasEntity create (RutasEntity r);
	RutasEntity update (RutasEntity r);
	void delete (Long id);
	RutasEntity read (Long id);
	List<RutasEntity> readAll();
}
