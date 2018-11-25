/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produtos.BancoDeDados;


/**
 *
 * @author pedro
 */

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package Departamentos.BancoDeDados;*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author pedro
 */
public class CriarBancoProdutos {

     public static void criarTab() {
        // SQLite connection string
        String url = "jdbc:sqlite:Produtos.db";
      
             String sqlo = "CREATE TABLE IF NOT EXISTS departamento (\n"
                + "id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "nomedp text NOT NULL\n"
                + ")";

             
        String sql = "CREATE TABLE IF NOT EXISTS produto(\n"
                + "id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "nome_produto text NOT NULL,\n"
                + "marca_produto text NOT NULL,\n"
                + "departamento text NOT NULL,\n"
                + "quantidade integer NOT NULL,\n"
                + "preco_produto text NOT NULL,\n"
                + "descricao_produto text,\n"
                + "referencia_prod text NOT NULL\n"
                + ")";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            
            stmt.execute(sql);
            System.out.println("Tabela Criada com Sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    
   
}
    
}


    


    
