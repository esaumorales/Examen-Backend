package com.example.demo.controller;

import static com.example.demo.commons.GlobalConstants.API_BUSES;

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

import com.example.demo.entity.BusesEntity;
import com.example.demo.service.BusesService;
@RestController
@RequestMapping(API_BUSES)
public class BusesController {
	
	@Autowired
	private BusesService busesService;

	@GetMapping("/listar")
	public List<BusesEntity> listar() {
		return busesService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<BusesEntity> listar2(@PathVariable("id") long id) {
		BusesEntity b = busesService.read(id);
		if (b!=null) {
			return new ResponseEntity<>(b, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/agregar")
	  public ResponseEntity<BusesEntity> createTutorial(@Valid @RequestBody BusesEntity bus) {
	    try {
	    	BusesEntity b = busesService.create(bus);

	      return new ResponseEntity<>(b, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/editar/{id}")
	  public ResponseEntity<BusesEntity> updateTutorial(@PathVariable("id") long id,@Valid @RequestBody BusesEntity b) {
		BusesEntity busess = busesService.read(id);

	    if (busess!=null) {
	    	busess.setId(b.getId());
	    	busess.setBu_CodiFlot(b.getBu_CodiFlot());
	    	busess.setBu_Capacidad(b.getBu_Capacidad());
	    	busess.setBu_FechFabri(b.getBu_FechFabri());
	    	busess.setBu_Tipo(b.getBu_Tipo());


	    	return new ResponseEntity<>(busesService.create(busess), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteRoles(@PathVariable("id") long id) {
	    try {
	    	busesService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}