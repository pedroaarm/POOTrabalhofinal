/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda.BancoDeDados;

import GestaoPessoas.cliente.Cliente;
import Utilitarios.RetornaData;
import Venda.ControleVendas;
import Venda.VendaParcelada;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**Cria o Banco de dados de compras parceladas
 *
 * @author pedro
 */
public class BDTabelaComprasParceladas {
    
      public static void criarTab() {
        // SQLite connection string
        String url = "jdbc:sqlite:Vendas.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS vendasparceladas(\n"
                + "codigo integer PRIMARY KEY AUTOINCREMENT,\n"
                + "idcliente interger not null,\n"
                + "data text not null,\n"
                + "valor text not null\n,"
                + "quantidadeparcelas interger not null,\n"
                + "valorparcelado text not null\n"
                + ")";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    
}
      public static void adicionarcompraparcelada(Cliente cliente, VendaParcelada vendaparcelada){
           CriaConexaoVendas conexaovendas = new CriaConexaoVendas();
          conexaovendas.conectar();
            ResultSet resulset = null;
            Statement statement = null;
                     
            String query = "SELECT * FROM vendasparceladas";
            statement = conexaovendas.CriarStatement();
                     
                     try {
                       resulset = statement.executeQuery(query);
                       
                    } catch (SQLException e) {
                         System.err.println("Aconteceu algum erro: "+e);
                    }

                     String Insert = "INSERT INTO vendasparceladas("
                             + "idcliente,"
                             + "data,"
                             + "valor,"
                             + "quantidadeparcelas,"
                             + "valorparcelado"
                          + ") VALUES(?,?,?,?,?)"
                          + ";";
                    
                      PreparedStatement preparedstatment = conexaovendas.criarPreparedStatement(Insert);
                      try {
                          int resulado;
              
          preparedstatment.setInt(1,cliente.getIdcliente());
          preparedstatment.setString(2, RetornaData.getDateTime());
          preparedstatment.setString(3, (String)ControleVendas.valortotal.toString());
          preparedstatment.setInt(4, vendaparcelada.getParcelas());  
          preparedstatment.setString(5, vendaparcelada.toString());
             resulado = preparedstatment.executeUpdate();
                 
                       
                  
            
            if(resulado == 1){
            
                }else{
                        }
        } catch (SQLException e) {
                    System.out.println(e);
        }finally{
                    
                    if (preparedstatment != null){
                        try {
                            
                            preparedstatment.close();
                            
                        } catch (SQLException ex) {
                              System.err.println("Aconteceu algum erro: "+ex);

                        }
                    }  
                }  
                     
                      conexaovendas.desconectar();
        
    }
          
      }
    
    

