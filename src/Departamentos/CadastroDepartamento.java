/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Departamentos;

import Departamentos.BancoDeDados.CriarBD_departamentos;
import Departamentos.BancoDeDados.CriarConexao_Departamento;
import TratamentodeErros.ValidarEntrada;
import Departamentos.BancoDeDados.ArraydeDados_Departamento;
import Utilitarios.ValidarNovoDepartamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *Essa classe serve para o cadastro de clientes no programa
 * @author pedro
 */
public class CadastroDepartamento {
 
       
        Departamento depart = new Departamento();
         static ValidarNovoDepartamento validarDP = new ValidarNovoDepartamento();
        static String Nome;
        Integer codigo;
        
        public static  void cadastrar(){
            System.out.println("");
            System.out.println("");
        System.out.println("\n\t***Cadastro de Departamento***");
        System.out.println("Insira o Nome do Departamento: ");
            System.out.print("nome ->  ");
        Nome = ValidarEntrada.validarString();

        
               
            CriarConexao_Departamento criarConexaoDP = new CriarConexao_Departamento();
            CriarBD_departamentos novoBD = new CriarBD_departamentos();
            CriarBD_departamentos.criarTab();
            criarConexaoDP.conectar();
           
            ResultSet resulset;
            Statement statement;
                     //cria uma string select dentro do sql
            String query = "SELECT * FROM Departamento";
            statement = criarConexaoDP.CriarStatement();
                     
                     try {
                       resulset = statement.executeQuery(query);
                       
                    } catch (SQLException e) {
                         System.err.println("Aconteceu algum erro: "+e);
                    }
                     //insert dentro do sqlite
                     String sqlInsert = "INSERT INTO departamento("
                          + "nomedp"
                          + ") VALUES(?)"
                          + ";";
                    
                      PreparedStatement preparedstatment = criarConexaoDP.criarPreparedStatement(sqlInsert);
                      try {
                          
                                preparedstatment.setString(1,Nome);
            
                     int resulado = preparedstatment.executeUpdate();
                  
            
            if(resulado == 1){
            
                }else{
                        System.out.println("Departamento não inserido, tente novamente!");
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
                      //se nao ocorrer nenhum erro.
                      System.out.println("Departamento Cadastrado!");
                      ArraydeDados_Departamento.inicializarArrayDepartamento(); // Atualizando o Array de Departamentos.
              criarConexaoDP.desconectar();
  
                
       
        }   
    }

    

