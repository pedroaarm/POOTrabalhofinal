/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoPessoas.cliente.BancoDeDados;

import Departamentos.BancoDeDados.ArraydeDadosDepartamento;
import GestaoPessoas.cliente.Cliente;
import static Produtos.BancoDeDados.ArrayDeDadosProdutos.verificarexistencia;
import Produtos.BancoDeDados.Criar_Conexao_Produtos;
import TratamentodeErros.ValidarEntrada;
import Utilitarios.InicializarDados;
import java.sql.PreparedStatement;
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
                          Cliente cliente = new Cliente (resultset.getInt("id"),resultset.getString("rg"),resultset.getString("nome_cliente"),resultset.getString("cpf"), resultset.getString("telefone"), resultset.getString("endereco"),0);
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
    

public static void excluircliente(int id){

           
       Conexao_cliente conexao = new Conexao_cliente(); 
         conexao.conectar();
       
          ResultSet resultset = null;
           Statement statement = null;
        
          
          String sql = "SELECT * FROM cliente;";
                 
                  statement = conexao.CriarStatement();
                  
              
                   try {
  
            resultset = statement.executeQuery(sql);
                     
            
                      while (resultset.next()) {
                          ResultSet s = resultset;
                            if(resultset.getInt("id") == id){
                                System.out.println("Deseja mesmo excluir "+resultset.getString("nome_cliente")+" |ID: "+resultset.getInt("id")+"?");
                                System.out.println("1 - SIM | 2 - NAO");
                                int clienteexcluir = ValidarEntrada.validaropcao();
                                if (clienteexcluir == 1){
                                PreparedStatement prepared= null;
                                  String delete = "DELETE FROM cliente"
                                  + " WHERE id = ?;";
                                  try{
                                  prepared= conexao.criarPreparedStatement(delete);
                                  prepared.setInt(1, id);
                                  prepared.executeUpdate();
                                 ArrayDadosCliente.InicializararrayCliente();
                              }catch(Exception e){
                                      System.out.println("erro "+e);
                                      
                              }
                                }else{
                                    System.out.println("Operação cancelada");
                                }
                            }
                            
                      }
                       System.out.println("Cliente Excluido!");
                      
                   }catch(SQLException e){
                       System.err.println("Erro: "+e);
                   }
                   

}

static public boolean verificarexistenciacliente(int id){
    
    for (Cliente cliente : arraycliente) {
        if(cliente.getIdcliente() == id){
            return true;
        }
        
    }
    
    return false;
    
}

