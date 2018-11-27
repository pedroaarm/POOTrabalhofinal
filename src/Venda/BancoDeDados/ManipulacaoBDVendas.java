/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda.BancoDeDados;

import Departamentos.BancoDeDados.CriarBD_departamentos;
import GestaoPessoas.cliente.BancoDeDados.ArrayDeDados_Cliente;
import GestaoPessoas.cliente.BancoDeDados.CriarConexao_cliente;
import GestaoPessoas.cliente.Cliente;
import Utilitarios.RetornaData;
import Venda.ControleVendas;
import Venda.Vendas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pedro
 */
public class ManipulacaoBDVendas {
    
    public static void adicionaraobanco(Cliente cliente){
        
                //conexao.conectar();

        CriaConexaoVendas conexaovendas = new CriaConexaoVendas();
          conexaovendas.conectar();
            ResultSet resulset = null;
            Statement statement = null;
                     
            String query = "SELECT * FROM vendas";
            statement = conexaovendas.CriarStatement();
                     
                     try {
                       resulset = statement.executeQuery(query);
                       
                    } catch (SQLException e) {
                         System.err.println("Aconteceu algum erro: "+e);
                    }

                     String Insert = "INSERT INTO vendas("
                             + "idcliente,"
                             + "data,"
                             + "valor,"
                             + "produtos"
                          + ") VALUES(?,?,?,?)"
                          + ";";
                    
                      PreparedStatement preparedstatment = conexaovendas.criarPreparedStatement(Insert);
                      try {
                          int resulado;
                          if(cliente != null){
          preparedstatment.setInt(1,cliente.getIdcliente());
          preparedstatment.setString(2, RetornaData.getDateTime());
          preparedstatment.setString(3, (String)ControleVendas.valortotal.toString());
          preparedstatment.setString(4, ControleVendas.retornaendereco());            
             resulado = preparedstatment.executeUpdate();
                          }else{
           preparedstatment.setInt(1,000);
          preparedstatment.setString(2, RetornaData.getDateTime());
          preparedstatment.setString(3, (String)ControleVendas.valortotal.toString());
          preparedstatment.setString(4, ControleVendas.retornaendereco());            
            resulado = preparedstatment.executeUpdate();
                          }
                  
            
            if(resulado == 1){
            
                    System.out.println("Sucesso!");
                }else{
                System.out.println("erro");
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
