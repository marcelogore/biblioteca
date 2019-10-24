package ar.com.grupoesfera.biblioteca.repo;

import ar.com.grupoesfera.biblioteca.modelo.Prestamo;
import ar.com.grupoesfera.main.App;
import ar.com.grupoesfera.main.Fixture;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseDePrestamosTest {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("biblioteca");
    BaseDePrestamos baseDePrestamos = App.instancia(factory).obtenerRepoPrestamos();

    @Before
    public void init(){
        Fixture.initData();
        Prestamo prestamo = new Prestamo();
    }

    @Test
    public void obtenerPrestamoPorId() {
        Prestamo prestamo = baseDePrestamos.obtenerPrestamoPorId(1L);

        Assert.assertNotNull(prestamo);

        long idPrestamo = prestamo.getId();
        Assert.assertEquals(idPrestamo,1L);

        long idUsuario = prestamo.getIdUsuario();
        Assert.assertEquals(idUsuario,1L);

        long idLibro = prestamo.getIdLibro();
        Assert.assertEquals(idLibro,1L);
    }

}