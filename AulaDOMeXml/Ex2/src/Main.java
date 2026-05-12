import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Main {

	public static void main(String[] args) throws Exception {
		/*Faça um programa para criar arquivo caso não exista e adicionar alunos com suas notas. Crie um menu de cadastrar 
		 * alunos ou exibir
		 - A lista de alunos 
		 - A média das notas 
		 - O aluno com maior nota
		 - Quantos alunos possuem nota maior ou igual a 7*/ 
		
		//fábrica de documentos
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
		
		//inicialização da construção do doc 
		DocumentBuilder builder = factory.newDocumentBuilder(); 
		
		//Manipulação (parse) do documento 
		//Document docNovo = builder.parse(new File ("exercicio.xml")); 
		
		Document docNovo = builder.newDocument(); 
		
		//Remove
		docNovo.getDocumentElement().normalize(); 
			
			Element raiz = docNovo.createElement("alunos"); 
			Element aluno = docNovo.createElement("aluno"); 
			
			Element nome = docNovo.createElement("nome"); 
			nome.setTextContent("ViniJr");
			nome.setTextContent("Virgínia"); 
			
			Element nota = docNovo.createElement("nota"); 
			nota.setTextContent("3");
			nota.setTextContent("10"); 
			
		System.out.println (" - - - - - - Seja bem vindo a manipulação de arquivos - - - - - - "); 
		
		int op = -1; 
		Scanner sc = new Scanner (System.in); 
		
		do { 
			System.out.println("[ 1 - Exibir alunos já cadastrados ] \n"); 
			System.out.println("[ 2 - Cadastrar aluno e nota ] \n"); 
			System.out.println("[ 3 - Exibir média das notas ] \n"); 
			System.out.println("[ 4 - Exibir aluno com a maior nota ]\n"); 
			System.out.println("[ 5 - Exibir quantos alunos possuem nota maior ou igual a 7 ] \n"); 
			op = sc.nextInt(); 
			
			switch (op) { 
				case 1: 
					break; 
				case 2: 
					
			}
			
			
			
			
		} while (op != 5); 
	
	sc.close(); 
	}

}


 