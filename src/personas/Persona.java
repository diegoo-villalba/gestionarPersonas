package personas;

import java.util.Objects;

public class Persona {
	
	private int dni;
	private int edad;
	private String apellido;
	
	
	public Persona(int dni, String apellido, int edad) {
		super();
		this.dni = dni;
		this.apellido = apellido;
		this.edad = edad;
	}


	public int getDni() {
		return dni;
	}


	public int getEdad() {
		return edad;
	}


	public String getApellido() {
		return apellido;
	}

	//IMPORTANTE: Implementar HashCode y Equals para poder hacer los comparadores
	@Override
	public int hashCode() {
		return Objects.hash(apellido, dni, edad);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellido, other.apellido) && dni == other.dni && edad == other.edad;
	}


	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", edad=" + edad + ", apellido=" + apellido + "]";
	}
	
	
}
