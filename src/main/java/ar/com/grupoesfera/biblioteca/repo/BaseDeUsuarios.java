package ar.com.grupoesfera.biblioteca.repo;

import java.sql.PreparedStatement;
import java.util.List;

import ar.com.grupoesfera.biblioteca.modelo.Usuario;
import ar.com.grupoesfera.main.App;

import javax.persistence.NoResultException;

public class BaseDeUsuarios {

    @SuppressWarnings("unchecked")
    public List<Usuario> obtenerTodos() {
        
        return App.instancia().obtenerEntityManager().createQuery("select u from Usuario u").getResultList();
    }

    public Usuario obtenerUsuarioDNI(Long dni) throws NoResultException {
        return (Usuario) App.instancia().obtenerEntityManager().createQuery("SELECT u from Usuario u where u.dni = " + dni).getSingleResult();
    }

    public Usuario obtenerUsuarioId(Long id) throws NoResultException {
        return (Usuario) App.instancia().obtenerEntityManager().createQuery("SELECT u from Usuario u where u.id = " + id    ).getSingleResult();
    }
}
