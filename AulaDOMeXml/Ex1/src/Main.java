import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//fábrica de documentos
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		//inicialização da construção do doc
		DocumentBuilder builder = factory.newDocumentBuilder(); 
		
		//Manipulação (parse) do documento
		Document doc = builder.parse(new File("alunos.xml")); 
		
		//Remove 
		doc.getDocumentElement().normalize();
		
		NodeList lista = doc.getElementsByTagName("aluno"); 
		for (int i = 0; i < lista.getLength(); i++) { 
			
				Element aluno = (Element) lista.item(i); 
				
				String nome = aluno.getElementsByTagName("nome").item(0).getTextContent(); 
				
				String nota = aluno.getElementsByTagName("nota").item(0).getTextContent(); 
				
							System.out.println(nome + " - " + nota); 
							
				System.out.println("------------------");
		
		}
		
		Document doc2 = builder.newDocument(); 
		
		Element raiz = doc2.createElement("alunos"); 
		Element aluno = doc2.createElement("aluno"); 
		
		Element nome = doc2.createElement("nome"); 
		nome.setTextContent("ViniJr");
		
		Element nota = doc2.createElement("nota"); 
		nome.setTextContent("10");
		
		doc2.appendChild(raiz);
		raiz.appendChild(aluno); 
		aluno.appendChild(nome);
		aluno.appendChild(nota); 
		
		TransformerFactory tf = TransformerFactory.newInstance(); 
		
		Transformer transformer = tf.newTransformer(); 
		
		DOMSource source = new DOMSource(doc2); 
		
		StreamResult result = new StreamResult (new File("alunos2.xml")); 
		
		transformer.transform(source, result);
		
		File arquivo = new File ("alunos2.xml"); 
		
		if(arquivo.exists()) { 
			System.out.println ("Arquivo já existe"); 
		} 
		
		else { 
			System.out.println ("Arquivo não existe"); 
			
				Document doc3 = builder.newDocument(); 
				
				Element raiz1 = doc2.createElement("alunos"); 
				Element aluno1 = doc2.createElement("aluno"); 
				
				Element nome1 = doc2.createElement("nome"); 
				nome1.setTextContent("ViniJr");
				
				Element nota1 = doc2.createElement("nota"); 
				nota1.setTextContent("10");
				
				doc2.appendChild(raiz);
				raiz.appendChild(aluno); 
				aluno.appendChild(nome);
				aluno.appendChild(nota); 
		}
		
		
	}
}