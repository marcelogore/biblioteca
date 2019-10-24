package ar.com.grupoesfera.biblioteca.repo;

import java.util.LinkedList;
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
    public Libro obtenerLibroPorId(Long id){

        List<Libro> libros = this.obtenerTodos();
        return libros.stream().filter(p -> p.getId().equals(id)).findAny().orElse(null);



    }
}
