package Produtos.BancoDeDados;


import Departamentos.BancoDeDados.ArraydeDados_Departamento;
import Produtos.Produtos;
import TratamentodeErros.ValidarEntrada;
import Venda.Vendas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**Classe responsavel por manipular operacoes no array de produtos 
 *
 * @author pedro
 */
public abstract class ArrayDeDados_Produtos  {
    
    public static ArrayList<Produtos> arrayprodutos = new ArrayList<Produtos>();
    
    public static void inicializarArrayProdutos(){
        arrayprodutos.clear();
        
          CriarConexao_Produtos criarConex = new CriarConexao_Produtos();
         criarConex.conectar();
         
       
          ResultSet resultset;
           Statement statement;
        
          
          String sql = "SELECT * FROM produto;";

                  statement = criarConex.CriarStatement();
                    try {
                        

            resultset = statement.executeQuery(sql);
                      while (resultset.next()) {
                          ResultSet s = resultset;
                         Produtos produto = new Produtos (resultset.getString("nome_produto"),resultset.getString("descricao_produto"),resultset.getInt("quantidade"),resultset.getBigDecimal("preco_produto"),resultset.getInt("id"),resultset.getString("referencia_prod"), resultset.getString("marca_produto"),resultset.getInt("departamento"));
                          arrayprodutos.add(produto);                      
                      }
                              statement.close();
                    criarConex.desconectar();
                    }catch (SQLException e){
                              System.err.println("Ocorreu algum erro: "+e);
                              }
                    criarConex.desconectar();


    }
    
    /**busta um produto
     * 
     * @param id 
     */
   static public void buscarProdutoNome(int id){
          for (Produtos arrayproduto : arrayprodutos) {
             
                if (arrayproduto.getId() == id){
                    System.out.println("***Produto Encontrado***");
            System.out.println("ID: "+arrayproduto.getId()+"| nome: "+arrayproduto.getNome()+" |Marca: "+ arrayproduto.getReferencia()+" |Departamento: "+arrayproduto.getDepartamento()+"|Referencia: "+arrayproduto.getReferencia()+ "| Preço: "+arrayproduto.getValor()+"| Quantidade em Estoque: "+arrayproduto.getQuantidadeestoque());   

                }
          }
   }
   static public boolean verificarexistencia(int id){
       
        for (Produtos arrayproduto : arrayprodutos) {
             
                if (arrayproduto.getId() == id){
                    return true;

                }
          }
       return false;
       
   }
   public static void exluirProduto(int id){
       
       CriarConexao_Produtos conexao = new CriarConexao_Produtos(); 
         conexao.conectar();
       
          ResultSet resultset = null;
           Statement statement = null;
        
          
          String sql = "SELECT * FROM produto;";
                 
                  statement = conexao.CriarStatement();
                  
                  int entrou=0;
                   try {
                      int i=1;
            resultset = statement.executeQuery(sql);
                     
            
                      while (resultset.next()) {
                          ResultSet s = resultset;
                            if(resultset.getInt("id") == id){
                                System.out.println("Deseja mesmo excluir "+resultset.getString("nome_produto")+" |ID: "+resultset.getInt("id"));
                                System.out.println("1 - SIM | 2 - NAO");
                                int opexcluir;
                               do{
                                   opexcluir = ValidarEntrada.validaropcao();
                                if (opexcluir == 1){
                                PreparedStatement prepared= null;
                                  String delete = "DELETE FROM produto"
                                  + " WHERE id = ?;";
                                  try{
                                  prepared= conexao.criarPreparedStatement(delete);
                                  prepared.setInt(1, id);
                                  prepared.executeUpdate();
                                 ArrayDeDados_Produtos.inicializarArrayProdutos();
                              }catch(SQLException e){
                                      System.out.println("erro "+e);
                                      
                              }
                                   System.out.println("Produto Excluido!");
                                }if(opexcluir == 2){
                                    System.out.println("Operação cancelada");
                                }
                                if(opexcluir > 3 || opexcluir <1){
                                    System.out.println("Opcao invalida!");
                                }
                            }while(opexcluir !=2 || opexcluir != 1);
                               }
                      }
                      
                   }catch(SQLException e){
                       System.err.println("Erro: "+e);
                   }
       
       
       
       
       
   }
   
