package GestaoPessoas.cliente.BancoDeDados;

import Departamentos.BancoDeDados.CriarBD_departamentos;
import GestaoPessoas.cliente.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**essa classe adiciona o cliente cadastrado no Banco de Dados
 *
 * @author pedro
 */
public class AdicionaCliente {
    /**Adiciona o cliente no BD
     * 
     * @param cliente o parametro é o cliente (vai ser criado na classe  CadastroCliente)
     */

public static void addcliente(Cliente cliente){
    
    
        //conexao.conectar();
        CriarBD_departamentos.criarTab();
        CriarConexao_cliente conexaocliente = new CriarConexao_cliente();
          conexaocliente.conectar();
            ResultSet resulset = null;
            Statement statement;
                     
            String query = "SELECT * FROM cliente";
            statement = conexaocliente.CriarStatement();
                     
                     try {
                       resulset = statement.executeQuery(query);
                       
                    } catch (SQLException e) {
                         System.err.println("Aconteceu algum erro: "+e);
                    }
                   String sql = "CREATE TABLE IF NOT EXISTS cliente (\n"
                + "id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "nome_cliente text NOT NULL,\n"
                + "cpf text,\n"
                + "telefone text,\n"
                + "endereco text,\n"
                + "rg integer NOT NULL\n"
                + ")";

                     String Insert = "INSERT INTO cliente("
                             + "nome_cliente,"
                             + "cpf,"
                             + "telefone,"
                             + "endereco,"
                             + "rg,"
                             + "pontos"
                          + ") VALUES(?,?,?,?,?,?)"
                          + ";";
                    
                      PreparedStatement preparedstatment = conexaocliente.criarPreparedStatement(Insert);
                      try {

          preparedstatment.setString(1,cliente.getNome());
          preparedstatment.setString(2, cliente.getCPF());
          preparedstatment.setString(3, cliente.getTelefone());
          preparedstatment.setString(4, cliente.getEndereco());
          preparedstatment.setString(5, cliente.getRg());
          preparedstatment.setInt(6, 0); //aqui está zero pq consta o numero de pontos no programa de vantagem.

            
            int resulado = preparedstatment.executeUpdate();
                  
            
            if(resulado == 1){
            
                    System.out.println("Clinte Cadastrado");
                }else{
                        System.err.println("Cliente não foi cadastrado, tente novamente!");
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
                      conexaocliente.desconectar();
    }

}
