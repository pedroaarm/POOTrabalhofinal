/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda;


import Venda.BancoDeDados.CriaConexaoVendas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class VendasPorcliente {
            ArrayList<Vendas> arrayvendasclientes = new ArrayList<>();
    public static void vendascliente(int id){

        
              CriaConexaoVendas conexaovendas = new CriaConexaoVendas();
         conexaovendas.conectar();
         
       
          ResultSet resultset = null;
           Statement statement = null;
        
          
          String select = "SELECT * FROM vendas;";
          String selecttab2 = "SELECT * FROM vendasmista;";
          String selecttab3 = "SELECT * FROM vendasparceladas;";

                  statement = conexaovendas.CriarStatement();
                    try {
                        
                  
            resultset = statement.executeQuery(select);
              
                       // public Vendas(int idproduto, int quantidade, BigDecimal precounitario,BigDecimal precototal, String nomeproduto)
                                  System.out.println("1");
                      while (resultset.next()) {
                      if(resultset.getInt("idcliente") == id){
                          System.out.println("Data: "+resultset.getString("data")+"Produto(s)"+resultset.getString("produtos")+"Valor: "+resultset.getString("valor"));
                      }
                      
                      }
;
                      resultset = statement.executeQuery(selecttab2);
                      while (resultset.next()) {
                      if(resultset.getInt("idcliente") == id){
                          System.out.println("Data: "+resultset.getString("data")+"Valor total: "+resultset.getString("valortotal"));
                      }
                      }

                     resultset = statement.executeQuery(selecttab3);
                      while (resultset.next()) {
                      if(resultset.getInt("idcliente") == id){
                          System.out.println("Data: "+resultset.getString("data")+"Valor total: "+resultset.getString("valor"));
                      }
                      }
                      
                              statement.close();
                    conexaovendas.desconectar();
                    }catch (SQLException e){
                              System.err.println("Ocorreu algum erro: "+e);
                              }
        
        
        
        
    }
    
}
