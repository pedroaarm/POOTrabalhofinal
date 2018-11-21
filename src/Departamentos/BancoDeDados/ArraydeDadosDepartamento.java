package Departamentos.BancoDeDados;


import Utilitarios.ValidarNovoDepartamento;
import TratamentodeErros.ValidarEntrada;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author pedro
 */

//Falta arrumar a questão de atualizar Departamento, ver isso se tiver tempo.
public class ArraydeDadosDepartamento {
   static public HashMap<Integer,String> Hashdepartamento = new HashMap<>();
    
   /**
    * Esse metodo inicialza o Array, seja no inicio do programa ou quando uma atualização é feita.
    * O programa trabalha com List, O trabalho com banco de dados só é feito quando é obrigado, então esse metódo é muito importante.
    * A inicialização do Array de Departamento é feito da seguinte forma: As tuplas da tabela Departamento são "varridas", a medida em isso vai acontecendo, são salvos os dados no HashMap
    * 
    */
    static public void inicializarArrayDepartamento(){
        Hashdepartamento.clear();
        //Criar_BD_departamentos.criarTab();
       Criar_Conexao_Departamento criarConex = new Criar_Conexao_Departamento();
         criarConex.conectar();
         
       
          ResultSet resultset = null;
           Statement statement = null;
        
          
          String sql = "SELECT * FROM Departamento;";

                  statement = criarConex.CriarStatement();
                    try {
                        
                  
            resultset = statement.executeQuery(sql);
                     
                        
                      while (resultset.next()) {
                          ResultSet s = resultset;
                      Hashdepartamento.put(resultset.getInt("id"), resultset.getString("nomedp"));
                      
                      }
                        System.out.println("Array Inicializado");
                              statement.close();
                    criarConex.desconectar();
                    }catch (SQLException e){
                              System.err.println("Ocorreu algum erro: "+e);
                              }
                    criarConex.desconectar();


    }
    /**
     * Aqui é feito a impressão de todos os departamentos, metodo simples, apenas percorre o HashMap e imprime os dados que estão adicionados nele
     * 
     */
    
   static public void imprimirTodosDepartamentos(){

       
        System.out.println("***DEPARTAMENTOS***");
        for (Map.Entry<Integer,String> hashdp : Hashdepartamento.entrySet()) {
             System.out.println("ID: "+hashdp.getKey()+"| Nome: "+hashdp.getValue());
         
}
	                        
		
	}
   /**
    * Esse metodo faz uma busca de um determinado Departamento e imprime, caso seja encontrado.
    * 
    * 
    * 
    * @param nome O nome do departamento que o Cliente deseja buscar.
    */
   static public void buscarDpNome(String nome){
          for (Map.Entry<Integer,String> hashdp : Hashdepartamento.entrySet()) {
              
                if (hashdp.getValue().equals(nome)){
                    System.out.println("***Departamento Encontrado***");
                 System.out.println("ID: "+hashdp.getKey()+"| Nome: "+hashdp.getValue());

                }
          }
   }
   
   static public boolean buscarDPId (int num){
       for (Map.Entry<Integer,String> hashdp : Hashdepartamento.entrySet()) {
              
                if (hashdp.getKey() == num){
                    return true;
                }
   }
       return false;
               }
       
       
       
   
   
   /**
    * 
    * Verifica existe um deperminado Departamento
    * @param nome é o nome do departamento que se deseja verificar a Existencia
    * @return O retorno é True: Caso o departamendo seja encontrado, ou falso, caso esse departamento não exista no Banco de Dados
    */
   static private boolean SaberseExisteDP(String nome){
       
       for (Map.Entry<Integer,String> hashdp : Hashdepartamento.entrySet()) {
              
                if (hashdp.getValue().equals(nome)){
                    return true;
                }
   }
       return false;
               }
   
   /**
    * Aqui acontece a Edição do nome do departamento. OBS: Não é possivel editar o ID.
    * @param nome o nome do departamento que o cliente deseja editar
    */
   static public void editardp(String nome){
     boolean Departamentoexiste= ValidarNovoDepartamento.validar(nome);//Aqui é veridicado se ja existe um departamento com esse nome
        if (Departamentoexiste == false){
            System.out.println("Digite o novo Departamento: ");
            String Novonome = ValidarEntrada.validarString();
            Criar_Conexao_Departamento conexao = new Criar_Conexao_Departamento();
             conexao.conectar();

                PreparedStatement prepareStatement = null;
                ResultSet resultset = null;

                Statement statement;


                String sql = "UPDATE departamento"
                + " SET "
                + " nomedp = ?"
                + "WHERE id = ?";
                String select = "SELECT * FROM departamento;";
                    try{
                statement = conexao.CriarStatement();
                        
                resultset = statement.executeQuery(select);
                // int codigo = 0;
                while (resultset.next()){
                   // codigo++;
                    System.out.println(resultset.getString("nomedp"));
                        if(resultset.getString("nomedp").equals(nome)){
                            prepareStatement = conexao.criarPreparedStatement(sql);
                              
                                prepareStatement.setString(1,nome); //primeiro numero = saldo (primeiro "?", o segundo é o valor
                                prepareStatement.setInt(2, resultset.getInt("id")); // primeiro numero segunda? == segundo numero numero do id
                                prepareStatement.executeUpdate();
                                //System.out.println(prepareStatement.executeUpdate());
                                ArraydeDadosDepartamento.inicializarArrayDepartamento();
                                                                  
                        }
                    
                }
                  // codigo++;
                prepareStatement.close();
                 // conexao.desconectar();
                    }catch(SQLException e){
                        System.err.println("Ocorreu o seguinte erro: "+e);
                    }
            
            
        }else{
            System.out.println("Esse departamento não existe");
        }
       
   }
   
   /**
    * 
    * Esse metodo faz a exclusão de um departamento.
    *
    * @param nome O nome do departamento que o cliente deseja excluir 
    */
   
   static public void excluirdepartamento (String nome){
       
       boolean ExisteDepartamento = ValidarNovoDepartamento.validar(nome);
       
       if(ExisteDepartamento == true){
   
      Criar_Conexao_Departamento conexao = new Criar_Conexao_Departamento(); 
         conexao.conectar();
       
          ResultSet resultset = null;
           Statement statement = null;
        
          
          String sql = "SELECT * FROM departamento;";
                 
                  statement = conexao.CriarStatement();
                  
                  int entrou=0;
                  
                   try {
                       
                   
                      int i=1;
            resultset = statement.executeQuery(sql);
                     
            
                      while (resultset.next()) {
                          ResultSet s = resultset;
                          
                            
                          if (resultset.getString("nomedp").equals(nome)){

                                  PreparedStatement prepared= null;
                                  String delete = "DELETE FROM departamento"
                                  + " WHERE id = ?;";
                                  
                         
                                  prepared= conexao.criarPreparedStatement(delete);
                                  prepared.setInt(1, resultset.getInt("id"));
                                  prepared.executeUpdate();
                          }
                      }
                                  
                              }catch(Exception e){
                                      System.out.println("erro "+e);
                                      
                              }
    
                   inicializarArrayDepartamento();
       }
       else{
           System.out.println("Esse Departamento não existe");
       }
}
}
                          
        

