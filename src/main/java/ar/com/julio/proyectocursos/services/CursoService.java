package ar.com.julio.proyectocursos.services;

import ar.com.julio.proyectocursos.models.Curso;

import java.util.List;

public interface CursoService {
    List<Curso> listar();
    List<Curso> porNombre(String nombre);
}
