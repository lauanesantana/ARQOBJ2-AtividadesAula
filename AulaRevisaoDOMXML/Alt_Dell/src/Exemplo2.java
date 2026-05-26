import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;

public class Exemplo2 {

	public static <Nodelist> void main(String[] args)
		throws ParserConfigurationException, TransformerException {
		
			File arquivo1 = new File ("src/exemplo2.xml"); 
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
			
			DocumentBuilder builder = factory.newDocumentBuilder(); 
			
			Document doc = null; 
	
			/*try {
		
		        // lê o XML
		        doc = builder.parse(arquivo1);
		
		    } catch (SAXException e) {
		
		        System.out.println("Erro no XML:");
		        e.printStackTrace();
		        return;
		
		    } catch (IOException e) {
		
		        System.out.println("Erro ao ler o arquivo:");
		        e.printStackTrace();
		        return;
		    }*/
		
		    // normaliza o documento
		    doc.getDocumentElement().normalize();
		
		    // pega todos os alunos
		    NodeList lista =
		            doc.getElementsByTagName("exemplo2");
		    
		    System.out.println("Digite o nome do aluno que deseja remover: \n"); 
		    Scanner sc = new Scanner (System.in);
		    String nomeDesejado = sc.next(); 
		
		    Nodelist lista2 = selectNodeList(nomeDesejado); 
		    
		    System.out.println (lista2); 
		    		
		  /* // pega o primeiro aluno
		    Element exemplo =
		            (Element) lista.item(0);
		
		    // pega a tag <nome>
		    Element nome =
		            (Element) exemplo
		                    .getElementsByTagName("nome")
		                    .item(0);
		
		    // altera o nome
		    nome.setTextContent("Mouse Gamer");
		    
		 // pega a tag <nome>
		    Element preco =
		            (Element) exemplo
		                    .getElementsByTagName("preco")
		                    .item(0);
		    
		    int novoPreco = 120; 
		    preco.setTextContent(String.valueOf(novoPreco));

		    // cria o transformer
		    TransformerFactory transformerFactory =
		            TransformerFactory.newInstance();
		
		    Transformer transformer =
		            transformerFactory.newTransformer();
		
		    // origem = documento em memória
		    DOMSource source =
		            new DOMSource(doc);
		
		    // destino = arquivo XML
		    StreamResult result =
		            new StreamResult(arquivo2);
		
		    // salva no arquivo
		    transformer.transform(source, result);
		
		    System.out.println("XML atualizado com sucesso!");*/
	
		sc.close(); 
	}

	private static <Nodelist> Nodelist selectNodeList(String nomeDesejado) {
		// TODO Auto-generated method stub
		return null;
	}

}
