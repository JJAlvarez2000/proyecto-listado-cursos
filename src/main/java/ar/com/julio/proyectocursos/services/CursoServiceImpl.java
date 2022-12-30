package ar.com.julio.proyectocursos.services;

import ar.com.julio.proyectocursos.exceptions.ServiceJDBCException;
import ar.com.julio.proyectocursos.models.Curso;
import ar.com.julio.proyectocursos.repositories.CursoDAORepositoryImpl;
import ar.com.julio.proyectocursos.repositories.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CursoServiceImpl implements  CursoService {
    private Repository<Curso> repository;
    public CursoServiceImpl(Connection conn) {
        this.repository = new CursoDAORepositoryImpl(conn);
    }
    @Override
    public List<Curso> listar() {
        try {
            return repository.listar();
        } catch (SQLException e) {
            throw new ServiceJDBCException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Curso> porNombre(String nombre) {
        try {
            return repository.porNombre(nombre);
        } catch (SQLException e) {
            throw new ServiceJDBCException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Curso> porId(Long id) {
        try {
            return Optional.ofNullable(repository.porId(id));
        } catch (SQLException e) {
            throw new ServiceJDBCException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Curso curso) {
        try {
            repository.guardar(curso);
        } catch (SQLException e) {
            throw new ServiceJDBCException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            repository.eliminar(id);
        } catch (SQLException e) {
            throw new ServiceJDBCException(e.getMessage(), e.getCause());
        }
    }
}
