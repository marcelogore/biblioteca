package ar.com.grupoesfera.biblioteca.repo;

import java.util.List;

import ar.com.grupoesfera.biblioteca.modelo.Usuario;
import ar.com.grupoesfera.main.App;

public class BaseDeUsuarios extends Base {

    public BaseDeUsuarios(App app){
        super(app);
    }

    @SuppressWarnings("unchecked")
    public List<Usuario> obtenerTodos() {
        
        return app.obtenerEntityManager().createQuery("select u from Usuario u").getResultList();
    }
}
