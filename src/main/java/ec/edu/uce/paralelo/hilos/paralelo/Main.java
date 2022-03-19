package ec.edu.uce.paralelo.hilos.paralelo;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		
		long tiempoInicial = System.currentTimeMillis();
		
		CajeroHilo cajero1 = new CajeroHilo("Edison", Arrays.asList(1,2,3,4,5));
		CajeroHilo cajero2 = new CajeroHilo("Carlos", Arrays.asList(1,2,3,4));
		CajeroHilo cajero3 = new CajeroHilo("Carla", Arrays.asList(2,3,3,4,5));
		
		GestorAtencionHilo gestor1 = new GestorAtencionHilo(cajero1, tiempoInicial);
		GestorAtencionHilo gestor2 = new GestorAtencionHilo(cajero2, tiempoInicial);
		GestorAtencionHilo gestor3 = new GestorAtencionHilo(cajero3, tiempoInicial);
		
		gestor1.start(); //procesar
		gestor2.start();
		gestor3.start();

		
		long tiempoFinal = System.currentTimeMillis();
		
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000;
		
		System.out.println(tiempoTranscurrido + "seg");
	}

}
