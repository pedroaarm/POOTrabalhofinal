/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoPessoas.funcionario.BancoDedadosFuncionario;


import Departamentos.BancoDeDados.ArraydeDadosDepartamento;
import GestaoPessoas.cliente.BancoDeDados.ArrayDadosCliente;
import GestaoPessoas.cliente.BancoDeDados.Conexao_cliente;
import GestaoPessoas.cliente.Cliente;
import GestaoPessoas.funcionario.Funcionario;
import TratamentodeErros.ValidarEntrada;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public abstract class ArrayFuncionario {
   private static ArrayList<Funcionario> arrayfuncionario = new ArrayList<>();
    
     static public void inicializarArrayDepartamento(){
         arrayfuncionario.clear();
         
         ConexaoFuncionario conexaofuncionario = new ConexaoFuncionario();
         conexaofuncionario.conectar();
         
       
          ResultSet resultset = null;
           Statement statement = null;
        
          
          String select = "SELECT * FROM funcionarios;";

                  statement = conexaofuncionario.CriarStatement();
                    try {
                        
                  
            resultset = statement.executeQuery(select);
              
                      
                                  
                      while (resultset.next()) {
                          ResultSet s = resultset;
                      Funcionario funcionario = new Funcionario(resultset.getFloat("salario"), resultset.getInt("jornadatrabalho"), resultset.getInt("id"), resultset.getString("nomefunc"), 
                              resultset.getString("cpf"), resultset.getString("telefone"), resultset.getString("endereco"), resultset.getString("funcao"));
                     arrayfuncionario.add(funcionario);
                      
                      }
                        System.out.println("Array Inicializado");
                              statement.close();
                    conexaofuncionario.desconectar();
                    }catch (SQLException e){
                              System.err.println("Ocorreu algum erro: "+e);
                              }
                   conexaofuncionario.desconectar();
     }
     
          public static void imprimirArrayCliente(){
        System.out.println("---Produtos Cadastrados---");
              for (Funcionario funcionario : arrayfuncionario) {
            System.out.println("ID: "+funcionario.getIDfuncionario()+"| nome: "+funcionario.getNome()+" |Funcao: "+funcionario.getFuncao()+"|Salario: "+funcionario.getSalario()+" |Jornada: "+funcionario.getJornadaTrabalho()+" |Telefone: "+funcionario.getTelefone()+" |CPF: "+funcionario.getCPF()+" |Endereco: "+funcionario.getEndereco());   
        
              }
    }
          
              public static void buscarFuncionario(int id){
    
       for (Funcionario funcionario : arrayfuncionario) {
                      
                  
         if (funcionario.getIDfuncionario() == id){
       System.out.println("ID: "+funcionario.getIDfuncionario()+"| nome: "+funcionario.getNome()+" |Funcao: "+funcionario.getFuncao()+"|Salario: "+funcionario.getSalario()+" |Jornada: "+funcionario.getJornadaTrabalho()+" |Telefone: "+funcionario.getTelefone()+" |CPF: "+funcionario.getCPF()+" |Endereco: "+funcionario.getEndereco());   
        
         }
     }    
     }
    public static boolean saberseexistefuncionario(int id){
        
        for (Funcionario funcionario : arrayfuncionario) {
            if(funcionario.getIDfuncionario() == id){
                return true;
            }
        }
        return false;
        
        
    }
    public static void excluirfuncionario(int id){

           
       ConexaoFuncionario conexao = new ConexaoFuncionario(); 
         conexao.conectar();
       
          ResultSet resultset = null;
           Statement statement = null;
        
          
          String sql = "SELECT * FROM funcionarios;";
                 
                  statement = conexao.CriarStatement();
                  
              
                   try {
  
            resultset = statement.executeQuery(sql);
                     
            
                      while (resultset.next()) {
                          ResultSet s = resultset;
                            if(resultset.getInt("id") == id){
                                System.out.println("Deseja mesmo excluir "+resultset.getString("nomefunc")+" |ID: "+resultset.getInt("id")+"?");
                                System.out.println("1 - SIM | 2 - NAO");
                                int excluirfuncionario = ValidarEntrada.validaropcao();
                                if (excluirfuncionario == 1){
                                PreparedStatement prepared= null;
                                  String delete = "DELETE FROM funcionarios"
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
                       System.out.println("Funcionario Excluido!");
                      
                   }catch(SQLException e){
                       System.err.println("Erro: "+e);
                   }
                   

}
    
    private static boolean verificarexistencia(int id){
        
        for (Funcionario funcionario : arrayfuncionario) {
            if (funcionario.getIDfuncionario() == id){
                return true;
            }
            
        }
        return false;
        
    }
    
    public static void editarfuncionaro(int opcao, int id){

        boolean verifica = verificarexistencia(id);
        System.out.println(verifica);
         if(verifica == true){
            ConexaoFuncionario conexao = new ConexaoFuncionario();
             conexao.conectar();

                PreparedStatement prepareStatement = null;
                ResultSet resultset = null;

                Statement statement;

                if(opcao == 1){

                    
                    System.out.println("Digite o novo nome do funcionario: ");
                    String nome = ValidarEntrada.validarString();
                    
                String sql = "UPDATE funcionarios"
                + " SET "
                + " nomefunc = ?"
                + "WHERE id = ?";
                String select = "SELECT * FROM funcionarios;";
                
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
        
        
                    
                    System.out.println("Digite o novo novo CPF: ");
                    String cpf = ValidarEntrada.validarString();
                    
                String sql = "UPDATE funcionarios"
                + " SET "
                + " cpf = ?"
                + "WHERE id = ?";
                String select = "SELECT * FROM funcionarios;";
                
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
                }catch(SQLException e){
                        System.err.println("Ocorreu o seguinte erro: "+e);
                }
        
    }if(opcao == 4){
        
          
        
                    
                    System.out.println("Digite o novo novo CPF: ");
                    String cpf = ValidarEntrada.validarString();
                    
                String sql = "UPDATE funcionarios"
                + " SET "
                + " cpf = ?"
                + "WHERE id = ?";
                String select = "SELECT * FROM funcionarios;";
                
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
                }catch(SQLException e){
                        System.err.println("Ocorreu o seguinte erro: "+e);
                }
        
        
    }
    if (opcao == 3){
        
       
            System.out.println("Digite o novo salario: ");
              float novosalario = ValidarEntrada.validarFloat();
                    
                String sql = "UPDATE funcionarios"
                + " SET "
                + "salario = ?"
                + "WHERE id = ?";
                String select = "SELECT * FROM funcionarios;";
                
                    try{
                statement = conexao.CriarStatement();
                        
                resultset = statement.executeQuery(select);

                while (resultset.next()){


                        if(resultset.getInt("id") == id){
                            prepareStatement = conexao.criarPreparedStatement(sql);
                              
                                prepareStatement.setFloat(1,novosalario); //primeiro numero = saldo (primeiro "?", o segundo é o valor
                                prepareStatement.setInt(2, id); // primeiro numero segunda? == segundo numero numero do id
                                prepareStatement.executeUpdate();
                                ArraydeDadosDepartamento.inicializarArrayDepartamento(); 
                        }
                    
                }
                }catch(SQLException e){
                        System.err.println("Ocorreu o seguinte erro: "+e);
                }
    }
    if(opcao == 5){
        
          
        
                    
                    System.out.println("Digite o novo endereco: ");
                    String endereco = ValidarEntrada.validarString();
                    
                String sql = "UPDATE funcionarios"
                + " SET "
                + " endereco = ?"
                + "WHERE id = ?";
                String select = "SELECT * FROM funcionarios;";
                
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
                }catch(SQLException e){
                        System.err.println("Ocorreu o seguinte erro: "+e);
                }
        
    }
    if(opcao == 6){
          
                    System.out.println("Digite o novo novo telefone: ");
                    String telefone = ValidarEntrada.validarString();
                    
                String sql = "UPDATE funcionarios"
                + " SET "
                + "telefone = ?"
                + "WHERE id = ?";
                String select = "SELECT * FROM funcionarios;";
                
                    try{
                statement = conexao.CriarStatement();
                        
                resultset = statement.executeQuery(select);

                while (resultset.next()){


                        if(resultset.getInt("id") == id){
                            prepareStatement = conexao.criarPreparedStatement(sql);
                              
                                prepareStatement.setString(1,telefone); //primeiro numero = saldo (primeiro "?", o segundo é o valor
                                prepareStatement.setInt(2, id); // primeiro numero segunda? == segundo numero numero do id
                                prepareStatement.executeUpdate();
                                ArraydeDadosDepartamento.inicializarArrayDepartamento(); 
                        }
                    
                }
                }catch(SQLException e){
                        System.err.println("Ocorreu o seguinte erro: "+e);
                }
    }
}
    }
    
    public static Funcionario retornafuncionario(int id){
    
        for (Funcionario funcionario : arrayfuncionario) {
            
        if(funcionario.getIDfuncionario() == id){
            return funcionario;
        }
        
    }
    return null;
}
}
