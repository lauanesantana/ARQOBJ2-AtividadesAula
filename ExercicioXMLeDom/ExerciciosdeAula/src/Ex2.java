import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class Ex2 {

    public static void main(String[] args) {

        try {

            File arquivo = new File("livros.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(arquivo);

            doc.getDocumentElement().normalize();

            NodeList listaLivros = doc.getElementsByTagName("livro");

            double somaPrecos = 0;

            double maiorPreco = 0;
            String livroMaisCaro = "";

            ArrayList<String> autores = new ArrayList<>();

            // Percorre os livros
            for (int i = 0; i < listaLivros.getLength(); i++) {

                Node node = listaLivros.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element elemento = (Element) node;

                    String titulo = elemento.getElementsByTagName("titulo")
                                             .item(0)
                                             .getTextContent();

                    String autor = elemento.getElementsByTagName("autor")
                                           .item(0)
                                           .getTextContent();

                    double preco = Double.parseDouble(
                            elemento.getElementsByTagName("preco")
                                    .item(0)
                                    .getTextContent()
                    );

                    // Soma dos preços
                    somaPrecos += preco;

                    // Livro mais caro
                    if (preco > maiorPreco) {
                        maiorPreco = preco;
                        livroMaisCaro = titulo;
                    }

                    // Lista de autores sem repetir
                    if (!autores.contains(autor)) {
                        autores.add(autor);
                    }
                }
            }

            // Exibe soma total
            System.out.printf("Soma total dos preços: R$ %.2f\n", somaPrecos);

            // Exibe autores
            System.out.println("\nAutores disponíveis:");

            for (int i = 0; i < autores.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + autores.get(i));
            }

            // Escolha do usuário
            Scanner sc = new Scanner(System.in);

            System.out.print("\nEscolha o índice do autor: ");
            int opcao = sc.nextInt();

            String autorSelecionado = autores.get(opcao - 1);

            // Exibe livros do autor
            System.out.println("\nLivros do autor " + autorSelecionado + ":");

            for (int i = 0; i < listaLivros.getLength(); i++) {

                Node node = listaLivros.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element elemento = (Element) node;

                    String titulo = elemento.getElementsByTagName("titulo")
                                             .item(0)
                                             .getTextContent();

                    String autor = elemento.getElementsByTagName("autor")
                                           .item(0)
                                           .getTextContent();

                    if (autor.equals(autorSelecionado)) {
                        System.out.println("- " + titulo);
                    }
                }
            }

            // Livro mais caro
            System.out.println("\nLivro mais caro:");
            System.out.printf("%s - R$ %.2f\n", livroMaisCaro, maiorPreco);

            sc.close();

        } catch (Exception e) {

            System.out.println("Erro: " + e.getMessage());
        }
    }
}