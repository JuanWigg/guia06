package died.guia06;

public class App {

	public static void main(String[] args) {
		Alumno al1, al2, al3, al4;
		al1 = new Alumno("Ruperto", 23432);
		al2 = new Alumno("Josefina", 33442);
		al3 = new Alumno("Olavarria", 21222);
		al4 = new Alumno("Ester", 12400);
		
		Curso curso1, curso2, curso3, curso4, curso5;
		curso1 = new Curso("Matematica Superior", 3, 10, 0, 2018); 
		curso2 = new Curso("Dibujo", 3, 10, 0, 2018);
		curso3 = new Curso("Algebra", 3, 10, 0, 2018);
		curso4 = new Curso("Fisica 1", 3, 5, 25, 2018);
		curso5 = new Curso("Sintaxis", 3, 5, 0, 2018);
		
		String mensaje;
		
		/* SETUP */
		mensaje = curso1.inscribir(al1)?"Inscripcion aceptada":"Error, inscripcion fallida";
		System.out.println(al1.getNombre() + " " + mensaje);
		mensaje = curso2.inscribir(al1)?"Inscripcion aceptada":"Error, inscripcion fallida";
		System.out.println(al1.getNombre() + " " + mensaje);
		mensaje = curso3.inscribir(al1)?"Inscripcion aceptada":"Error, inscripcion fallida";
		System.out.println(al1.getNombre() + " " + mensaje);
		System.out.println(" ");
		mensaje = curso1.inscribir(al2)?"Inscripcion aceptada":"Error, inscripcion fallida";
		System.out.println(al2.getNombre() + " " + mensaje);
		mensaje = curso2.inscribir(al2)?"Inscripcion aceptada":"Error, inscripcion fallida";
		System.out.println(al2.getNombre() + " " + mensaje);
		System.out.println(" ");
		mensaje = curso1.inscribir(al3)?"Inscripcion aceptada":"Error, inscripcion fallida";
		System.out.println(al3.getNombre() + " " + mensaje);
		
		System.out.println(" ");
		//CURSO 1 CUPO LLENO
		mensaje = curso1.inscribir(al4)?"Inscripcion aceptada":"Error, inscripcion fallida";
		System.out.println(al4.getNombre() + " " + mensaje);
		
		
		System.out.println(" ");
		//CREDITOS INSUFICIENTES	
		mensaje = curso4.inscribir(al4)?"Inscripcion aceptada":"Error, inscripcion fallida";
		System.out.println(al4.getNombre() + " " + mensaje);
		
		System.out.println(" ");
		//YA ESTA INSCRIPTO A 3 CURSOS DEL MISMO AÑO
		mensaje = curso5.inscribir(al1)?"Inscripcion aceptada":"Error, inscripcion fallida";
		System.out.println(al1.getNombre() + " " + mensaje);
		
		System.out.println(" ");
		curso1.imprimirAlfabeticamenteInscriptos();
		System.out.println(" ");
		curso1.imprimirPorLibretaInscriptos();
		System.out.println(" ");
		al1.aprobar(curso2);
		al1.aprobar(curso3);
		al2.aprobar(curso2);
		
		curso1.imprimirPorCreditosInscriptos();
		
		
	}
}
