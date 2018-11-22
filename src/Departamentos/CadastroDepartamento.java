/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Departamentos;

import Departamentos.BancoDeDados.Criar_BD_departamentos;
import Departamentos.BancoDeDados.Criar_Conexao_Departamento;
import TratamentodeErros.ValidarEntrada;
import Departamentos.BancoDeDados.ArraydeDadosDepartamento;
import Utilitarios.ValidarNovoDepartamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class CadastroDepartamento {
 
       
        Departamento depart = new Departamento();
         static ValidarNovoDepartamento validarDP = new ValidarNovoDepartamento();
        static String Nome;
        Integer codigo;
        
        public static  void cadastrar(){
            for (int i=0;i<20;i++){
                System.out.println("");
            }
        System.out.println("----Cadastro de Departamento----");
        System.out.println("Insira o Nome do Departamento: ");
        Nome = ValidarEntrada.validarString();
        boolean checarDP= validarDP.validar(Nome);
        
                if(checarDP = true){
            Criar_Conexao_Departamento criarConexaoDP = new Criar_Conexao_Departamento();
            Criar_BD_departamentos novoBD = new Criar_BD_departamentos();
            Criar_BD_departamentos.criarTab();
            criarConexaoDP.conectar();
           
            ResultSet resulset = null;
            Statement statement = null;
                     
            String query = "SELECT * FROM Departamento";
            statement = criarConexaoDP.CriarStatement();
                     
                     try {
                       resulset = statement.executeQuery(query);
                       
                    } catch (SQLException e) {
                         System.err.println("Aconteceu algum erro: "+e);
                    }
                     
                  
                    
                     String sqlInsert = "INSERT INTO departamento("
                          + "nomedp"
                          + ") VALUES(?)"
                          + ";";
                    
                      PreparedStatement preparedstatment = criarConexaoDP.criarPreparedStatement(sqlInsert);
                      try {
                          
          preparedstatment.setString(1,Nome);
            
            int resulado = preparedstatment.executeUpdate();
                  
            
            if(resulado == 1){
            
                    System.out.println("Departamento inserido");
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
                      ArraydeDadosDepartamento.inicializarArrayDepartamento(); // Atualizando o Array de Departamentos.
              criarConexaoDP.desconectar();
    }else{
                    System.out.println("Já existe um departamento cadastrado com esse nome!");
                }
                
       
        }   
    }

    

