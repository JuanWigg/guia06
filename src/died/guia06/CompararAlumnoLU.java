/**
 * 
 */
package died.guia06;

import java.util.Comparator;

/**
 * @author juanwigg
 *
 */
public class CompararAlumnoLU implements Comparator<Alumno> {

	@Override
	public int compare(Alumno a1, Alumno a2) {
		// TODO Auto-generated method stub
		return  a1.getNroLibreta()-a2.getNroLibreta();
	}

}
