package ar.com.grupoesfera.biblioteca;

import ar.com.grupoesfera.biblioteca.repo.BaseDeLibros;
import ar.com.grupoesfera.main.App;
import ar.com.grupoesfera.main.Fixture;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LibrosTest {

    BaseDeLibros libros = App.instancia().obtenerRepoLibros();

    @Before
    public void init(){
        Fixture.initData();
    }

    @Test
    public void autorJezHumbleTieneDosLibros(){
        Assert.assertEquals(2, libros.obtenerLibrosAutor("Jez Humble").size());
    }

}
