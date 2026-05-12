import java.io.*;

public class Ex4 {

    public static void main(String[] args) {

        // criando produtos
        Produto p1 = new Produto("Notebook", 3500.00);
        Produto p2 = new Produto("Mouse", 120.00);

        // criando pedido
        Pedido pedido = new Pedido(101);

        // adicionando produtos
        pedido.adicionarProduto(p1);
        pedido.adicionarProduto(p2);

        // SERIALIZAÇÃO
        try {

            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            new FileOutputStream("pedido.ser")
                    );

            oos.writeObject(pedido);

            oos.close();

            System.out.println("Pedido salvo com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar pedido.");
        }

        // DESSERIALIZAÇÃO
        try {

            ObjectInputStream ois =
                    new ObjectInputStream(
                            new FileInputStream("pedido.ser")
                    );

            Pedido pedidoLido = (Pedido) ois.readObject();

            ois.close();

            System.out.println("\n===== PEDIDO =====");
            System.out.println(pedidoLido);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler pedido.");
        }
    }
}