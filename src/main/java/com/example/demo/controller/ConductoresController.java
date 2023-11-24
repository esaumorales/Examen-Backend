package com.example.demo.controller;

import static com.example.demo.commons.GlobalConstants.API_CONDUCTORES;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ConductoresEntity;
import com.example.demo.service.ConductoresService;
@RestController
@RequestMapping(API_CONDUCTORES)
public class ConductoresController {
	
	@Autowired
	private ConductoresService conductoresService;

	@GetMapping("/listar")
	public List<ConductoresEntity> listar() {
		return conductoresService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ConductoresEntity> listar2(@PathVariable("id") long id) {
		ConductoresEntity c = conductoresService.read(id);
		if (c!=null) {
			return new ResponseEntity<>(c, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/agregar")
	  public ResponseEntity<ConductoresEntity> createTutorial(@Valid @RequestBody ConductoresEntity cond) {
	    try {
	    	ConductoresEntity c = conductoresService.create(cond);

	      return new ResponseEntity<>(c, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/editar/{id}")
	  public ResponseEntity<ConductoresEntity> updateTutorial(@PathVariable("id") long id,@Valid @RequestBody ConductoresEntity c) {
		ConductoresEntity conductor = conductoresService.read(id);

	    if (conductor!=null) {
	    	conductor.setId(c.getId());
	    	conductor.setCo_NombConduc(c.getCo_NombConduc());
	    	conductor.setCo_DireConduc(c.getCo_DireConduc());
	    	conductor.setCo_fechNaci(c.getCo_fechNaci());


	    	return new ResponseEntity<>(conductoresService.create(conductor), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteRoles(@PathVariable("id") long id) {
	    try {
	    	conductoresService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}