    /**Imprime todos os produtos
     * 
     */
   public static void imprimirArryProdutos(){
        System.out.println("\n\t***Produtos Cadastrados***\n");
        int i=0;
        for (Produtos arrayproduto : arrayprodutos) {
            System.out.println("ID: "+arrayproduto.getId()+"| nome: "+arrayproduto.getNome()+" |Marca: "+ arrayproduto.getReferencia()+" |Departamento: "+arrayproduto.getDepartamento()+"|Referencia: "+arrayproduto.getReferencia()+ "| Preço: "+arrayproduto.getValor()+"| Quantidade em Estoque: "+arrayproduto.getQuantidadeestoque());   
            i = 1;
        }
        if(i==0){
            System.out.println("Nao existe produto cadastrado");
        }
        
    }
   
   public static void subtrairestoque(int id, Vendas vendas){
       
        CriarConexao_Produtos conexao = new CriarConexao_Produtos();
             conexao.conectar();

                PreparedStatement prepareStatement;
                ResultSet resultset;

                Statement statement;
                 String sql = "UPDATE produto"
                + " SET "
                + " quantidade = ?"
                + "WHERE id = ?";
                String select = "SELECT * FROM produto;";
                
                  try{
                statement = conexao.CriarStatement();
                        
                resultset = statement.executeQuery(select);

                while (resultset.next()){


                        if(resultset.getInt("id") == id){
                            prepareStatement = conexao.criarPreparedStatement(sql);
                              int quantidadeatual = resultset.getInt("quantidade") - vendas.getQuantidade();
                                prepareStatement.setInt(1,quantidadeatual); //primeiro numero = saldo (primeiro "?", o segundo é o valor
                                prepareStatement.setInt(2, id); // primeiro numero segunda? == segundo numero numero do id
                                prepareStatement.executeUpdate();
                                inicializarArrayProdutos();
                        }
                    
                }
                }catch(SQLException e){
                        System.err.println("Ocorreu o seguinte erro: "+e);
                    }
       
       
       
   }
   

