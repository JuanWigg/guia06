package died.guia06;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CursoTest {
	
	Curso c1, c2, c3, c4, c5, c6;
	Alumno a1,a2,a3,a4;
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	
	@BeforeEach
	public void init() {
		// Setup for tests
		a4 = new Alumno("Roberta", 44444);
		
		
		//Para el test de ciclo lectivo
		c1 = new Curso("Gestion", 3, 10, 0, 2015);
		c4 = new Curso("manicura", 1, 10, 0, 2015);
		c5 = new Curso("fotografia", 2, 10, 0, 2015);
		c6 = new Curso("comida", 2, 10, 0, 2015);

		//Para  el test de cupo lleno
		a1 = new Alumno("Jose", 11111);
		a2 = new Alumno("Juan",22222);
		a3 = new Alumno("Gabriela",33333);
		
		c1.inscribir(a1);
		c1.inscribir(a2);
		c1.inscribir(a3);
		
		//Para el test de creditos insuficientes
		c2 = new Curso ("Tutoria epica", 3, 10, 25, 2015);
		c3 = new Curso ("Ingles 80", 3, 1, 10, 2015);
		/*
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
		*/
		c4.inscribir(a1);
		c5.inscribir(a1);
		c4.inscribir(a2);
		
	}
	
	

	
	@Test
	void testCupoLleno() {
		assertFalse("Deberia haber dado falso, no tiene mas cupo", c1.inscribir(a4));
		
	}
	
	@Test
	void testCreditosInsuficientes() {
		assertFalse("Deberia haber dado falso, no tiene creditos", c2.inscribir(a4));
	}

	
	@Test
	void testYaCursa3CicloLectivo() {
		assertFalse("Deberia haber dado falso, ya esta cursando 3 materias con ciclo 2015", c6.inscribir(a1));
	}

	@Test
	void imprimirAlfabeticamente() {
	
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
		c1.imprimirAlfabeticamenteInscriptos();
		assertEquals(0, "Alumnos inscriptos ordenados alfabeticamente: \nGabriela\nJose\nJuan\n".compareTo(outContent.toString()));
		
		
	}

	@Test
	void imprimirPorLibreta() {
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
		c1.imprimirPorLibretaInscriptos();
		assertEquals(0, "Alumnos inscriptos ordenados por libreta: \nJose\nJuan\nGabriela\n".compareTo(outContent.toString()));
	}
	
	@Test
	void imprimirPorCreditos() {
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	    a1.aprobar(c4);
		a1.aprobar(c5);
		a2.aprobar(c4);
		 
		c1.imprimirPorCreditosInscriptos();
		assertEquals(0, "Alumnos inscriptos ordenados por creditos (ascendente): \nGabriela\nJuan\nJose\n".compareTo(outContent.toString()));
	}
	
	@AfterEach
	public void restoreStreams() {
		 System.setOut(originalOut);
		 System.setErr(originalErr);
		
		 
	}
	
}

