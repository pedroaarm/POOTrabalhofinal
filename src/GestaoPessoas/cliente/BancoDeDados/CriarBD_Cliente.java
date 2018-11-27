package GestaoPessoas.cliente.BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Cria o BD cliente usado nesse programa
 * @author pedro
 */

public class CriarBD_Cliente {
/**
 *
 * @author pedro
 */

     public static void criarTab() {
        // SQLite connection string
        String url = "jdbc:sqlite:Clientes.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS cliente (\n"
                + "id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "nome_cliente text NOT NULL,\n"
                + "cpf text,\n"
                + "telefone text,\n"
                + "endereco text,\n"
                + "rg text NOT NULL,\n"
                + "pontos integer NOT NULL"
                + ")";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    
   
}
    
}
