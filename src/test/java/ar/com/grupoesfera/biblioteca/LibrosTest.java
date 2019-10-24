package ar.com.grupoesfera.biblioteca;

import ar.com.grupoesfera.biblioteca.repo.BaseDeLibros;
import ar.com.grupoesfera.biblioteca.repo.BaseDeUsuarios;
import ar.com.grupoesfera.main.App;
import ar.com.grupoesfera.main.Fixture;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LibrosTest {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("biblioteca");
    private BaseDeLibros libros = App.instancia(factory).obtenerRepoLibros();

    @Before
    public void agregarDatos() {
        Fixture.initData();
    }

    @After
    public void eliminarDatos() {
        Fixture.dropData();
    }

    @Before
    public void init(){
        Fixture.initData();
    }


}