public static void editarcliente (int opcao, int id){



                    boolean verificaid = verificarexistenciacliente(id);
                    
                    if(verificaid == true){
            Conexao_cliente conexao = new Conexao_cliente();
             conexao.conectar();

                PreparedStatement prepareStatement = null;
                ResultSet resultset = null;

                Statement statement;

                if(opcao == 1){

                    
                    System.out.println("Digite o novo nome do cliente: ");
                    String nome = ValidarEntrada.validarString();
                    
                String sql = "UPDATE cliente"
                + " SET "
                + " nome_cliente = ?"
                + "WHERE id = ?";
                String select = "SELECT * FROM cliente;";
                
                    try{
                statement = conexao.CriarStatement();
                        
                resultset = statement.executeQuery(select);

                while (resultset.next()){


                        if(resultset.getInt("id") == id){
                            prepareStatement = conexao.criarPreparedStatement(sql);
                              
                                prepareStatement.setString(1,nome); //primeiro numero = saldo (primeiro "?", o segundo é o valor
                                prepareStatement.setInt(2, id); // primeiro numero segunda? == segundo numero numero do id
                                prepareStatement.executeUpdate();
                                ArraydeDadosDepartamento.inicializarArrayDepartamento(); 
                        }
                    
                }
                }catch(SQLException e){
                        System.err.println("Ocorreu o seguinte erro: "+e);
                    }
                    
                    
                }if(opcao == 2){
                    
                    System.out.println("Digite o Novo CPF: ");
                    String cpf = ValidarEntrada.validarString();
                    
                String sql = "UPDATE cliente"
                + " SET "
                + "cpf = ?"
                + "WHERE id = ?";
                String select = "SELECT * FROM cliente;";
                
                    try{
                statement = conexao.CriarStatement();
                        
                resultset = statement.executeQuery(select);

                while (resultset.next()){


                        if(resultset.getInt("id") == id){
                            prepareStatement = conexao.criarPreparedStatement(sql);
                              
                                prepareStatement.setString(1,cpf); //primeiro numero = saldo (primeiro "?", o segundo é o valor
                                prepareStatement.setInt(2, id); // primeiro numero segunda? == segundo numero numero do id
                                prepareStatement.executeUpdate();
                                ArraydeDadosDepartamento.inicializarArrayDepartamento(); 
                        }
                        
                    
                }
                 prepareStatement.close();
                }catch(SQLException e){
                        System.err.println("Ocorreu o seguinte erro: "+e);
                    }
                           
                    
                    
                }if(opcao == 3){
                    
                        
                    System.out.println("Digite o Novo RG: ");
                    String rg = ValidarEntrada.validarString();
                    
                String sql = "UPDATE cliente"
                + " SET "
                + "rg = ?"
                + "WHERE id = ?";
                String select = "SELECT * FROM cliente;";
                
                    try{
                statement = conexao.CriarStatement();
                        
                resultset = statement.executeQuery(select);

                while (resultset.next()){


                        if(resultset.getInt("id") == id){
                            prepareStatement = conexao.criarPreparedStatement(sql);
                              
                                prepareStatement.setString(1,rg); //primeiro numero = saldo (primeiro "?", o segundo é o valor
                                prepareStatement.setInt(2, id); // primeiro numero segunda? == segundo numero numero do id
                                prepareStatement.executeUpdate();
                                ArraydeDadosDepartamento.inicializarArrayDepartamento(); 
                        }
                        
                    
                }
                 prepareStatement.close();
                }catch(SQLException e){
                        System.err.println("Ocorreu o seguinte erro: "+e);
                    }
                           
                    
                    
                    
                    
                }if(opcao == 4){
                       
                        
                    System.out.println("Digite o Novo Endereco: ");
                    String endereco = ValidarEntrada.validarString();
                    
                String sql = "UPDATE cliente"
                + " SET "
                + "endereco = ?"
                + "WHERE id = ?";
                String select = "SELECT * FROM cliente;";
                
                    try{
                statement = conexao.CriarStatement();
                        
                resultset = statement.executeQuery(select);

                while (resultset.next()){


                        if(resultset.getInt("id") == id){
                            prepareStatement = conexao.criarPreparedStatement(sql);
                              
                                prepareStatement.setString(1,endereco); //primeiro numero = saldo (primeiro "?", o segundo é o valor
                                prepareStatement.setInt(2, id); // primeiro numero segunda? == segundo numero numero do id
                                prepareStatement.executeUpdate();
                                ArraydeDadosDepartamento.inicializarArrayDepartamento(); 
                        }
                        
                    
                }
                 prepareStatement.close();
                }catch(SQLException e){
                        System.err.println("Ocorreu o seguinte erro: "+e);
                    }
                           
  
                }
                if(opcao == 5){
                       
                    System.out.println("Digite o novo endereco: ");
                    String novotelefone = ValidarEntrada.validarString();
                    
                String sql = "UPDATE cliente"
                + " SET "
                + "telefone = ?"
                + "WHERE id = ?";
                String select = "SELECT * FROM cliente;";
                
                    try{
                statement = conexao.CriarStatement();
                        
                resultset = statement.executeQuery(select);

                while (resultset.next()){


                        if(resultset.getInt("id") == id){
                            prepareStatement = conexao.criarPreparedStatement(sql);
                              
                                prepareStatement.setString(1,novotelefone); //primeiro numero = saldo (primeiro "?", o segundo é o valor
                                prepareStatement.setInt(2, id); // primeiro numero segunda? == segundo numero numero do id
                                prepareStatement.executeUpdate();
                                ArraydeDadosDepartamento.inicializarArrayDepartamento(); 
                        }
                        
                    
                }
                 prepareStatement.close();
                }catch(SQLException e){
                        System.err.println("Ocorreu o seguinte erro: "+e);
                    }
                           
                    
                    
                    
                    
                }
                }
        
    }
}


