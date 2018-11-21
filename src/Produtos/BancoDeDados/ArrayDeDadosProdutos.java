package Produtos.BancoDeDados;


import Produtos.Produtos;
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
public abstract class ArrayDeDadosProdutos  {
    
    public static ArrayList<Produtos> arrayprodutos = new ArrayList<Produtos>();
    
    public static void inicializarArrayProdutos(){
        arrayprodutos.clear();
        
          Criar_Conexao_Produtos criarConex = new Criar_Conexao_Produtos();
         criarConex.conectar();
         
       
          ResultSet resultset = null;
           Statement statement = null;
        
          
          String sql = "SELECT * FROM produto;";

                  statement = criarConex.CriarStatement();
                    try {
                        

            resultset = statement.executeQuery(sql);
                      while (resultset.next()) {
                          ResultSet s = resultset;
        // public Produtos(String nome, String Descricao, int quantidadeestoque, float valor, Integer id, String referencia, String marca, int departamento)
                         Produtos produto = new Produtos (resultset.getString("nome_produto"),resultset.getString("descricao_produto"),resultset.getInt("quantidade"),resultset.getFloat("preco_produto"),resultset.getInt("id"),resultset.getString("referencia_prod"), resultset.getString("marca_produto"),resultset.getInt("departamento"));
                          arrayprodutos.add(produto);

                      
                      }
                        System.out.println("Array Inicializado");
                              statement.close();
                    criarConex.desconectar();
                    }catch (SQLException e){
                              System.err.println("Ocorreu algum erro: "+e);
                              }
                    criarConex.desconectar();


    }
    
   static public void buscarProdutoNome(String nome){
          for (Produtos arrayproduto : arrayprodutos) {
             
                if (arrayproduto.getNome().equalsIgnoreCase(nome)){
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
       
       Criar_Conexao_Produtos conexao = new Criar_Conexao_Produtos(); 
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
                                int opexcluir = ValidarEntrada.validaropcao();
                                if (opexcluir == 1){
                                PreparedStatement prepared= null;
                                  String delete = "DELETE FROM produto"
                                  + " WHERE id = ?;";
                                  try{
                                  prepared= conexao.criarPreparedStatement(delete);
                                  prepared.setInt(1, id);
                                  prepared.executeUpdate();
                                 ArrayDeDadosProdutos.inicializarArrayProdutos();
                              }catch(Exception e){
                                      System.out.println("erro "+e);
                                      
                              }
                                }else{
                                    System.out.println("Operação cancelada");
                                }
                            }
                      }
                      
                   }catch(SQLException e){
                       System.err.println("Erro: "+e);
                   }
       
       
       
       
       
   }
   
 /*  public static void editarProduto(int id, int novoid){
       
       Criar_Conexao_Produtos conexaoprodutos = new Criar_Conexao_Produtos();
    conexaoprodutos.conectar();
    
                      try{
                                  PreparedStatement prepareStatement = null;
                                  ResultSet resulset = null;

                                   Statement statement;
 
                                    String tabelaAtualuzacao = "UPDATE produto"
                                     + " SET "
                                      + " id = nome_produto ?"
                                      + "WHERE codigo = ?";
                                       String select = "SELECT * FROM produto;";
 
                                     statement = conexaoprodutos.CriarStatement();

                resulset = statement.executeQuery(select);
                 
                while (resulset.next()){
                    if(resulset.getInt("id") == id){
                           System.out.println("---Atualização produto---");
                          
                        String nn = JOptionPane.showInputDialog("Digite o novo nome: ");
                         prepareStatement = conexaoprodutos.criarPreparedStatement(tabelaAtualuzacao);
                                    prepareStatement.setString(1, "nome"); //primeiro numero = saldo (primeiro "?", o segundo é o valor
                                        prepareStatement.setInt(2, resulset.getInt("id")); // primeiro numero segunda? == segundo numero numero do id
                                
                                        prepareStatement.executeUpdate();
                    }
                        
                    }
                }catch (Exception e){
                                System.out.println("erro "+e);
                              } }
       
       
       
       
       
       
   }
   */ 
    
   public static void imprimirArryProdutos(){
        System.out.println("---Produtos Cadastrados---");
        for (Produtos arrayproduto : arrayprodutos) {
            System.out.println("ID: "+arrayproduto.getId()+"| nome: "+arrayproduto.getNome()+" |Marca: "+ arrayproduto.getReferencia()+" |Departamento: "+arrayproduto.getDepartamento()+"|Referencia: "+arrayproduto.getReferencia()+ "| Preço: "+arrayproduto.getValor()+"| Quantidade em Estoque: "+arrayproduto.getQuantidadeestoque());   
        }
        
        
    }
       
        
    }
    
    
    

