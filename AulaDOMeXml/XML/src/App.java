import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class App {

	public static void main(String[] args) throws Exception {
		
		//fábrica de documentos
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		//inicialização da construção do doc
		DocumentBuilder builder = factory.newDocumentBuilder(); 
		
		//Manipulação (parse) do documento
		Document doc = builder.parse(new File("dados.xml")); 
		
		//Remove 
		doc.getDocumentElement().normalize();
		
		NodeList lista = doc.getElementsByTagName("nome"); 
		for (int i = 0; i < lista.getLength(); i++) { 
			Node node = lista.item(i); 
			System.out.println (node.getTextContent()); 
		}

	}

}
