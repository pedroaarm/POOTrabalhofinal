/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda.BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pedro
 */
public class CriaBdVenda {
    
     public static void criarTab() {
        // SQLite connection string
        String url = "jdbc:sqlite:Vendas.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS vendas (\n"
                + "codigo integer PRIMARY KEY AUTOINCREMENT,\n"
                + "idcliente interger not null,\n"
                + "data text not null,\n"
                + "valor text not null\n,"
                + "produtos text not null\n"
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
