import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex2Map {

	public static void main(String[] args) {
		Map<String, Integer> login = new HashMap<>(); 
		Scanner sc = new Scanner (System.in); 
		
		login.put("Lauane", 15698); 
		login.put("Karol", 561230); 
		login.put("Camilly", 85214); 
		
		System.out.println("SISTEMA DE LOGIN/SENHA:\n"); 
		System.out.println("Digite o login: "); 
		String nome = sc.nextLine(); 
		
		System.out.println("Digite a senha: "); 
		Integer senha = sc.nextInt(); 

		
		if(login.get(nome).equals(senha)) { 
			System.out.println ("\nLogin correto!"); 
			
		} else { 
			System.out.println ("\nLogin Incorreto!"); 
		} 
		
		sc.close(); 
	}
}

