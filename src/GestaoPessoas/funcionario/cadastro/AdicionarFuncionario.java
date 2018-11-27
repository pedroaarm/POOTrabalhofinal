/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoPessoas.funcionario.cadastro;

import Departamentos.BancoDeDados.CriarBD_departamentos;
import GestaoPessoas.cliente.BancoDeDados.ArrayDeDados_Cliente;
import GestaoPessoas.funcionario.BancoDedadosFuncionario.CriarConexao_Funcionario;
import GestaoPessoas.funcionario.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**Adiciona um funcionario ao banco de dados (usado na classe CadastroFuncionario.
 *
 * @author pedro
 */
public class AdicionarFuncionario {
    
    public static void addfuncionario(Funcionario funcionario ){
    
    
        //conexao.conectar();
        CriarBD_departamentos.criarTab();
        CriarConexao_Funcionario conexaofuncionario = new CriarConexao_Funcionario();
          conexaofuncionario.conectar();
            ResultSet resulset = null;
            Statement statement ;
                     
            String query = "SELECT * FROM funcionarios";
            statement = conexaofuncionario.CriarStatement();
                     
                     try {
                       resulset = statement.executeQuery(query);
                       
                    } catch (SQLException e) {
                         System.err.println("Aconteceu algum erro: "+e);
                    }
 
                     
                     String Insert = "INSERT INTO funcionarios("
                             + "nomefunc,"
                             + "cpf,"
                             + "telefone,"
                             + "salario,"
                             + "jornadatrabalho,"
                             + "endereco,"
                             + "funcao"
                          + ") VALUES(?,?,?,?,?,?,?)"
                          + ";";
                    
                      PreparedStatement preparedstatment = conexaofuncionario.criarPreparedStatement(Insert);
                      try {

          preparedstatment.setString(1, funcionario.getNome());
          preparedstatment.setString(2, funcionario.getCPF());
          preparedstatment.setString(3, funcionario.getTelefone());
          preparedstatment.setFloat(4, funcionario.getSalario());
          preparedstatment.setInt(5, funcionario.getJornadaTrabalho());
          preparedstatment.setString(6, funcionario.getEndereco());
          preparedstatment.setString(7, funcionario.getFuncao());

            
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
                      ArrayDeDados_Cliente.InicializararrayCliente();
                      conexaofuncionario.desconectar();
    }
    
    
}
