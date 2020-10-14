package DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Carro;

public class CarroDAO {
	
	private static final Map<Integer, Carro> userMap = new HashMap<Integer, Carro>();
	private static int i = 3;
	
	static {
		initCarros();
	}
	
	private static void initCarros() {
        Carro carro1 = new Carro(1, "numberOne","Fiat","2020","2020","21/10/2020");
        Carro carro2 = new Carro(2, "numberTwo","Toyota","2015","2015","1/7/2020");

        userMap.put(carro1.getId(), carro1);
        userMap.put(carro2.getId(), carro2);

    }
	
	 public static Carro getCarro(int id) {
	        return userMap.get(id);
	 }
	 
	 
	 public static List<Carro> getCarrosByMarca(String marca) {
	        List<Carro> list = getAllCarros();
	        List<Carro> carros = new ArrayList<Carro>(); 
	        
	        for (Carro carro: list) {
	            if (carro.getMarca().equals(marca)) {
	                carros.add(carro);
	            }
	        }
	 
	        return carros;
	}
	 
	public static List<Carro> getByQtd(String qtd){
		
		int num = Integer.parseInt(qtd);
		
		List<Carro> list = getAllCarros();
		List<Carro> carros = new ArrayList<Carro>();
		
		for(int i=0;i<num;i++) {
			carros.add(list.get(i));
		}
		
		return carros;
	}
	 
	 public static Carro addCarro(String nome, String marca, String anoFabricacao, String anoModelo, String dataVenda ) {
		  	Carro carro = new Carro(i, nome, marca, anoFabricacao, anoModelo, dataVenda);
	        userMap.put(carro.getId(), carro);
	        i++;
	        return carro;
	 }	 
	 
	 public static Carro updateCarro(int id, String nome, String marca, String anoFabricacao, String anoModelo, String dataVenda ) {
		 	Carro carro = new Carro(id, nome, marca, anoFabricacao, anoModelo, dataVenda);
	        userMap.put(carro.getId(), carro);
	        return carro;
	 }
	 
	 public static void deleteCarro (int id) {
	        if (userMap.containsKey(id)) {
	            userMap.remove(id);
	        }
	 }
	 
	 public static List<Carro> getAllCarros() {
	        return new ArrayList<Carro>(userMap.values());
	 }
	 
}
