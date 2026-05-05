import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex1 {

	public static void main(String[] args) {
		
		/*String regex = "\\d+"; 
		System.out.println("123".matches(regex)); //true
		System.out.println("abc".matches(regex)); //false
		
		//padrao de cpf
		Pattern p = Pattern.compile("\\d{11}");  
		String texto = "O primeiro CPF é 12345678912";
		texto += "O segundo CPF é 98521457862"; 
		Matcher m = p.matcher(texto); 
		
		//percorre todos os M 
		while (m.find()) { 
			System.out.println ("CPF encontrado"); 
			System.out.println (m.group()); 	
		}
		
		texto = "123.123.123.-09"; 
		String somenteNumeros = texto.replaceAll ("\\D", " ");
		System.out.println (somenteNumeros); */ 
		
		/*Exercício 1 = Regex para validar numero de telefone com 9 dígitos */
		
		Scanner sc = new Scanner (System.in); 
		
		/*String regex1 = "\\((\\d{2})\\)\\d{5}-\\d{4}"; 
		
		System.out.println ("Digite um numero de telefone"); 
		String texto = sc.nextLine(); 
		//(11)12345-6789
		
		System.out.println (texto.matches(regex1)); 
		
		
		//Exercício 2 = Crie um regex para validar uma senha com pelo menos 8 caracteres, 
		//sendo a primeira letra obrigatoriamente maiuscula
		
		
		String regex2 = "^[A-Z]\\w{8,}"; 
		System.out.println ("Digite sua senha:"); 
		String senha = sc.nextLine(); 
		
		System.out.println(senha.matches(regex2)); */
		
		/*Exercício 3 = Crie um regex para validar CEP 
		
		String regex3 = "\\d{5}-\\d{3}"; 
		
		System.out.println ("Digite seu CEP"); 
		String CEP = sc.nextLine(); 
		
		System.out.println (CEP.matches(regex3)); */ 
		
		/*Exercício 4 = Extraia apenas números de uma string.
		
		String texto = "Senha123"; 
	
		String somenteNumeros = texto.replaceAll ("\\D", " ");
		System.out.println (somenteNumeros); */
		
		/*Exercício 5 = 
				
		sc.close(); 
		
	}
	
}
