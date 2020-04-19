package died.guia06;

public class App {

	public static void main(String[] args) {
		
		//SETUP
		Alumno al1, al2, al3;
		al1 = new Alumno("Ruperto", 23432);
		al2 = new Alumno("Josefina", 33442);
		al3 = new Alumno("Olavarria", 21222);
		
		Curso curso1, curso2, curso3, curso4, curso5, curso6;
		curso1 = new Curso("Matematica Superior", 3, 10, 0, 2018); 
		curso2 = new Curso("Dibujo", 1, 10, 0, 2018);
		curso3 = new Curso("Algebra", 3, 10, 0, 2018);
		curso4 = new Curso("Fisica 1", 3, 5, 25, 2018);
		curso5 = new Curso("Sintaxis", 0, 5, 0, 2018);
		curso6 = new Curso("Algoritmos", 1, 5, 0, 2018);
		
		//Ejemplo excepcion cupo no disponible
		try{
			curso5.inscribirAlumno(al1);
		}
		catch(CreditosInsuficientesException e){
			System.out.println("Error: El alumno no posee suficientes creditos para inscribirse a la materia");
		}
		catch(CupoInsuficienteException e){
			System.out.println("Error: Ya no hay cupo en el curso");
		}
		catch(CursadoCompletoException e){
			System.out.println("Error: El alumno ya cursa tres materias del ciclo lectivo");
		}
		catch(RegistroAuditoriaException e){
			System.out.println("Error: No se pudo guardar el registro");
		}
		
		//Ejemplo de excepcion creditos insuficientes
		try{
			curso4.inscribirAlumno(al1);
		}
		catch(CreditosInsuficientesException e){
			System.out.println("Error: El alumno no posee suficientes creditos para inscribirse a la materia");
		}
		catch(CupoInsuficienteException e){
			System.out.println("Error: Ya no hay cupo en el curso");
		}
		catch(CursadoCompletoException e){
			System.out.println("Error: El alumno ya cursa tres materias del ciclo lectivo");
		}
		catch(RegistroAuditoriaException e){
			System.out.println("Error: No se pudo guardar el registro");
		}
		
		//Inscribo al alumno1 en tres cursos
		//Primera inscripcion
		try{
			curso1.inscribirAlumno(al1);
		}
		catch(CreditosInsuficientesException e){
			System.out.println("Error: El alumno no posee suficientes creditos para inscribirse a la materia");
		}
		catch(CupoInsuficienteException e){
			System.out.println("Error: Ya no hay cupo en el curso");
		}
		catch(CursadoCompletoException e){
			System.out.println("Error: El alumno ya cursa tres materias del ciclo lectivo");
		}
		catch(RegistroAuditoriaException e){
			System.out.println("Error: No se pudo guardar el registro");
		}
		
		//Segunda inscripcion
		try{
			curso2.inscribirAlumno(al1);
		}
		catch(CreditosInsuficientesException e){
			System.out.println("Error: El alumno no posee suficientes creditos para inscribirse a la materia");
		}
		catch(CupoInsuficienteException e){
			System.out.println("Error: Ya no hay cupo en el curso");
		}
		catch(CursadoCompletoException e){
			System.out.println("Error: El alumno ya cursa tres materias del ciclo lectivo");
		}
		catch(RegistroAuditoriaException e){
			System.out.println("Error: No se pudo guardar el registro");
		}
		
		//Tercer inscripcion
		try{
			curso3.inscribirAlumno(al1);
		}
		catch(CreditosInsuficientesException e){
			System.out.println("Error: El alumno no posee suficientes creditos para inscribirse a la materia");
		}
		catch(CupoInsuficienteException e){
			System.out.println("Error: Ya no hay cupo en el curso");
		}
		catch(CursadoCompletoException e){
			System.out.println("Error: El alumno ya cursa tres materias del ciclo lectivo");
		}
		catch(RegistroAuditoriaException e){
			System.out.println("Error: No se pudo guardar el registro");
		}
		
		//Ejemplo de cursado completo 
		try{
			curso6.inscribirAlumno(al1);
		}
		catch(CreditosInsuficientesException e){
			System.out.println("Error: El alumno no posee suficientes creditos para inscribirse a la materia");
		}
		catch(CupoInsuficienteException e){
			System.out.println("Error: Ya no hay cupo en el curso");
		}
		catch(CursadoCompletoException e){
			System.out.println("Error: El alumno ya cursa tres materias del ciclo lectivo");
		}
		catch(RegistroAuditoriaException e){
			System.out.println("Error: No se pudo guardar el registro");
		}
		
		//Inscribo a mas alumnos a los cursos para el ejemplo de imprimir en distintos criterios
		//Inscribo alumno2 en curso1
		try{
			curso1.inscribirAlumno(al2);
		}
		catch(CreditosInsuficientesException e){
			System.out.println("Error: El alumno no posee suficientes creditos para inscribirse a la materia");
		}
		catch(CupoInsuficienteException e){
			System.out.println("Error: Ya no hay cupo en el curso");
		}
		catch(CursadoCompletoException e){
			System.out.println("Error: El alumno ya cursa tres materias del ciclo lectivo");
		}
		catch(RegistroAuditoriaException e){
			System.out.println("Error: No se pudo guardar el registro");
		}
		//Inscribo alumno2 en curso2
		try{
			curso2.inscribirAlumno(al2);
		}
		catch(CreditosInsuficientesException e){
			System.out.println("Error: El alumno no posee suficientes creditos para inscribirse a la materia");
		}
		catch(CupoInsuficienteException e){
			System.out.println("Error: Ya no hay cupo en el curso");
		}
		catch(CursadoCompletoException e){
			System.out.println("Error: El alumno ya cursa tres materias del ciclo lectivo");
		}
		catch(RegistroAuditoriaException e){
			System.out.println("Error: No se pudo guardar el registro");
		}
		
		//Inscribo alumno3 en curso1
		try{
			curso1.inscribirAlumno(al3);
		}
		catch(CreditosInsuficientesException e){
			System.out.println("Error: El alumno no posee suficientes creditos para inscribirse a la materia");
		}
		catch(CupoInsuficienteException e){
			System.out.println("Error: Ya no hay cupo en el curso");
		}
		catch(CursadoCompletoException e){
			System.out.println("Error: El alumno ya cursa tres materias del ciclo lectivo");
		}
		catch(RegistroAuditoriaException e){
			System.out.println("Error: No se pudo guardar el registro");
		}
		
		
		
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
