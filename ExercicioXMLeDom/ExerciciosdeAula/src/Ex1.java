import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ex1{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        File arquivo = new File("alunos.xml");

        try {

            // Verifica se o arquivo existe
            if (!arquivo.exists()) {

                arquivo.createNewFile();

                PrintWriter pw = new PrintWriter(arquivo);

                pw.println("<alunos>");
                pw.println("</alunos>");

                pw.close();

                System.out.println("Arquivo XML criado com sucesso!");
            }

            int opcao;

            do {

                System.out.println("\n========= MENU =========");
                System.out.println("1 - Cadastrar aluno");
                System.out.println("2 - Exibir relatório");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");

                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {

                    case 1:

                        System.out.print("\nNome do aluno: ");
                        String nome = sc.nextLine();

                        System.out.print("Nota: ");
                        double nota = sc.nextDouble();
                        sc.nextLine();

                        cadastrarAluno(nome, nota, arquivo);

                        System.out.println("Aluno cadastrado com sucesso!");

                        break;

                    case 2:

                        exibirRelatorio(arquivo);

                        break;

                    case 0:

                        System.out.println("\nEncerrando o programa...");
                        break;

                    default:

                        System.out.println("\nOpção inválida!");
                }

            } while (opcao != 0);

        } catch (Exception e) {

            System.out.println("Erro: " + e.getMessage());
        }

        sc.close();
    }

    // Método para cadastrar aluno no XML
    public static void cadastrarAluno(String nome, double nota, File arquivo) {

        try {

            Scanner leitor = new Scanner(arquivo);

            StringBuilder conteudo = new StringBuilder();

            while (leitor.hasNextLine()) {

                String linha = leitor.nextLine();

                // Antes da tag final, adiciona novo aluno
                if (linha.equals("</alunos>")) {

                    conteudo.append("  <aluno>\n");
                    conteudo.append("    <nome>").append(nome).append("</nome>\n");
                    conteudo.append("    <nota>").append(nota).append("</nota>\n");
                    conteudo.append("  </aluno>\n");
                }

                conteudo.append(linha).append("\n");
            }

            leitor.close();

            FileWriter fw = new FileWriter(arquivo);
            fw.write(conteudo.toString());
            fw.close();

        } catch (Exception e) {

            System.out.println("Erro ao cadastrar aluno.");
        }
    }

    // Método para exibir relatório
    public static void exibirRelatorio(File arquivo) {

        try {

            Scanner leitor = new Scanner(arquivo);

            String nome = "";
            double nota;

            double soma = 0;
            int quantidade = 0;
            int aprovados = 0;

            double maiorNota = -1;
            String melhorAluno = "";

            System.out.println("\nLista de alunos:");

            while (leitor.hasNextLine()) {

                String linha = leitor.nextLine().trim();

                // Lê nome
                if (linha.startsWith("<nome>")) {

                    nome = linha.replace("<nome>", "")
                                .replace("</nome>", "");
                }

                // Lê nota
                if (linha.startsWith("<nota>")) {

                    String valorNota = linha.replace("<nota>", "")
                                            .replace("</nota>", "");

                    nota = Double.parseDouble(valorNota);

                    System.out.println("- " + nome + " | Nota: " + nota);

                    soma += nota;
                    quantidade++;

                    if (nota >= 7) {
                        aprovados++;
                    }

                    if (nota > maiorNota) {
                        maiorNota = nota;
                        melhorAluno = nome;
                    }
                }
            }

            leitor.close();

            if (quantidade > 0) {

                double media = soma / quantidade;

                System.out.printf("\nMédia das notas: %.1f\n", media);

                System.out.println("\nAluno com maior nota:");
                System.out.println(melhorAluno + " - " + maiorNota);

                System.out.println("\nQuantidade de alunos com nota maior ou igual a 7:");
                System.out.println(aprovados + " alunos");

            } else {

                System.out.println("Nenhum aluno cadastrado.");
            }

        } catch (Exception e) {

            System.out.println("Erro ao ler arquivo.");
        }
    }
}