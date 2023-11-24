package com.example.demo.controller;

import static com.example.demo.commons.GlobalConstants.API_RUTAS;

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

import com.example.demo.entity.RutasEntity;
import com.example.demo.service.RutasService;
@RestController
@RequestMapping(API_RUTAS)
public class RutasController {
	
	@Autowired
	private RutasService rutasService;

	@GetMapping("/listar")
	public List<RutasEntity> listar() {
		return rutasService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<RutasEntity> listar2(@PathVariable("id") long id) {
		RutasEntity r = rutasService.read(id);
		if (r!=null) {
			return new ResponseEntity<>(r, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/agregar")
	  public ResponseEntity<RutasEntity> createTutorial(@Valid @RequestBody RutasEntity rut) {
	    try {
	    	RutasEntity r = rutasService.create(rut);

	      return new ResponseEntity<>(r, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/editar/{id}")
	  public ResponseEntity<RutasEntity> updateTutorial(@PathVariable("id") long id,@Valid @RequestBody RutasEntity r) {
		RutasEntity ruta = rutasService.read(id);

	    if (ruta!=null) {
	    	ruta.setId(r.getId());
	    	ruta.setRu_NombRuta(r.getRu_NombRuta());
	    	ruta.setRu_ValoPasj(r.getRu_ValoPasj());


	    	return new ResponseEntity<>(rutasService.create(ruta), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteRoles(@PathVariable("id") long id) {
	    try {
	    	rutasService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}