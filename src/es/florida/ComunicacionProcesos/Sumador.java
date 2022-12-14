package es.florida.ComunicacionProcesos;

public class Sumador {

	static final int ITERACIONES_SOBRECARGA = 100000000;

	public int sumar(int n1, int n2) {
//		System.out.println("Sumando de " + n1 + " hasta " + n2);
		int resultado = 0;
		// simulamos una operacion de carga más compleja que consuma más procesador
		for (int i = n1; i <= n2; i++) {
			long suma_auxiliar = 0;
			for (int j = 1; j < ITERACIONES_SOBRECARGA; j++) {
				suma_auxiliar = suma_auxiliar + j;
			}
			resultado = resultado + i;
		}
		return resultado;
	}

	public static void main(String[] args) {

		Sumador s = new Sumador();
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int resultado = s.sumar(n1, n2);
//		System.out.println("Resultado de este sumador: " + resultado);
		System.out.println(resultado);
//		System.out.flush();

	}

}
