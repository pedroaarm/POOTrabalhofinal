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
            int aux=0;
              
                       // public Vendas(int idproduto, int quantidade, BigDecimal precounitario,BigDecimal precototal, String nomeproduto)
                                  System.out.println("1");
                                  System.out.println("Compras a vista");
                      while (resultset.next()) {
                      if(resultset.getInt("idcliente") == id){
                         aux = 1;
                          System.out.println("Data: "+resultset.getString("data")+"Produto(s)"+resultset.getString("produtos")+"Valor: "+resultset.getString("valor"));
                      }
                      
                      }
                      if(aux == 0){
                          System.out.println("Nao consta nenhuma compra a vista");
                      }
                      aux =0;
                        System.out.println("Compras mistas");
                      resultset = statement.executeQuery(selecttab2);
                      while (resultset.next()) {
                      if(resultset.getInt("idcliente") == id){
                         aux = 1;
                          System.out.println("Data: "+resultset.getString("data")+"Valor total: "+resultset.getString("valortotal"));
                      }
                      }
                        if(aux == 0){
                          System.out.println("Nao consta nenhuma compra mista");
                      }
                      aux =0;
                        System.out.println("Compra parcelada/cartao");
                     resultset = statement.executeQuery(selecttab3);
                      while (resultset.next()) {
                      if(resultset.getInt("idcliente") == id){
                          aux = 1;
                          System.out.println("Data: "+resultset.getString("data")+"Valor total: "+resultset.getString("valor"));
                      }
                      }
                          if(aux == 0){
                          System.out.println("Nao consta nenhuma compra parcelada");
                      }
                      
                              statement.close();
                    conexaovendas.desconectar();
                    }catch (SQLException e){
                              System.err.println("Ocorreu algum erro: "+e);
                              }
        
        
        
        
    }
    
}
