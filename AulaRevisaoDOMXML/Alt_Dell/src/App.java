import java.io.File;
import java.io.IOException;

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

public class App {

    public static void main(String[] args)
            throws ParserConfigurationException, TransformerException {

        // caminho do arquivo XML
    	File arquivo = new File("src/aluno.xml");

        // fábrica do parser
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();

        // parser XML
        DocumentBuilder builder =
                factory.newDocumentBuilder();

        Document doc = null;

        try {

            // lê o XML
            doc = builder.parse(arquivo);

        } catch (SAXException e) {

            System.out.println("Erro no XML:");
            e.printStackTrace();
            return;

        } catch (IOException e) {

            System.out.println("Erro ao ler o arquivo:");
            e.printStackTrace();
            return;
        }

        // normaliza o documento
        doc.getDocumentElement().normalize();

        // pega todos os alunos
        NodeList lista =
                doc.getElementsByTagName("aluno");

        // pega o primeiro aluno
        Element aluno =
                (Element) lista.item(0);

        // pega a tag <nome>
        Element nome =
                (Element) aluno
                        .getElementsByTagName("nome")
                        .item(0);

        // altera o nome
        nome.setTextContent("Mariana");
        
		//prof add essa parte: 
		Element alunoRemover =
		    (Element) lista.item(1);
		
		doc.getDocumentElement()
		   .removeChild(alunoRemover);


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
                new StreamResult(arquivo);

        // salva no arquivo
        transformer.transform(source, result);

        System.out.println("XML atualizado com sucesso!");
    }
}
