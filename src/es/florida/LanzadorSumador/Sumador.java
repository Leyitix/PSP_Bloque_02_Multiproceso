package es.florida.LanzadorSumador;

public class Sumador {
	
	public static int sumar(int n1, int n2) {
		System.out.println("Sumando de " + n1 + " hasta " + n2);
		int resultado = 0;
		for (int i = n1; i <= n2; i++) {
			resultado = resultado + i;
		}
		return resultado;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Sumador s = new Sumador();
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int resultado = sumar(n1, n2);
		System.out.println("Resultado de este sumador: " + resultado);
	}

}
