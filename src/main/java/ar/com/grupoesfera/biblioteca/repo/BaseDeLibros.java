package ar.com.grupoesfera.biblioteca.repo;

import java.util.List;

import ar.com.grupoesfera.biblioteca.modelo.Libro;
import ar.com.grupoesfera.main.App;

import javax.persistence.Query;

public class BaseDeLibros extends Base {

    public BaseDeLibros (App app){
        super(app);
    }


    @SuppressWarnings("unchecked")
    public List<Libro> obtenerTodos() {
        
        return app.obtenerEntityManager().createQuery("select l from Libro l").getResultList();
    }

    @SuppressWarnings("unchecked")
    public Libro obtenerTituloLibro(String tituloLibro) {

        Query query =  app.obtenerEntityManager().createQuery("select l from Libro l where l.titulo = :tituloLibro")
                .setParameter("tituloLibro", tituloLibro);

        List<Libro> listaLibros = query.getResultList();

        return listaLibros.get(0);
    }
}