    static public void editarProduto(int opcao, int id){
        

                    boolean verificaid = verificarexistencia(id);
                    
                    if(verificaid == true){
            CriarConexao_Produtos conexao = new CriarConexao_Produtos();
             conexao.conectar();

                PreparedStatement prepareStatement = null;
                ResultSet resultset = null;

                Statement statement;

                if(opcao == 1){

                    
                    System.out.println("Digite um novo nome para o produto: ");
                    String nome = ValidarEntrada.validarString();
                    
                String sql = "UPDATE produto"
                + " SET "
                + " nome_produto = ?"
                + "WHERE id = ?";
                String select = "SELECT * FROM produto;";
                
                    try{
                statement = conexao.CriarStatement();
                        
                resultset = statement.executeQuery(select);

                while (resultset.next()){


                        if(resultset.getString("nome_produto").equalsIgnoreCase(nome)){
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
                    System.out.println("Digite a nova quantidade no estoque: ");
                    int estoque = ValidarEntrada.validarInteiro();
                    
                String sql = "UPDATE produto"
                + " SET "
                + "quantidade = ?"
                + "WHERE id = ?";
                String select = "SELECT * FROM produto;";
                
                    try{
                statement = conexao.CriarStatement();
                        
                resultset = statement.executeQuery(select);

                while (resultset.next()){


                        if(resultset.getInt("id") == id){
                            prepareStatement = conexao.criarPreparedStatement(sql);
                              
                                prepareStatement.setInt(1,estoque); //primeiro numero = saldo (primeiro "?", o segundo é o valor
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
                    if(opcao == 3){
                         System.out.println("Digite o novo preco: ");
                    float novopreco = ValidarEntrada.validarFloat();
                    
                String sql = "UPDATE produto"
                + " SET "
                + "preco_produto = ?"
                + "WHERE id = ?";
                String select = "SELECT * FROM produto;";
                
                    try{
                statement = conexao.CriarStatement();
                        
                resultset = statement.executeQuery(select);

                while (resultset.next()){


                        if(resultset.getInt("id") == id){
                            prepareStatement = conexao.criarPreparedStatement(sql);
                              
                                prepareStatement.setFloat(1,novopreco); //primeiro numero = saldo (primeiro "?", o segundo é o valor
                                prepareStatement.setInt(2, id); // primeiro numero segunda? == segundo numero numero do id
                                prepareStatement.executeUpdate();
                                ArraydeDados_Departamento.inicializarArrayDepartamento(); 
                        }
                        
                    
                }
                 prepareStatement.close();
                }catch(SQLException e){
                        System.err.println("Ocorreu o seguinte erro: "+e);
                    }
                        
                    }if(opcao == 4){
                System.out.println("Digite a nova referencia: ");
                   String novaref = ValidarEntrada.validarString();
                    
                String sql = "UPDATE produto"
                + " SET "
                + "referencia_prod = ?"
                + "WHERE id = ?";
                String select = "SELECT * FROM produto;";
                
                    try{
                statement = conexao.CriarStatement();
                        
                resultset = statement.executeQuery(select);

                while (resultset.next()){


                        if(resultset.getInt("id") == id){
                            prepareStatement = conexao.criarPreparedStatement(sql);
                              
                                prepareStatement.setString(1,novaref); //primeiro numero = saldo (primeiro "?", o segundo é o valor
                                prepareStatement.setInt(2, id); // primeiro numero segunda? == segundo numero numero do id
                                prepareStatement.executeUpdate();
                                ArraydeDados_Departamento.inicializarArrayDepartamento(); 
                        }
                        
                    
                }
                 prepareStatement.close();
                }catch(SQLException e){
                        System.err.println("Ocorreu o seguinte erro: "+e);
                    }
                      
                    }if(opcao == 5){
                        
                       System.out.println("Digite a nova referencia: ");
                    String novadescricao = ValidarEntrada.validarString();
                    
                String sql = "UPDATE produto"
                + " SET "
                + "referencia_prod = ?"
                + "WHERE id = ?";
                String select = "SELECT * FROM produto;";
                
                    try{
                statement = conexao.CriarStatement();
                        
                resultset = statement.executeQuery(select);

                while (resultset.next()){


                        if(resultset.getInt("id") == id){
                            prepareStatement = conexao.criarPreparedStatement(sql);
                              
                                prepareStatement.setString(1,novadescricao); //primeiro numero = saldo (primeiro "?", o segundo é o valor
                                prepareStatement.setInt(2, id); // primeiro numero segunda? == segundo numero numero do id
                                prepareStatement.executeUpdate();
                                ArraydeDados_Departamento.inicializarArrayDepartamento(); 
                        }
                        
                    
                }
                 prepareStatement.close();
                }catch(SQLException e){
                        System.err.println("Ocorreu o seguinte erro: "+e);
                    }
                        
                        
                        
                    }if(opcao<0 || opcao > 5){
                        System.out.println("Opção invalida");
                    }
                  // codigo++;
               
                 // conexao.desconectar();
                    
            
            
        }else{
            System.out.println("Esse departamento não existe");
        }
       
   }
    public static Produtos retornaprodutoespecifico(int id){
        
        for (Produtos arrayproduto : arrayprodutos) {
            if(arrayproduto.getId() == id){
                return arrayproduto;
            }
            
        }
        
        return null;
    }
    

    }        
