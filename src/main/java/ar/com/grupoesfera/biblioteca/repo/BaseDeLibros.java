package ar.com.grupoesfera.biblioteca.repo;

import java.util.List;

import ar.com.grupoesfera.biblioteca.modelo.Libro;
import ar.com.grupoesfera.main.App;

public class BaseDeLibros extends Base {

    public BaseDeLibros (App app){
        super(app);
    }

    @SuppressWarnings("unchecked")
    public List<Libro> obtenerLibrosAutor (String autor){
        return App.instancia().obtenerEntityManager().createQuery("SELECT l FROM Libro l WHERE l.autor = :autor")
                .setParameter("autor", autor)
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Libro> obtenerTodos() {
        
        return app.obtenerEntityManager().createQuery("select l from Libro l").getResultList();
    }
}
