package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	public Curso(String nombre, Integer cupo, Integer creditos, Integer creditosRequeridos) {
		super();
		this.nombre = nombre;
		this.cupo = cupo;
		this.creditos = creditos;
		this.creditosRequeridos = creditosRequeridos;
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	public Curso(Integer id, String nombre, Integer cupo, Integer creditos, Integer creditosRequeridos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cupo = cupo;
		this.creditos = creditos;
		this.creditosRequeridos = creditosRequeridos;
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}
	
	public void setCicloLectivo(Integer cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}
	
	public Integer getCreditos() {
		return this.creditos;
	}
	
	public Integer getCicloLectivo() {
		return this.cicloLectivo;
	}

	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public Boolean inscribir(Alumno a) {
		Integer credAlumno = a.creditosObtenidos();
		Integer cursosInscripto = a.cursosInscriptosEnCicloLectivo(this.cicloLectivo);
		if(credAlumno >= this.creditosRequeridos && cupo > inscriptos.size() && cursosInscripto <= 2) {
			try {
				log.registrar(this, "inscribir ",a.toString());
				if(inscriptos == null)
					inscriptos = new ArrayList<Alumno>();
				a.inscripcionAceptada(this);
				inscriptos.add(a);
				return true;
			}
			catch(IOException e){
				System.out.println("Hubo un error al inscribir el alumno");
				return false;
			}
		}
		else {
			System.out.println("El alumno no cumple con los requisitos para inscribirse al curso");
			return false;
		}
			
		
	}
	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirAlfabeticamenteInscriptos() {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			Collections.sort(this.inscriptos);
			System.out.println("Alumnos inscriptos ordenados alfabeticamente: ");
			for(Alumno a : inscriptos ) {
				System.out.println(a.getNombre());
			}
		}
		catch(IOException e){
			System.out.println("Hubo un error al intentar imprimir el listado");
			
		}
	}
	/**
	 * imprime los inscriptos por orden de libreta ( 1 - 24026, 2 - 25320, 3 - 25415, ...)
	 */
	public void imprimirPorLibretaInscriptos() {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			CompararAlumnoLU comparador = new CompararAlumnoLU();
			Collections.sort(this.inscriptos, comparador);
			System.out.println("Alumnos inscriptos ordenados por libreta: ");
			for(Alumno a : inscriptos ) {
				System.out.println(a.getNombre());
			}
		}
		catch(IOException e){
				System.out.println("Hubo un error al intentar imprimir el listado");
				
		}
	}
	
	/** 
	 * imprime los inscriptos por creditos descendentemente (1 - 250, 2 - 120, 3 - 90 ...) 
	*/
	public void imprimirPorCreditosInscriptos() {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			CompararAlumnoCO comparador = new CompararAlumnoCO();
			Collections.sort(this.inscriptos, comparador);
			System.out.println("Alumnos inscriptos ordenados por creditos: ");
			for(Alumno a : inscriptos ) {
				
				System.out.println(a.getNombre());
			}
		}
		catch(IOException e){
				System.out.println("Hubo un error al intentar imprimir el listado");
				
		}
		
	}


}
