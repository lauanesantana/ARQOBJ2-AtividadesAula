import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Produto {

    public void cadastrarProduto(String nome, double preco, int quantidade) {

        String url = "jdbc:mysql://localhost:3306/meu_banco";

        String sql = "INSERT INTO produtos (nome, preco, quantidade) VALUES (?, ?, ?)";

        try (
                Connection conn = DriverManager.getConnection(url, "usuario", "senha");

                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {

            pstmt.setString(1, nome);
            pstmt.setDouble(2, preco);
            pstmt.setInt(3, quantidade);

            pstmt.executeUpdate();

            System.out.println("Produto cadastrado com sucesso! :) ");

        } catch (Exception e) {

            System.out.println("Erro: " + e.getMessage());

        }
    }
}