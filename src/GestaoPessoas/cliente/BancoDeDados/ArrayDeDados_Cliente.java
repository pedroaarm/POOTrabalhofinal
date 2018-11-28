/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoPessoas.cliente.BancoDeDados;

import Departamentos.BancoDeDados.ArraydeDados_Departamento;
import GestaoPessoas.cliente.Cliente;
import TratamentodeErros.ValidarEntrada;
import Venda.ControleVendas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class ArrayDeDados_Cliente {
   private static ArrayList<Cliente> arraycliente = new ArrayList<Cliente>();
    
    public static void InicializararrayCliente(){
        arraycliente.clear();
        
        CriarConexao_cliente conexaocliente = new CriarConexao_cliente();
        conexaocliente.conectar();
       
          ResultSet resultset;
           Statement statement;
        
          
          String select = "SELECT * FROM cliente;";

                  statement = conexaocliente.CriarStatement();
                    try {   

            resultset = statement.executeQuery(select);
                      while (resultset.next()) {
                          ResultSet s = resultset;
                          Cliente cliente = new Cliente (resultset.getInt("id"),resultset.getString("rg"),resultset.getString("nome_cliente"),resultset.getString("cpf"), resultset.getString("telefone"), resultset.getString("endereco"),resultset.getInt("pontos"));
                          arraycliente.add(cliente);
                      
                      }
                              statement.close();
                    conexaocliente.desconectar();
                    }catch (SQLException e){
                              System.err.println("Ocorreu algum erro: "+e);
                              }
                    conexaocliente.desconectar();    
    }
    /**Aqui é impresso os dados de todos os clientes cadastrados
     * 
     */
    
     public static void imprimirArrayCliente(){
        System.out.println("\n\t***Clientes Cadastrados***\n");
            for (Cliente cliente : arraycliente) {
            System.out.println("ID: "+cliente.getIdcliente()+"| nome: "+cliente.getNome()+" |Telefone: "+cliente.getTelefone()+" |CPF: "+cliente.getCPF()+" |Endereco: "+cliente.getEndereco());   
        }
    }
     /**Aqui é feito uma busca por cliente (pelo nome)
      * 
      * @param nome 
      */
    public static void buscarCliente(String nome){
    
     for (Cliente cliente : arraycliente) {
         if (cliente.getNome().contains(nome)){
        System.out.println("ID: "+cliente.getIdcliente()+"| nome: "+cliente.getNome()+" |Telefone: "+cliente.getTelefone()+" |CPF: "+cliente.getCPF()+" |Endereco: "+cliente.getEndereco());   
         }
      }    
    }
    /**Nesse metodo é feita uma busca por cliente pelo numero de ID, mostrando suas informações caso esse cliente seja encontrado
     * 
     * @param id 
     */
    public static void buscarClienteID (int id){
        for (Cliente cliente : arraycliente) {
            if(cliente.getIdcliente() == id){
            System.out.println("ID: "+cliente.getIdcliente()+"| nome: "+cliente.getNome()+" |Telefone: "+cliente.getTelefone()+" |CPF: "+cliente.getCPF()+" |Endereco: "+cliente.getEndereco()); 
            }           
        }     
    }
 
    
/**Esse metodo exclui um cliente pelo numero do id
 * 
 * @param id id do cliente que deseja excluir
 */
   
public static void excluircliente(int id){

           
       CriarConexao_cliente conexao = new CriarConexao_cliente(); 
         conexao.conectar();
       
          ResultSet resultset;
           Statement statement;
        
          
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
                                PreparedStatement prepared;
                                  String delete = "DELETE FROM cliente"
                                  + " WHERE id = ?;";
                                  try{
                                  prepared= conexao.criarPreparedStatement(delete);
                                  prepared.setInt(1, id);
                                  prepared.executeUpdate();
                                 ArrayDeDados_Cliente.InicializararrayCliente();
                              }catch(SQLException e){
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

/**Verifica se existe um cliente com determinado id
 * 
 * @param id o id do cliente que se deseja saber a existencia
 * @return retorna true caso o cliente exista ou false caso nao exista
 */

static public boolean verificarexistenciacliente(int id){
    
    for (Cliente cliente : arraycliente) {
        if(cliente.getIdcliente() == id){
            return true;
        }
        
    }
    
    return false;
    
}
/**Esse verifica a existencia e retorna um objeto cliente caso seja encontrado
 * 
 * @param id o id do cliente o qual se deseja buscar
 * @return caso encontre o cliente, sera retornado um objeto Cliente contendo as informações desse clietem, caso nao seja encontrado retorna null
 */

static public Cliente verificaexistenciaretornacliente(int id){
       for (Cliente cliente : arraycliente) {
        if(cliente.getIdcliente() == id){
            return cliente;
        }
        
    }
    
    return null;
}

/**Nesse metodo é feito a Edicão dos clientes
 * 
 * @param opcao opcao escolhida no menu de edicao (nome, endereco, etc)
 * @param id id do cliente para edicao
 */
public static void editarcliente (int opcao, int id){



                    boolean verificaid = verificarexistenciacliente(id);
                    
                    if(verificaid == true){
            CriarConexao_cliente conexao = new CriarConexao_cliente();
             conexao.conectar();

                PreparedStatement prepareStatement = null;
                ResultSet resultset;

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
                                ArraydeDados_Departamento.inicializarArrayDepartamento(); 
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
                                ArraydeDados_Departamento.inicializarArrayDepartamento(); 
                        }
                        
                    
                }
                 prepareStatement.close();
                }catch(SQLException e){
                        System.err.println("Ocorreu o seguinte erro: "+e);
                    }
                           //edicao RG
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
                                ArraydeDados_Departamento.inicializarArrayDepartamento(); 
                        }
                        
                    
                }
                 prepareStatement.close();
                }catch(SQLException e){
                        System.err.println("Ocorreu o seguinte erro: "+e);
                    }
                           //editar endereco
                    
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
                                ArraydeDados_Departamento.inicializarArrayDepartamento(); 
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
                                ArraydeDados_Departamento.inicializarArrayDepartamento(); 
                        }
                        
                    
                }
                 prepareStatement.close();
                }catch(SQLException e){
                        System.err.println("Ocorreu o seguinte erro: "+e);
                    }
                           
                    
                    
                    
                    
                }
                }
        
    }
