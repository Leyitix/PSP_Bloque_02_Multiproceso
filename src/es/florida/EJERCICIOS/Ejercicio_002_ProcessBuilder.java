package es.florida.EJERCICIOS;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio_002_ProcessBuilder {
	
	//	 Realiza un programa en Java que llame al programa anterior a través de una llamada de 
	//	 sistema, es decir, creando un proceso nuevo con ProcessBuilder

	public void lanzarEjercicio_001(Integer n1, Integer n2) {
		String clase = "es.florida.EJERCICIOS.Ejercicio_001_Sumador";
		
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
			Process process = builder.inheritIO().start();
			process.waitFor();
			System.out.println(process.exitValue());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Ejercicio_002_ProcessBuilder ej = new Ejercicio_002_ProcessBuilder();
		ej.lanzarEjercicio_001(1, 10);
		System.out.println("Proceso terminado!");
	}

}
