/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Departamentos.BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Cria um bando de dados para o departamento, tendo com o nome do arquivo .bd "Departamentos"
 * 
 * @author pedro
 */

public class CriarBD_departamentos {
/**
 *esse metodo cria a tabela usada no programa
 * @author pedro
 */

     public static void criarTab() {
        // SQLite connection string
        String url = "jdbc:sqlite:Departamento.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS departamento (\n"
                + "id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "nomedp text NOT NULL\n"
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


    

