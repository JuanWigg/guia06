package died.guia06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlumnoTest {
	Alumno a1;
	Alumno a2;
	Alumno a3;
	Curso c1;
	
	
	
	@BeforeEach
	public void init() {
		// Setup for tests
		a1 = new Alumno("Pepito", 22222);
		a2 = new Alumno("Roberta", 11111);
		a3 = new Alumno("Roberta", 11111);
		c1 = new Curso();
		c1.setCreditos(20);
	}
	
	
	@Test
	void testCreditosObtenidos() {
		//Exercises
		a2.inscripcionAceptada(c1);
		a2.aprobar(c1);
		
		int credsAl1 = a1.creditosObtenidos();
		int credsAl2 = a2.creditosObtenidos();
		
		
		//Verify
		assertEquals("La cantidad de creditos obtenida no coincide", 0, credsAl1);
		assertEquals("La cantidad de creditos obtenida no coincide", 20, credsAl2);
		
		
	}
	
	@Test
	void testEquals() {
		//EQUAL TEST
		assertTrue("Los alumnos si son iguales ", a2.equals(a3));
		
		//NOT EQUAL TEST
		assertFalse("Los alumnos tienen distinta libreta universitaria", a2.equals(a1));
	}
	
	@Test
	void testCompareTo() {
		assertEquals("Los alumnos si tienen el mismo nombre", 0 ,a2.compareTo(a3));
		
		
		assertTrue("Pepito esta alfabeticamente antes que Roberta", a1.compareTo(a2)<0);
		
		
		
	}

	@Test
	void testAprobar() {
		//Exercises
		a2.inscripcionAceptada(c1);
		a2.aprobar(c1);
		
		//Verify
		assertFalse("El curso no fue eliminado de cursando", a2.getCursando().contains(c1));
		assertTrue("El curso no esta en la lista de aprobados", a2.getAprobados().contains(c1));
		
	}

	@Test
	void testInscripcionAceptada() {
		//Exercises
		a2.inscripcionAceptada(c1);
		
		//Verify
		assertTrue("El curso no esta en la lista de cursando", a2.getCursando().contains(c1));
		
	}

}
