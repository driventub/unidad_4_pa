package ec.edu.uce.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainStreamsParalelo {
	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		
		List<Integer> lista  = new ArrayList<>();
//		List<String > listaS  = new ArrayList<>();
		for(int i = 1; i<= 10000 ; i++) {
			lista.add(i);
		}
		
		List<String> listaS = lista.parallelStream().map(numero -> convertirNumero(numero)).collect(Collectors.toList());
//		Metodo Referenciado
		listaS.forEach(System.out::println);
		long fin = System.currentTimeMillis();
		
		long tiempo = (fin - inicio)/1000;
		
		System.out.println("Tiempo total: " + tiempo + "s");
		
	}
	
	private static String convertirNumero(Integer numero) {
		System.out.println(Thread.currentThread().getName());
		try {
//			Se demora en la atencion
			TimeUnit.MILLISECONDS.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "N:" + numero.toString();
				
	}
}
