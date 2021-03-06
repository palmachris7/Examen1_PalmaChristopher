package com.idat.idatapirest.service;

import java.util.List;

import com.idat.idatapirest.dto.CursoRequestDTO;
import com.idat.idatapirest.model.Curso;

public interface CursoService {

	public void guardarCurso(CursoRequestDTO c);
	public void eliminarCurso(Integer id);
	public void editarCurso(Curso c);
	public List<Curso> listarCurso();
	public Curso cursoById(Integer id);

}