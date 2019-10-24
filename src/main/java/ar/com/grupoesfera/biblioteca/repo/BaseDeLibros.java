package ar.com.grupoesfera.biblioteca.repo;

import java.util.List;

import ar.com.grupoesfera.biblioteca.modelo.Libro;
import ar.com.grupoesfera.main.App;

public class BaseDeLibros extends Base {

    public BaseDeLibros (App app){
        super(app);
    }


    @SuppressWarnings("unchecked")
    public List<Libro> obtenerTodos() {
        
        return app.obtenerEntityManager().createQuery("select l from Libro l").getResultList();
    }
}
