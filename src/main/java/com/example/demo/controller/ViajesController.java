package com.example.demo.controller;

import static com.example.demo.commons.GlobalConstants.API_VIAJES;

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

import com.example.demo.entity.ViajesEntity;
import com.example.demo.service.ViajesService;
@RestController
@RequestMapping(API_VIAJES)
public class ViajesController {
	
	@Autowired
	private ViajesService viajesService;

	@GetMapping("/listar")
	public List<ViajesEntity> listar() {
		return viajesService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ViajesEntity> listar2(@PathVariable("id") long id) {
		ViajesEntity v = viajesService.read(id);
		if (v!=null) {
			return new ResponseEntity<>(v, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/agregar")
	  public ResponseEntity<ViajesEntity> createTutorial(@Valid @RequestBody ViajesEntity via) {
	    try {
	    	ViajesEntity v = viajesService.create(via);

	      return new ResponseEntity<>(v, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/editar/{id}")
	  public ResponseEntity<ViajesEntity> updateTutorial(@PathVariable("id") long id,@Valid @RequestBody ViajesEntity v) {
		ViajesEntity viajes = viajesService.read(id);

	    if (viajes!=null) {
	    	viajes.setId(v.getId());



	    	return new ResponseEntity<>(viajesService.create(viajes), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteRoles(@PathVariable("id") long id) {
	    try {
	    	viajesService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}