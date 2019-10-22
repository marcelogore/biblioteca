package ar.com.grupoesfera.main;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Application;

import ar.com.grupoesfera.biblioteca.repo.BaseDeLibros;
import ar.com.grupoesfera.biblioteca.repo.BaseDePrestamos;
import ar.com.grupoesfera.biblioteca.repo.BaseDeUsuarios;
import ar.com.grupoesfera.biblioteca.rest.API;

public class App extends Application {

	private static final App instancia = new App();
	private static EntityManagerFactory proveedorPersistencia = Persistence.createEntityManagerFactory("biblioteca");

	private BaseDeUsuarios usuarios = new BaseDeUsuarios();
	private BaseDeLibros libros = new BaseDeLibros();
	private BaseDePrestamos prestamos = new BaseDePrestamos();

	private App() {

	}

	public static App instancia() {

		return instancia;
	}

	@Override
	public Set<Class<?>> getClasses() {

		Set<Class<?>> classes = new HashSet<>();
		classes.add(API.class);
		return classes;
	}

	public EntityManager obtenerEntityManager() {

		return proveedorPersistencia.createEntityManager();
	}

	public BaseDeUsuarios obtenerRepoUsuarios() {

		return usuarios;
	}

	public BaseDeLibros obtenerRepoLibros() {

		return libros;
	}

	public BaseDePrestamos obtenerRepoPrestamos() {

		return prestamos;
	}
}
