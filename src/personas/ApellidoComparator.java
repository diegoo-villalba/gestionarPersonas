package personas;

import java.util.Comparator;

public class ApellidoComparator implements Comparator<Persona> {

	@Override
	public int compare(Persona p1, Persona p2) {
		return p1.getApellido().compareTo(p2.getApellido());
	//Usa CompareTo de string que devuelve 1, 0 o -1
	}

}
