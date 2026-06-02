import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class XMLManager {

    Scanner sc = new Scanner(System.in);
    private final String ARQUIVO = "jogos.xml";

    public void criarXML() {

        try {

            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();

            DocumentBuilder builder =
                    factory.newDocumentBuilder();

            Document doc = builder.newDocument();

            Element torneio = doc.createElement("torneio");

            doc.appendChild(torneio);

            salvar(doc);

            System.out.println("XML criado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void salvar(Document doc) {

        try {

            TransformerFactory tf =
                    TransformerFactory.newInstance();

            Transformer transformer =
                    tf.newTransformer();

            DOMSource source =
                    new DOMSource(doc);

            StreamResult result =
                    new StreamResult(new File(ARQUIVO));

            transformer.transform(source, result);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public boolean idExiste(int id) {

        try {

            DocumentBuilder builder =
                    DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder();

            Document doc =
                    builder.parse(new File(ARQUIVO));

            NodeList jogos =
                    doc.getElementsByTagName("jogo");

            for(int i = 0; i < jogos.getLength(); i++) {

                Element jogo = (Element) jogos.item(i);

                int idAtual =
                        Integer.parseInt(
                        jogo.getAttribute("id"));

                if(idAtual == id)
                    return true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public void adicionarJogo() {

        try {

            DocumentBuilder builder =
                    DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder();

            Document doc =
                    builder.parse(new File(ARQUIVO));

            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            if(idExiste(id)) {

                System.out.println(
                "ERRO: Já existe um jogo com este ID.");

                return;
            }

            System.out.print("Jogador 1: ");
            String jogador1 = sc.nextLine();

            System.out.print("Jogador 2: ");
            String jogador2 = sc.nextLine();

            System.out.print("Placar: ");
            String placar = sc.nextLine();

            System.out.print("Quadra: ");
            String quadra = sc.nextLine();

            Element jogo = doc.createElement("jogo");
            jogo.setAttribute("id", String.valueOf(id));

            Element j1 = doc.createElement("jogador1");
            j1.setTextContent(jogador1);

            Element j2 = doc.createElement("jogador2");
            j2.setTextContent(jogador2);

            Element p = doc.createElement("placar");
            p.setTextContent(placar);

            Element q = doc.createElement("quadra");
            q.setTextContent(quadra);

            jogo.appendChild(j1);
            jogo.appendChild(j2);
            jogo.appendChild(p);
            jogo.appendChild(q);

            doc.getDocumentElement().appendChild(jogo);

            salvar(doc);

            System.out.println("Jogo adicionado!");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void listarJogos() {

        try {

            DocumentBuilder builder =
                    DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder();

            Document doc =
                    builder.parse(new File(ARQUIVO));

            NodeList jogos =
                    doc.getElementsByTagName("jogo");

            for(int i = 0; i < jogos.getLength(); i++) {

                Element jogo =
                        (Element) jogos.item(i);

                System.out.println("\nID: "
                        + jogo.getAttribute("id"));

                System.out.println("Jogador 1: "
                        + jogo.getElementsByTagName("jogador1")
                        .item(0).getTextContent());

                System.out.println("Jogador 2: "
                        + jogo.getElementsByTagName("jogador2")
                        .item(0).getTextContent());

                System.out.println("Placar: "
                        + jogo.getElementsByTagName("placar")
                        .item(0).getTextContent());

                System.out.println("Quadra: "
                        + jogo.getElementsByTagName("quadra")
                        .item(0).getTextContent());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void alterarPlacar() {

        try {

            DocumentBuilder builder =
                    DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder();

            Document doc =
                    builder.parse(new File(ARQUIVO));

            System.out.print("ID do jogo: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Novo placar: ");
            String novo = sc.nextLine();

            NodeList jogos =
                    doc.getElementsByTagName("jogo");

            for(int i = 0; i < jogos.getLength(); i++) {

                Element jogo =
                        (Element) jogos.item(i);

                if(Integer.parseInt(
                        jogo.getAttribute("id")) == id) {

                    jogo.getElementsByTagName("placar")
                        .item(0)
                        .setTextContent(novo);

                    salvar(doc);

                    System.out.println("Placar atualizado!");
                    return;
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void removerJogo() {

        try {

            DocumentBuilder builder =
                    DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder();

            Document doc =
                    builder.parse(new File(ARQUIVO));

            System.out.print("ID: ");
            int id = sc.nextInt();

            NodeList jogos =
                    doc.getElementsByTagName("jogo");

            for(int i = 0; i < jogos.getLength(); i++) {

                Element jogo =
                        (Element) jogos.item(i);

                if(Integer.parseInt(
                        jogo.getAttribute("id")) == id) {

                    jogo.getParentNode()
                        .removeChild(jogo);

                    salvar(doc);

                    System.out.println("Jogo removido!");

                    return;
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void buscarPorId() {

        try {

            DocumentBuilder builder =
                    DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder();

            Document doc =
                    builder.parse(new File(ARQUIVO));

            System.out.print("ID: ");
            int id = sc.nextInt();

            NodeList jogos =
                    doc.getElementsByTagName("jogo");

            for(int i = 0; i < jogos.getLength(); i++) {

                Element jogo =
                        (Element) jogos.item(i);

                if(Integer.parseInt(
                        jogo.getAttribute("id")) == id) {

                    System.out.println("Jogo encontrado!");

                    System.out.println(
                        jogo.getElementsByTagName("jogador1")
                        .item(0).getTextContent()
                        + " x " +
                        jogo.getElementsByTagName("jogador2")
                        .item(0).getTextContent());

                    return;
                }
            }

            System.out.println("Jogo não encontrado.");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}