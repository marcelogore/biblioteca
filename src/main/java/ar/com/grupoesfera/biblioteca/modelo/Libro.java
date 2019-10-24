package ar.com.grupoesfera.biblioteca.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Libro {

	@Id private Long id;
	@Column private String titulo;
	@Column private String autor;
	@Column private String editorial;

	public Long getId() {

		return this.id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getTitulo() {

		return titulo;
	}

	public void setTitulo(String titulo) {

		this.titulo = titulo;
	}

	public String getAutor() {

		return autor;
	}

	public void setAutor(String autor) {

		this.autor = autor;
	}

	public String getEditorial() {

		return editorial;
	}

	public void setEditorial(String editorial) {

		this.editorial = editorial;
	}

	public static Libro nuevo() {

		return new Libro();
	}

	public Libro conId(Long id) {

		setId(id);
		return this;
	}

	public Libro conTitulo(String titulo) {

		setTitulo(titulo);
		return this;
	}

	public Libro conAutor(String autor) {

		setAutor(autor);
		return this;
	}

	public Libro conEditorial(String editorial) {

		setEditorial(editorial);
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
		Libro other = (Libro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
