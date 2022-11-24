package es.florida.EJERCICIOS;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio_006_ProcessBuilderInheritIO {
	
	//	 Crea una ampliación del programa 2 para que redirija la salida de la ejecución del programa 
	//	 1 a su flujo de ejecución y lo muestre por consola (pista: utilizar inheritIO).
	
	public void lanzarEjercicio001(Integer n1, Integer n2) {
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
			
		} catch (IOException | InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Ejercicio_006_ProcessBuilderInheritIO ej = new Ejercicio_006_ProcessBuilderInheritIO();
		ej.lanzarEjercicio001(1, 10);
		System.out.println("OK!");

	}


}
