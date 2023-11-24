package com.example.demo.controller;

import static com.example.demo.commons.GlobalConstants.API_TERMINAL;

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

import com.example.demo.entity.TerminalEntity;
import com.example.demo.service.TerminalService;
@RestController
@RequestMapping(API_TERMINAL)
public class TerminalController {
	
	@Autowired
	private TerminalService terminalService;

	@GetMapping("/listar")
	public List<TerminalEntity> listar() {
		return terminalService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<TerminalEntity> listar2(@PathVariable("id") long id) {
		TerminalEntity t = terminalService.read(id);
		if (t!=null) {
			return new ResponseEntity<>(t, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/agregar")
	  public ResponseEntity<TerminalEntity> createTutorial(@Valid @RequestBody TerminalEntity term) {
	    try {
	    	TerminalEntity t = terminalService.create(term);

	      return new ResponseEntity<>(t, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/editar/{id}")
	  public ResponseEntity<TerminalEntity> updateTutorial(@PathVariable("id") long id,@Valid @RequestBody TerminalEntity t) {
		TerminalEntity terminales = terminalService.read(id);

	    if (terminales!=null) {
	    	terminales.setId(t.getId());
	    	terminales.setTe_DireTerm(t.getTe_DireTerm()	);
	    	terminales.setTe_NombTerm(t.getTe_NombTerm());


	    	return new ResponseEntity<>(terminalService.create(terminales), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteRoles(@PathVariable("id") long id) {
	    try {
	    	terminalService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}