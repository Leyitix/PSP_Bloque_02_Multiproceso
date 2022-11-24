package es.florida.EJERCICIOS;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio_007_ProcessBuilderRedirectOutput {
	
	public void lanzarEjercicio001(Integer n1, Integer n2, String nombreFichero) {
		String clase = "es.florida.EJERCICIOS.Ejercicio_001_Sumador";
		File fichero = new File(nombreFichero);
		
		try {
			
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			System.out.println(classpath);
			String className = clase;
			
			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(n1.toString());
			command.add(n2.toString());
			
			System.out.println("Comando que se pasa a ProcessBuilder: " + command);
			System.out.println("Comando a ejecutar en cmd.exe: " + command.toString().replace(",", ""));
			
			ProcessBuilder builder = new ProcessBuilder(command);
			builder.redirectOutput(fichero);	//	en vez de mostrar syso por consola, lo vuelca en un fichero
			builder.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		Ejercicio_007_ProcessBuilderRedirectOutput ej = new Ejercicio_007_ProcessBuilderRedirectOutput();
		ej.lanzarEjercicio001(1, 10, "resultadoSuma03.txt");
		System.out.println("OK!");
	}

}
