/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoPessoas.funcionario.BancoDedadosFuncionario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**Cria o Banco de dados funcionario
 *
 * @author pedro
 */
public class CriarBD_Funcionario {
    
     public static void criarTab() {
        // SQLite connection string
        String url = "jdbc:sqlite:Funcionarios.db";
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS funcionarios (\n"
                + "id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "nomefunc text NOT NULL,\n"
                + "cpf text NOT NULL,\n"
                + "telefone text,\n"
                + "salario float NOT NULL,\n"
                + "jornadatrabalho integer,\n"
                + "funcao text NOT NULL,\n"
                + "endereco text\n"
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
