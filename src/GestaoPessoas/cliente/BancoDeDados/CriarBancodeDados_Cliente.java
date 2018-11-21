/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoPessoas.cliente.BancoDeDados;

import GestaoPessoas.cliente.RG;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CriarBancodeDados_Cliente {
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
                + "rg integer NOT NULL\n"
                + ")";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            System.out.println("Tabela Criada com Sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    
   
}
    
}


    



    

