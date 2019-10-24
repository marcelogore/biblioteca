package ar.com.grupoesfera.main;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ar.com.grupoesfera.biblioteca.modelo.Prestamo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ar.com.grupoesfera.biblioteca.modelo.Libro;
import ar.com.grupoesfera.biblioteca.modelo.Usuario;

public class Fixture {

    private static final Log log = LogFactory.getLog(Fixture.class);
    
    public static void initData() {

        EntityManager entities = App.instancia().obtenerEntityManager();
        EntityTransaction transaccion = entities.getTransaction();

        try {

            transaccion.begin();

            crearDatos(entities);

            transaccion.commit();

        } catch (Exception e) {

            log.error("Falló la transacción", e);
            transaccion.rollback();

        } finally {

            entities.close();
        }
    }

    public static void dropData() {

        EntityManager entities = App.instancia().obtenerEntityManager();
        EntityTransaction transaccion = entities.getTransaction();

        try {

            transaccion.begin();

            eliminarDatos(entities);

            transaccion.commit();

        } catch (Exception e) {

            log.error("Falló la transacción", e);
            transaccion.rollback();

        } finally {

            entities.close();
        }
    }

    private static void crearDatos(EntityManager entities) {

        Usuario marcelo = Usuario.nuevo().conId(1L).conNombre("Marcelo").conDNI(1000L);
        Usuario brenda = Usuario.nuevo().conId(2L).conNombre("Brenda").conDNI(2000L);
        Usuario india = Usuario.nuevo().conId(3L).conNombre("India").conDNI(3000L);
        Usuario leon = Usuario.nuevo().conId(4L).conNombre("Leon").conDNI(4000L);
        Usuario sebastian = Usuario.nuevo().conId(5L).conNombre("Sebastian").conDNI(5000L);
        Usuario alejandro = Usuario.nuevo().conId(6L).conNombre("Alejandro").conDNI(6000L);
        Usuario santiago = Usuario.nuevo().conId(7L).conNombre("Santiago").conDNI(7000L);

        persistirSiEsPosible(entities, marcelo, brenda, india, leon, sebastian, alejandro, santiago);
        
        Libro continuousDelivery = Libro.nuevo().conId(1L).conTitulo("Continuous delivery")
        		.conAutor("Jez Humble").conEditorial("Addison-Wesley");
        Libro designPatterns = Libro.nuevo().conId(2L).conTitulo("Design patterns")
        		.conAutor("Erich Gamma").conEditorial("Addison-Wesley");
        Libro growingOOSoftware = Libro.nuevo().conId(3L).conTitulo("Growing object-oriented software")
        		.conAutor("Steve Freeman").conEditorial("Addison-Wesley");
        Libro pojoInAction = Libro.nuevo().conId(4L).conTitulo("POJO in action")
        		.conAutor("Chris Richardson").conEditorial("Manning");
        Libro tdd = Libro.nuevo().conId(5L).conTitulo("Test-driven development, by example")
        		.conAutor("Kent Beck").conEditorial("Addison-Wesley");
        Libro devopsHandbook = Libro.nuevo().conId(6L).conTitulo("The DevOps handbook")
        		.conAutor("Jez Humble").conEditorial("IT Revolution Press");
        
        persistirSiEsPosible(entities, continuousDelivery, designPatterns, growingOOSoftware, pojoInAction, tdd, devopsHandbook);

        Prestamo prestamo1 = Prestamo.nuevo().conIdLibro(1L).conIdUsuario(1L);
        Prestamo prestamo2 = Prestamo.nuevo().conIdLibro(2L).conIdUsuario(1L);
        Prestamo prestamo3 = Prestamo.nuevo().conIdLibro(1L).conIdUsuario(2L);
        Prestamo prestamo4 = Prestamo.nuevo().conIdLibro(3L).conIdUsuario(2L);

        persistirSiEsPosible(entities,prestamo1,prestamo2,prestamo3,prestamo4);
    }
    
    private static void persistirSiEsPosible(EntityManager entities, Object... entidades) {
        
        for (Object entidad : entidades) {
            
            if (esEntidad(entidad.getClass())) {
                
                entities.persist(entidad);

            } else {
                
                log.warn(entidad.getClass().getSimpleName() + " no es una Entity (no está mapeada). Nada que hacer aquí.");
            }
        }
    }
    
    private static void eliminarDatos(EntityManager entities) {
        
        eliminarSiEsPosible(entities, Usuario.class);
    }
    
    private static void eliminarSiEsPosible(EntityManager entities, Class<?> entity) {
        
        if (esEntidad(entity)) {
            
            entities.createQuery("delete from " + entity.getSimpleName()).executeUpdate();

        } else {
            
            log.warn(entity.getSimpleName() + " no es una Entity (no está mapeada). Nada que hacer aquí.");
        }
    }
    
    private static Boolean esEntidad(Class<?> entity) {
        
        return entity.getAnnotation(Entity.class) != null;
    }
    
}
