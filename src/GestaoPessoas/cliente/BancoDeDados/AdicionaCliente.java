package GestaoPessoas.cliente.BancoDeDados;

import Departamentos.BancoDeDados.Criar_BD_departamentos;
import GestaoPessoas.cliente.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pedro
 */
public class AdicionaCliente {

public static void addcliente(Cliente cliente){
    
    
        //conexao.conectar();
        Criar_BD_departamentos.criarTab();
        Conexao_cliente conexaocliente = new Conexao_cliente();
          conexaocliente.conectar();
            ResultSet resulset = null;
            Statement statement = null;
                     
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
                             + "rg"
                          + ") VALUES(?,?,?,?,?)"
                          + ";";
                    
                      PreparedStatement preparedstatment = conexaocliente.criarPreparedStatement(Insert);
                      try {

          preparedstatment.setString(1,cliente.getNome());
          preparedstatment.setString(2, cliente.getCPF());
          preparedstatment.setString(3, cliente.getTelefone());
          preparedstatment.setString(4, cliente.getEndereco());
          preparedstatment.setString(5, cliente.getRg());

            
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
                      ArrayDadosCliente.InicializararrayCliente();
                      conexaocliente.desconectar();
    }

}
