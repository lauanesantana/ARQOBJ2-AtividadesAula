import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Cliente {

    public void buscarClientePorId(int idCliente) {

        String url = "jdbc:mysql://localhost:3306/meu_banco";

        String sql = "SELECT nome, email FROM clientes WHERE id = ?";

        try (
                Connection conn = DriverManager.getConnection(url, "usuario", "senha");

                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {

            pstmt.setInt(1, idCliente);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                String nome = rs.getString("nome");
                String email = rs.getString("email");

                System.out.println("Nome: " + nome);
                System.out.println("Email: " + email);

            } else {

                System.out.println("Cliente não encontrado em nossa base de dados....");

            }

        } catch (Exception e) {

            System.out.println("Erro: " + e.getMessage());

        }
    }
}