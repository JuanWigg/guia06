package died.guia06;

import java.util.List;


public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

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
	
	public boolean equals(Alumno a) {
		return (this.nroLibreta == a.nroLibreta);
	}
	
	
	public void aprobar(Curso c) {
		//
		cursando.remove(c);
		aprobados.add(c);
	}

	public void inscripcionAceptada(Curso c) {
		//
		cursando.add(c);
		
	}

	@Override
	public int compareTo(Alumno a) {
		// TODO Auto-generated method stub
		return (int) this.nombre.compareTo(a.nombre);
	}
	
	

}
