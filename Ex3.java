import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Ex3 {

    @SuppressWarnings("unchecked")
	public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Pessoa> pessoas = new ArrayList<>();

        int opcao;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar pessoa");
            System.out.println("2 - Listar pessoas");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Digite o nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Digite a idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();

                    Pessoa p = new Pessoa(nome, idade);

                    pessoas.add(p);

                    // SERIALIZAÇÃO
                    try {

                        ObjectOutputStream oos =
                                new ObjectOutputStream(
                                        new FileOutputStream("pessoas.ser")
                                );

                        oos.writeObject(pessoas);

                        oos.close();

                        System.out.println("Pessoa cadastrada com sucesso!");

                    } catch (IOException e) {
                        System.out.println("Erro ao salvar arquivo.");
                    }

                    break;

                case 2:

                    // DESSERIALIZAÇÃO
                    try {

                        ObjectInputStream ois =
                                new ObjectInputStream(
                                        new FileInputStream("pessoas.ser")
                                );

                        pessoas = (ArrayList<Pessoa>) ois.readObject();

                        ois.close();

                        System.out.println("\n===== LISTA DE PESSOAS =====");

                        for (Pessoa pessoa : pessoas) {
                            System.out.println(pessoa);
                        }

                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Erro ao ler arquivo.");
                    }

                    break;

                case 0:
                    System.out.println("Programa encerrado!");

                    break;

                default:
                    System.out.println("Opção inválida!");

            }

        } while (opcao != 0);

        sc.close();
    }
}