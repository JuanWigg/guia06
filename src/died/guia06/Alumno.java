package died.guia06;

import java.util.ArrayList;
import java.util.List;


public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	
	
	public Alumno(String nombre, Integer nroLibreta) {
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
	}

	public int creditosObtenidos() {
		int total = 0;
		if(aprobados != null) {
			for(Curso c : this.aprobados) {
				total+= c.getCreditos();
			}
		}
		
		return total;
	}
	
	public int cursosInscriptosEnCicloLectivo(Integer ciclo) {
		int cursosInscripto=0;
		if(cursando != null) {
			for(Curso c : this.cursando) {
				if(c.getCicloLectivo() == ciclo) {
					cursosInscripto++;
				}
			}
		}
		
		return cursosInscripto;
		
	}
	
	public List<Curso> getCursando(){
		return this.cursando;
	}
	
	public List<Curso> getAprobados(){
		return this.aprobados;
	}
	
	@Override
	public boolean equals(Object a) {
		return (a instanceof Alumno && ((Alumno) a).nroLibreta.equals(this.nroLibreta));
	} 
	
	
	public void aprobar(Curso c) {
		//
		if(aprobados == null)
			aprobados = new ArrayList<Curso>();
		cursando.remove(c);
		aprobados.add(c);
	}

	public void inscripcionAceptada(Curso c) {
		//
		if(cursando == null)
			cursando = new ArrayList<Curso>();
		cursando.add(c);
		
	}

	@Override
	public int compareTo(Alumno a) {
		// TODO Auto-generated method stub
		return (int) this.nombre.compareTo(a.nombre);
	}
	
	

}
