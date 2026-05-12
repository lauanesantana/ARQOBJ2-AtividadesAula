import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable {

    private int codigo;
    private ArrayList<Produto> produtos;

    public Pedido(int codigo) {
        this.codigo = codigo;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto p) {
        produtos.add(p);
    }

    public double calcularTotal() {

        double total = 0;

        for (Produto p : produtos) {
            total += p.getPreco();
        }

        return total;
    }

    @Override
    public String toString() {

        String texto = "Código do Pedido: " + codigo + "\n";

        texto += "\nProdutos:\n";

        for (Produto p : produtos) {
            texto += p + "\n";
        }

        texto += "\nValor Total: R$ " + calcularTotal();

        return texto;
    }
}