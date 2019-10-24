package ar.com.grupoesfera.biblioteca;

import ar.com.grupoesfera.biblioteca.modelo.Libro;
import ar.com.grupoesfera.biblioteca.repo.BaseDeLibros;
import ar.com.grupoesfera.biblioteca.repo.BaseDeUsuarios;
import ar.com.grupoesfera.main.App;
import ar.com.grupoesfera.main.Fixture;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LibrosTest {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("biblioteca");
    private BaseDeLibros libros = App.instancia(factory).obtenerRepoLibros();


    @After
    public void eliminarDatos() {
        Fixture.dropData();
    }

    @Before
    public void init(){
        Fixture.initData();
    }

    @Test
    public void debeObtenerUnLibroPorId(){

        Libro libro = libros.obtenerLibroPorId(1L);
        Assert.assertNotNull(libro);

        Assert.assertTrue(libro.getId().equals(1L));
        Assert.assertTrue(libro.getTitulo().equals("Continuous delivery"));
        Assert.assertTrue(libro.getAutor().equals("Jez Humble"));
        Assert.assertTrue(libro.getEditorial().equals("Addison-Wesley"));
    }

    public void autorJezHumbleTieneDosLibros(){
        Assert.assertEquals(2, libros.obtenerLibrosAutor("Jez Humble").size());
    }

    @Test
    public void noDebeDevolverNingunLibroSiAutorDesconocido(){
        Assert.assertEquals(0,libros.obtenerLibrosAutor("Nahuel Pascual").size());
    }

    @Test
    public void debeDevolverLibroCorrrecto(){
        Assert.assertEquals("Design patterns",libros.obtenerLibrosAutor("Erich Gamma").get(0).getTitulo());
    }
}
