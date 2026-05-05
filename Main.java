import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Map<String, String> aluno = new HashMap<>(); 
		Map<String, Double> alunoNotas = new HashMap<>();  
		
		aluno.put("AQ303724X", "Lauane Santana"); 
		aluno.put("AQ3030307", "Pedro Correa"); 
		aluno.put("AQ805020", "Jade Picon"); 
		
		String a = aluno.get("AQ303724X");
		//System.out.println(a); 
		
		alunoNotas.put("Lauane", 9.0);
		alunoNotas.put("Ellen", 7.5); 
		alunoNotas.put("Camilly", 8.7); 
		
		Double nota = alunoNotas.get("Camilly"); 
		System.out.println(nota); 
		
		alunoNotas.remove("Ellen"); 
		
		if(alunoNotas.containsKey("Lauane")); 
			double n = alunoNotas.get("Lauane"); 
			System.out.println ("Nota da Lauane: " + n); 
			
		if(alunoNotas.containsValue(6.0)) {
			System.out.println("Contem nota 6.0"); 
			
		} else {  
			System.out.println("Nao contem nota 6.0"); 
		}	
		
		//Percorrendo chaves... pego tudo  do meu conjunto alunoNotas e vou guardando em k 
		
		for (String k : alunoNotas.keySet()) { 
			System.out.println(k); 
		}
		//Percorrendo valores... 
		
		for (Double b : alunoNotas.values()) { 
			System.out.println (b); 
		}
		
		//Percorrendo chave e valor... 
		
		for (Map.Entry<String, Double> e : alunoNotas.entrySet()) { 
			System.out.println (e.getKey() + " tem nota " + e.getValue()); 
		}
	}
}
