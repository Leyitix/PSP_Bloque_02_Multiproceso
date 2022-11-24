package es.florida.EJERCICIOS;

public class Ejercicio_001_Sumador {
	
	// 	Realiza un programa en Java que dados dos números enteros, devuelva por pantalla la suma 
	//  de todos los números que hay entre ellos (incluyéndolos).
	
	public int sumar(int n1, int n2) {
		System.out.println("Sumando de " + n1 + " hasta " + n2);
		int resultado = 0;
		for (int i = n1; i <= n2; i++) {
			resultado += i;
		}
		return resultado;
	}

	public static void main(String[] args) {
		
		Ejercicio_001_Sumador ej = new Ejercicio_001_Sumador();
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int resultado = ej.sumar(n1, n2);
		System.out.println("Resultado de este sumador: " + resultado);
	}

}
