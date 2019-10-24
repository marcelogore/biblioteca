package ar.com.grupoesfera.biblioteca.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Prestamo {

	@Id @GeneratedValue
	private Long id;
	@Column
	private Long idUsuario;
	@Column
	private Long idLibro;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public Long getIdUsuario() {

		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {

		this.idUsuario = idUsuario;
	}

	public Long getIdLibro() {

		return idLibro;
	}

	public void setIdLibro(Long idLibro) {

		this.idLibro = idLibro;
	}

	public static Prestamo nuevo() {

		return new Prestamo();
	}

	public Prestamo conId(Long id) {

		setId(id);
		return this;
	}

	public Prestamo conIdUsuario(Long idUsuario) {

		setIdUsuario(idUsuario);
		return this;
	}

	public Prestamo conIdLibro(Long libro) {

		setIdLibro(libro);
		return this;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prestamo other = (Prestamo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
