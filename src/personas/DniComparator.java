package personas;

import java.util.Comparator;

public class DniComparator implements Comparator<Persona>{

	@Override
	public int compare(Persona p1, Persona p2) {
		return Integer.compare(p1.getDni(), p2.getDni());
	}

}
