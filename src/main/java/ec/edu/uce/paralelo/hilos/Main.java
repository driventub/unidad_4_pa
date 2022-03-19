package ec.edu.uce.paralelo.hilos;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		
		long tiempoInicial = System.currentTimeMillis();
		
		Cajero cajero1 = new Cajero("Edison", Arrays.asList(1,2,3,4,5));
		Cajero cajero2 = new Cajero("Carlos", Arrays.asList(1,2,3,4));
		Cajero cajero3 = new Cajero("Carla", Arrays.asList(2,3,3,4,5));
		
		GestorAtencion gestor1 = new GestorAtencion();
		GestorAtencion gestor2 = new GestorAtencion();
		GestorAtencion gestor3 = new GestorAtencion();
		
		gestor1.procesar(cajero1, tiempoInicial);
		gestor2.procesar(cajero2, tiempoInicial);
		gestor3.procesar(cajero3, tiempoInicial);

//		gestor1.procesar(cajero1, tiempoInicial);
//		gestor1.procesar(cajero2, tiempoInicial);
//		gestor1.procesar(cajero3, tiempoInicial);
		
		long tiempoFinal = System.currentTimeMillis();
		
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000;
		
		System.out.println(tiempoTranscurrido + "seg");
	}

}
