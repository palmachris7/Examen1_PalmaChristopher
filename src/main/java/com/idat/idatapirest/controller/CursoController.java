package com.idat.idatapirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.idatapirest.dto.CursoRequestDTO;
import com.idat.idatapirest.model.Curso;
import com.idat.idatapirest.service.CursoService;

@RestController
@RequestMapping("/curso/v1")
public class CursoController {

	@Autowired
	private CursoService service;

	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public ResponseEntity<List<Curso>>listar(){

		return new ResponseEntity<List<Curso>>(service.listarCurso(),HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody CursoRequestDTO curso){
		service.guardarCurso(curso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}


	@RequestMapping(method = RequestMethod.GET, path = "/listar/{id}")
	public @ResponseBody ResponseEntity<Curso> cursoById(@PathVariable Integer id){
		Curso curso = service.cursoById(id);
		if(curso != null) {
			return new ResponseEntity<Curso>(curso, HttpStatus.OK);

		}
		return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);

	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Curso curso = service.cursoById(id);
		if(curso != null) {
			service.eliminarCurso(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}

	@RequestMapping(method = RequestMethod.PUT, path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody Curso curso){
		Curso p = service.cursoById(curso.getIdCurso());
		if(p != null) {
			service.editarCurso(curso);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}


}