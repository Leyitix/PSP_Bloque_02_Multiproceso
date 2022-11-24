package es.florida.EJERCICIOS;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio_003_SumadorEscribirEnFichero {
	
	//	 Crear una modificación del programa número 1 para que escriba el resultado en un fichero 
	//	en disco.

	public int sumar(int n1, int n2, String nombreFichero) throws IOException {
		System.out.println("Sumando de " + n1 + " hasta " + n2);
		int resultado = 0;
		for (int i = n1; i <= n2; i++) {
			resultado += i;
		}
		escribirFichero(nombreFichero, resultado);
		return resultado;
	}
	
	public void escribirFichero(String nombreFichero, int resultado) throws IOException {
		//	escribir en disco
		File fichero = new File(nombreFichero);
		FileWriter fw = new FileWriter(fichero);
		BufferedWriter bw = new BufferedWriter(fw);
		System.out.println("Iniciar escritura en fichero...");
		bw.write(String.valueOf(resultado));
		
		bw.close();
		fw.close();
		
		System.out.println("Fichero escrito con éxito!");
	}

	public static void main(String[] args) throws IOException {
		Ejercicio_003_SumadorEscribirEnFichero ej = new Ejercicio_003_SumadorEscribirEnFichero();
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		String nombreFichero = args[2];
		int resultado = ej.sumar(n1, n2, nombreFichero);
		System.out.println("Resultado de este sumador: " + resultado);
	}

}
