package es.florida.EJERCICIOS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio_005_ProcessBuilderLanzarDosProcesos {

	public void lanzarEjercicio_003(Integer n1, Integer n2, String nombreFichero) {
		String clase = "es.florida.EJERCICIOS.Ejercicio_003_SumadorEscribirEnFichero";

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
			command.add(nombreFichero);

			System.out.println("Comando que se pasa a ProcessBuilder: " + command);
			System.out.println("Comando a ejecutar en cmd.exe: " + command.toString().replace(",", ""));

			ProcessBuilder builder = new ProcessBuilder(command);
			Process process = builder.inheritIO().start();
			process.waitFor();
			System.out.println(process.exitValue());

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Deberá implementar algún procedimiento para
		// controlar que el fichero esté efectivamente escrito y su contenido
		// disponible.
		leerFichero(nombreFichero);
	}

	@SuppressWarnings("unused")
	public void leerFichero(String nombreFichero) {
		boolean ficheroLeido = false;
		File fichero = new File(nombreFichero);
		FileReader fr;
		
		try {
			fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			System.out.println("Resultado: " + linea);
			ficheroLeido = true;
			br.close();
			fr.close();
		} catch (FileNotFoundException f) {
			System.out.println("Buscando fichero...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Ejercicio_005_ProcessBuilderLanzarDosProcesos ej = new Ejercicio_005_ProcessBuilderLanzarDosProcesos();
		ej.lanzarEjercicio_003(1, 10, "resultadoSuma01.txt");
		ej.lanzarEjercicio_003(15, 20, "resultadoSuma02.txt");
		System.out.println("Proceso terminado!");
	}

}
