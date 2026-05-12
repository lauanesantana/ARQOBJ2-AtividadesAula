import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex1e2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        // escritor
        FileWriter writer = new FileWriter("nomes.txt");

        String nome;
        int contador = 0;
        int contador2 = 0;

        do {
            System.out.print("Digite um nome (0 para sair): ");
            nome = sc.nextLine();

            if (!nome.equals("0")) {
                writer.write(nome + "\n");
            }

        } while (!nome.equals("0"));

        // fecha o arquivo antes de ler
        writer.close();

        System.out.println("Obrigadaaaa... o arquivo foi criado com sucesso!");

        // abre o leitor APÓS escrever
        BufferedReader br = new BufferedReader(
                new FileReader("nomes.txt")
        );

        // conta todas as linhas
        while ((nome = br.readLine()) != null) {
            contador++;
        }

        br.close();

        // reabre para nova leitura
        br = new BufferedReader(
                new FileReader("nomes.txt")
        );

        // conta até encontrar !
        while ((nome = br.readLine()) != null) {

            if (nome.equals("!")) {
                break;
            }

            contador2++;
        }

        System.out.println("A quantidade de linhas até o caractere '!' foi de " + contador2);
        System.out.println("A quantidade total de linhas foi de " + contador);

        br.close();
        sc.close();
    }
}