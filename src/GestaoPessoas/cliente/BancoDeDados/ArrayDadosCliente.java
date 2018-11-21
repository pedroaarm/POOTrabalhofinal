/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoPessoas.cliente.BancoDeDados;

import GestaoPessoas.cliente.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class ArrayDadosCliente {
   private static ArrayList<Cliente> arraycliente = new ArrayList();
    
    public static void InicializararrayCliente(){
        arraycliente.clear();
        
        Conexao_cliente conexaocliente = new Conexao_cliente();
        conexaocliente.conectar();
       
          ResultSet resultset = null;
           Statement statement = null;
        
          
          String select = "SELECT * FROM cliente;";

                  statement = conexaocliente.CriarStatement();
                    try {   

            resultset = statement.executeQuery(select);
                      while (resultset.next()) {
                          ResultSet s = resultset;
         // public Cliente(int idcliente, String rg, String nome, String CPF, String telefone, String endereco);
                          Cliente cliente = new Cliente (resultset.getInt("id"),resultset.getString("rg"),resultset.getString("nome_cliente"),resultset.getString("cpf"), resultset.getString("telefone"), resultset.getString("endereco"));
                          arraycliente.add(cliente);
                      
                      }
                        System.out.println("Array Inicializado");
                              statement.close();
                    conexaocliente.desconectar();
                    }catch (SQLException e){
                              System.err.println("Ocorreu algum erro: "+e);
                              }
                    conexaocliente.desconectar();    
    }
    
     public static void imprimirArrayCliente(){
        System.out.println("---Produtos Cadastrados---");
            for (Cliente cliente : arraycliente) {
            System.out.println("ID: "+cliente.getIdcliente()+"| nome: "+cliente.getNome()+" |Telefone: "+cliente.getTelefone()+" |CPF: "+cliente.getCPF()+" |Endereco: "+cliente.getEndereco());   
        }
    }
    public static void buscarCliente(String nome){
    
     for (Cliente cliente : arraycliente) {
         if (cliente.getNome().contains(nome)){
        System.out.println("ID: "+cliente.getIdcliente()+"| nome: "+cliente.getNome()+" |Telefone: "+cliente.getTelefone()+" |CPF: "+cliente.getCPF()+" |Endereco: "+cliente.getEndereco());   
         }
     }
}    
        
    }