/**Faz a retirada de pontos apos uma venda
 * Os pontos são calculados da seguinte forma: a cada 10 reais de compras, o cliente ganha 1 real de desconto em alguma compra futura
 * @param id id do cliente para retirada de pontos
 * @throws SQLException é uma indicação que o seu método pode lançar uma Exception e ela não é tratada no próprio método...
 */
public static void retirarpontos(int id) throws SQLException{
     CriarConexao_cliente conexao = new CriarConexao_cliente();
             conexao.conectar();

                PreparedStatement prepareStatement;
                ResultSet resultset;

                Statement statement;

                    
                String sql = "UPDATE cliente"
                + " SET "
                + " pontos = ?"
                + "WHERE id = ?";
                String select = "SELECT * FROM cliente;";
                
                    try{
                statement = conexao.CriarStatement();
                        
                resultset = statement.executeQuery(select);

                while (resultset.next()){


                        if(resultset.getInt("id") == id){
                            prepareStatement = conexao.criarPreparedStatement(sql);
                            int pontosatual = resultset.getInt("pontos") - ControleVendas.valortotal.intValue();
                                if(pontosatual >0){
                                prepareStatement.setInt(1,pontosatual); //primeiro numero = saldo (primeiro "?", o segundo é o valor
                                prepareStatement.setInt(2, id); // primeiro numero segunda? == segundo numero numero do id
                                prepareStatement.executeUpdate();

                                }else{
                                    prepareStatement.setInt(1,0); //primeiro numero = saldo (primeiro "?", o segundo é o valor
                                prepareStatement.setInt(2, id); // primeiro numero segunda? == segundo numero numero do id
                                prepareStatement.executeUpdate();

                        }
                    
                }}
                }catch(SQLException e){
                        System.err.println("Ocorreu o seguinte erro: "+e);
                    }

}


/**Esse metodo adicona pontos ao cliente ganhou
 * 
 * @param id
 * @param pontosganhos calculo feito automaticamente de quantos pontos o cliente ganhou, lembrando que ele ganha 1 ponto a cada 10 reais de compra
 */
public static void adicionarpontos(int id, int pontosganhos){
    CriarConexao_cliente conexao = new CriarConexao_cliente();
             conexao.conectar();

                PreparedStatement prepareStatement;
                ResultSet resultset;

                Statement statement;

                    
                String sql = "UPDATE cliente"
                + " SET "
                + " pontos = ?"
                + "WHERE id = ?";
                String select = "SELECT * FROM cliente;";
                
                    try{
                statement = conexao.CriarStatement();
                        
                resultset = statement.executeQuery(select);

                while (resultset.next()){


                        if(resultset.getInt("id") == id){
                            prepareStatement = conexao.criarPreparedStatement(sql);
                            int pontosatual = resultset.getInt("pontos")+pontosganhos;
                                if(pontosatual >0){
                                prepareStatement.setInt(1,pontosatual); //primeiro numero = saldo (primeiro "?", o segundo é o valor
                                prepareStatement.setInt(2, id); // primeiro numero segunda? == segundo numero numero do id
                                prepareStatement.executeUpdate();

                                }else{
                                    prepareStatement.setInt(1,0); //primeiro numero = saldo (primeiro "?", o segundo é o valor
                                prepareStatement.setInt(2, id); // primeiro numero segunda? == segundo numero numero do id
                                prepareStatement.executeUpdate();

                        }
                    
                }}
                }catch(SQLException e){
                        System.err.println("Ocorreu o seguinte erro: "+e);
                    }

}
    
    
}



