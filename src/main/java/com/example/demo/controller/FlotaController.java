package com.example.demo.controller;

import static com.example.demo.commons.GlobalConstants.API_FLOTA;

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

import com.example.demo.entity.FlotaEntity;
import com.example.demo.service.FlotaService;
@RestController
@RequestMapping(API_FLOTA)
public class FlotaController {
	
	@Autowired
	private FlotaService flotaService;

	@GetMapping("/listar")
	public List<FlotaEntity> listar() {
		return flotaService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<FlotaEntity> listar2(@PathVariable("id") long id) {
		FlotaEntity f = flotaService.read(id);
		if (f!=null) {
			return new ResponseEntity<>(f, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/agregar")
	  public ResponseEntity<FlotaEntity> createTutorial(@Valid @RequestBody FlotaEntity flot) {
	    try {
	    	FlotaEntity f = flotaService.create(flot);

	      return new ResponseEntity<>(f, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/editar/{id}")
	  public ResponseEntity<FlotaEntity> updateTutorial(@PathVariable("id") long id,@Valid @RequestBody FlotaEntity f) {
		FlotaEntity flota = flotaService.read(id);

	    if (flota!=null) {
	    	flota.setId(f.getId());
	    	flota.setFl_nombflot(f.getFl_nombflot());
	    	flota.setFl_CodiTerm(f.getFl_CodiTerm());


	    	return new ResponseEntity<>(flotaService.create(flota), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteRoles(@PathVariable("id") long id) {
	    try {
	    	flotaService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}