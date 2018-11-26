/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda.BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pedro
 */
public class CriaConexaoVendas {
      Connection c = null;
        public boolean conectar(){
                                                              
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:Vendas.db");
      } catch ( ClassNotFoundException | SQLException e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Banco de Dados aberto!!");
      return true;
   } 
        
        public boolean desconectar(){
        
            
            try{                  
                    c.close();    
                    System.out.println("Desconectou");
                 }catch(SQLException e){
                     System.err.println(e.getMessage());
                    return false;
                 }
                  return true;    
            } 
        
        public PreparedStatement criarPreparedStatement(String sql) {
                
                try{
                    return this.c.prepareStatement(sql);
                            
                } catch(SQLException e){
                    System.err.println("Erro"+e);
                    return null;
                }
                }
            
            public Statement criarStatement() {
                
                try{
                    return this.c.createStatement();
                            
                } catch(SQLException e){
                    return null;
                }
                }
            
            public Connection GetC(){        
               return this.c;
            }
            
            public Statement CriarStatement(){
                
                try {
                    
                    return this.c.createStatement();
                    
                } catch (SQLException e) {
                    return null;
                    
                }
            }
                
                public Connection getC(){
                 return this.c;   
                }
}
