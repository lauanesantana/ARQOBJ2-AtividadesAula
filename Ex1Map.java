import java.util.HashMap;
import java.util.Map;

public class Ex1Map {

	public static void main(String[] args) {
		Map<String, String> aluno = new HashMap<>(); 
		
		aluno.put("AQ303030", "Giulia"); 
		aluno.put("AQ606060", "Lauane"); 
		aluno.put("AQ505050", "Camilly"); 
		aluno.put("AQ808080", "Victoria"); 
		aluno.put("AQ404040", "Carol"); 
		
		String ra = aluno.get("AQ404040"); 
		System.out.println("\n\nA aluna pertencente a esse RA é a: " + ra); 
		
		for (Map.Entry<String, String> entry : aluno.entrySet()) { 
			String doc = entry.getKey(); 
			String nome = entry.getValue(); 
			
			System.out.println("RA: " + doc + "- NOME: " + nome); 
		}
	}
}
