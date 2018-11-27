package Departamentos.BancoDeDados;


import TratamentodeErros.ValidarEntrada;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**Essa classe serve para a manipulacao do Array que guarda as informações dos departamentos
 *
 * @author pedro
 */

//Falta arrumar a questão de atualizar Departamento, ver isso se tiver tempo.
public class ArraydeDados_Departamento {
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
       CriarConexao_Departamento criarConex = new CriarConexao_Departamento();
         criarConex.conectar();
         
       
          ResultSet resultset;
           Statement statement;
        
          
          String sql = "SELECT * FROM Departamento;";

                  statement = criarConex.CriarStatement();
                    try {
                        
                  
            resultset = statement.executeQuery(sql);
                     
                        
                      while (resultset.next()) {
                          ResultSet s = resultset;
                      Hashdepartamento.put(resultset.getInt("id"), resultset.getString("nomedp"));
                      
                      }
        
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
   /**
    * 
    * @param id o id do departamento
    * @return retorna true caso encontre o departamento ou false caso não seja encontrado
    */
   
   static public boolean buscarDPId (int id){
       for (Map.Entry<Integer,String> hashdp : Hashdepartamento.entrySet()) {
              
                if (hashdp.getKey() == id){
                    System.out.println("ID: "+hashdp.getKey()+" | Nome: "+hashdp.getValue());
                    return true;
                }
                System.out.println("Departamento nao encontrado!");
   }
       
                    return false;
               }
        


 
   /**
    * Aqui acontece a Edição do id do departamento. 
    * 
    * @param id o id do departamento que o cliente deseja editar
    */
   static public void editardp(int id){
    
        
            System.out.println("Digite o novo Departamento: ");
            String Novonome = ValidarEntrada.validarString();
            CriarConexao_Departamento conexao = new CriarConexao_Departamento();
             conexao.conectar();

                PreparedStatement prepareStatement = null;
                ResultSet resultset;

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
                        if(resultset.getInt("id")==id){
                            prepareStatement = conexao.criarPreparedStatement(sql);
                              
                                prepareStatement.setString(1,Novonome); 
                                prepareStatement.setInt(2, resultset.getInt("id")); 
                                prepareStatement.executeUpdate();
                             
                                ArraydeDados_Departamento.inicializarArrayDepartamento();
                                                                  
                        }
                    
                }
                 
                prepareStatement.close();
               
                    }catch(SQLException e){
                        System.err.println("Ocorreu o seguinte erro: "+e);
                    }

        }

       
   
   
   /**
    * 
    * Esse metodo faz a exclusão de um departamento.
    *@param id parametro é o ID do departamento que deseja excluir
   
    */
   
   static public void excluirdepartamento (int id){
       
       
    
      CriarConexao_Departamento conexao = new CriarConexao_Departamento(); 
         conexao.conectar();
       
          ResultSet resultset;
           Statement statement;
        
          
          String sql = "SELECT * FROM departamento;";
                 
                  statement = conexao.CriarStatement();

                  
                   try {
                       
                   
                      int i=1;
            resultset = statement.executeQuery(sql);
                     
            
                      while (resultset.next()) {
                          ResultSet s = resultset;
                          
                            
                          if (resultset.getInt("id") == id){

                                  PreparedStatement prepared;
                                  // cria uma string com o comando delete dentro do sqlite
                                  String delete = "DELETE FROM departamento"
                                  + " WHERE id = ?;";
                                  
                         
                                  prepared= conexao.criarPreparedStatement(delete);
                                  prepared.setInt(1, resultset.getInt("id"));
                                  prepared.executeUpdate();
                          }
                      }
                                  
                              }catch(SQLException e){
                                      System.out.println("erro "+e);
                                      
                              }
                   System.out.println("Departamento excluido!");
                   inicializarArrayDepartamento();
       }
       
}

                          
        

