import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);
    private XMLManager xml = new XMLManager();

    public void exibirMenu() {

        int opcao;

        do {

            System.out.println("\n=========== TORNEIO DE TÊNIS ===========");
            System.out.println("[1 - Criar arquivo XML]");
            System.out.println("[2 - Adicionar jogo]");
            System.out.println("[3 - Listar jogos]");
            System.out.println("[4 - Alterar placar]");
            System.out.println("[5 - Alterar quadra]");
            System.out.println("[6 - Remover jogo]");
            System.out.println("[7 - Buscar jogo por ID]");
            System.out.println("[0 - Sair]");

            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao) {

                case 1:
                    xml.criarXML();
                    break;

                case 2:
                    xml.adicionarJogo();
                    break;

                case 3:
                    xml.listarJogos();
                    break;

                case 4:
                    xml.alterarPlacar();
                    break;

                case 6:
                    xml.removerJogo();
                    break;

                case 7:
                    xml.buscarPorId();
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while(opcao != 0);
    }
}