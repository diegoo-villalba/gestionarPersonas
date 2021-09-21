package personas;

import java.util.Comparator;

public class EdadComparator implements Comparator<Persona>{

	@Override
	public int compare(Persona p1, Persona p2) {
		return Integer.compare(p1.getEdad(), p2.getEdad());
	}

}
