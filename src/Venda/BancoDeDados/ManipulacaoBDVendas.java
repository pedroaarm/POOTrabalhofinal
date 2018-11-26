/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda.BancoDeDados;

import Departamentos.BancoDeDados.Criar_BD_departamentos;
import GestaoPessoas.cliente.BancoDeDados.ArrayDadosCliente;
import GestaoPessoas.cliente.BancoDeDados.Conexao_cliente;
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

          preparedstatment.setInt(1,cliente.getIdcliente());
          preparedstatment.setString(2, RetornaData.getDateTime());
          preparedstatment.setString(3, (String)ControleVendas.valortotal.toString());
          preparedstatment.setString(4, ControleVendas.retornaendereco());            
            int resulado = preparedstatment.executeUpdate();
                  
            
            if(resulado == 1){
            
                    System.out.println("Clinte Cadastrado");
                }else{
                        System.out.println("Cliente não foi cadastrado, tente novamente!");
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
