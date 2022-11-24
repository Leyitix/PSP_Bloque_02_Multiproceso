package es.florida.ComunicacionProcesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static final int NUM_INICIO = 1;
	private static final int NUM_FIN = 100;
	private static final int NUM_PROCESOS = 4;
	static final int INTERACIONES_SOBRECARGA = 100000000;
	static final String PREFIJO_FICHEROS = "fich";
	
	public static void lanzarSumador(Integer n1, Integer n2, String fichResultados) {

		String clase = "es.florida.ComunicacionProcesos.Sumador";
		File directorioSumador = new File("C:\\Users\\ainho\\Desktop\\Florida\\2ºDAM\\Servicios_Procesos\\ExamenEvaluacion_01_PSP\\Bloque_02_Multiproceso\\src\\es\\florida\\ComunicacionProcesos");
		File fichResultado = new File(fichResultados);
		
		try {

			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			String className = clase;
			
			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(String.valueOf(n1));
			command.add(String.valueOf(n2));
			
			ProcessBuilder builder = new ProcessBuilder(command);
			builder.directory(directorioSumador);
			builder.redirectOutput(fichResultado);
			Process process = builder.inheritIO().start();
			Process p = builder.start();
			process.waitFor();
			System.out.println(p.exitValue());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int getResultadoFichero(String nombreFichero) {
		int suma = 0;
		try {

			FileInputStream fichero = new FileInputStream(nombreFichero);
			InputStreamReader fir = new InputStreamReader(fichero);
			BufferedReader br = new BufferedReader(fir);
			String linea = br.readLine();
			
			suma = Integer.parseInt(linea);
			br.close();
			return suma;
			
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo abrir " + nombreFichero);
		} catch (IOException e) {
			System.out.println("No hay nada en " + nombreFichero);
		}
		
		return suma;
		
	}
	
	public static int getSumaTotal(int numFicheros) {
		
		int sumaTotal = 0;
		for (int i = 1; i <= NUM_PROCESOS; i++) {
			sumaTotal += getResultadoFichero(PREFIJO_FICHEROS + String.valueOf(i));
		}
		return sumaTotal;
	}

	public static void main(String[] args) {
		long tiempoInicio = System.nanoTime();
		
		int n1 = NUM_INICIO;
		int n2 = NUM_FIN;
		int salto = ( n2 / NUM_PROCESOS) - 1;
		
		for (int i = 1; i <= NUM_PROCESOS; i++) {
			System.out.println("n1: " + n1);
			int resultadoSumaConSalto = n1 + salto;
			System.out.println("n2: " + resultadoSumaConSalto);
			lanzarSumador(n1, n1 + salto, PREFIJO_FICHEROS + String.valueOf(i));
			n1 = n1 + salto + 1;
			System.out.println("Suma lanzada...");
		}
		
		// Thread.sleep(20000);
		boolean comprobarFin = false;
		int sumaTotal = 0;
		while (!comprobarFin) {
			try {
				sumaTotal = getSumaTotal(NUM_PROCESOS);
				comprobarFin = true;
			} catch (Exception e) {
				// nada
			}
		}
		System.out.println("La suma total es: " + sumaTotal);
		
		long tiempoFin = System.nanoTime();
		long duracion = (tiempoFin - tiempoInicio) / 1000000; // milisegundos
		System.out.println("Tiempo ejecucion 1: " + duracion + " ms");
		
		tiempoInicio = System.nanoTime();
		
		int resultado = 0;
		n1 = NUM_INICIO;
		n2 = NUM_FIN;
		
		for (int i = n1; i <= n2; i++) {
			long suma_auxiliar = 0;
			for (int j = 1; j < INTERACIONES_SOBRECARGA; j++) {
				suma_auxiliar = suma_auxiliar + j;
			}
			resultado = resultado + i;
		}
		System.out.println("La suma total es: " +  resultado);
		
		tiempoFin = System.nanoTime();
		duracion = (tiempoFin - tiempoInicio) / 1000000;
		System.out.println("Tiempo ejecicion 2: " + duracion + " ms");
		
	}

}
