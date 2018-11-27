package Produtos.Cadastro;


import Departamentos.BancoDeDados.CriarBD_departamentos;
import Produtos.BancoDeDados.ArrayDeDados_Produtos;
import Produtos.BancoDeDados.CriarConexao_Produtos;
import Produtos.Produtos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**Acidiona um produto ao banco de dados
 *
 * @author pedro
 */
public class Adicionar_Produto {
    
    public static void addBanco(Produtos produto){
        CriarConexao_Produtos criarConexaoDP = new CriarConexao_Produtos();
        //conexao.conectar();
        String nome = produto.getNome();
        CriarBD_departamentos.criarTab();
            criarConexaoDP.conectar();
           
            ResultSet resulset = null;
            Statement statement = null;
                     
            String query = "SELECT * FROM produto";
            statement = criarConexaoDP.CriarStatement();
                     
                     try {
                       resulset = statement.executeQuery(query);
                       
                    } catch (SQLException e) {
                         System.err.println("Aconteceu algum erro: "+e);
                    }
                     

                     
                     
                     String sqlInsert = "INSERT INTO produto("
                             + "nome_produto,"
                             + "quantidade,"
                             + "preco_produto,"
                             + "descricao_produto,"
                             + "referencia_prod,"
                             + "marca_produto,"
                             + "departamento"
                          + ") VALUES(?,?,?,?,?,?,?)"
                          + ";";
                    
                      PreparedStatement preparedstatment = criarConexaoDP.criarPreparedStatement(sqlInsert);
                      try {

          preparedstatment.setString(1,produto.getNome());
          preparedstatment.setInt(2, produto.getQuantidadeestoque());
          preparedstatment.setBigDecimal(3, produto.getValor());
          preparedstatment.setString(4, produto.getDescricao());
          preparedstatment.setString(5, produto.getReferencia());
          preparedstatment.setString(6, produto.getMarca());
          preparedstatment.setInt(7, produto.getDepartamento());
            
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
                      ArrayDeDados_Produtos.inicializarArrayProdutos(); // Atualizando o Array de Departamentos.
              criarConexaoDP.desconectar();
    }
    
}
