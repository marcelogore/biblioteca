package ar.com.grupoesfera.biblioteca.repo;

import java.util.List;

import ar.com.grupoesfera.biblioteca.modelo.Prestamo;
import ar.com.grupoesfera.main.App;

public class BaseDePrestamos extends Base {

    public BaseDePrestamos (App app){
        super(app);
    }

    @SuppressWarnings("unchecked")
    public List<Prestamo> obtenerTodos() {
        
        return app.obtenerEntityManager().createQuery("select p from Prestamo p").getResultList();
    }

    public Prestamo obtenerPrestamoPorId(Long id){

        List<Prestamo> prestamos = obtenerTodos();
        return prestamos.stream().filter( a -> a.getId().equals(id)).findAny().orElse(null);

    }

}
