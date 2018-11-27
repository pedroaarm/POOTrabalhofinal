/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda;

import Produtos.BancoDeDados.*;
import Produtos.Produtos;
import java.math.BigDecimal;
import java.util.ArrayList;


/**Faz os controles e atualizacoes do array de vendas, alem de mostrar os produtos adicionados no carrinho
 *
 * @author pedro
 */
public class ControleVendas {
    
    public static ArrayList <Vendas> arrayvendaslocal = new ArrayList();
    public static ArrayList <Produtos> arraycloneproduto = new ArrayList<Produtos>();
     public static BigDecimal valortotal = new BigDecimal("0"); 
 
    public static void mostrarcarrinho(){
        if(arrayvendaslocal.isEmpty()){
            System.out.println("Não há produtos no carrinho");
        }else{
            System.out.println("\n\n");
            System.out.println("Produtos no carrinho:");
            for (Vendas vendas : arrayvendaslocal) {
                System.out.println("Produto: "+vendas.getNomeproduto()+ " |Valor unitario: "+vendas.getPrecounitario()+" |Quantidade: "+vendas.getQuantidade()+" |Valor total: "+vendas.getPrecototal());
                
            }
            System.out.println("VALOR TOTAL DA COMPRA: "+valortotal);
        }
        
    }
    public static void adicionarcarrinho(Vendas vendas){
        arrayvendaslocal.add(vendas);
      valortotal= valortotal.add(vendas.getPrecototal());
               
    }
    
    public static void removerprodutocarrinho(int id){
        
       boolean existe = ArrayDeDados_Produtos.verificarexistencia(id);
        
       if(existe == true){
      for (int i=0; i<arrayvendaslocal.size();i++){
          if(arrayvendaslocal.get(i).getIdproduto() == id){
              
              valortotal = valortotal.subtract(arrayvendaslocal.get(i).getPrecototal());
               for (int j=0; j<arraycloneproduto.size();j++){
                  if(arraycloneproduto.get(j).getId() == id){
                      arraycloneproduto.get(j).setQuantidadeestoque(arrayvendaslocal.get(i).getQuantidade()+arraycloneproduto.get(j).getQuantidadeestoque());
                  }
                  
              }
               System.out.println("Produto Removido!");
              arrayvendaslocal.remove(i);
          }
            
        }
       }else{
           System.err.println("Produto nao encontrado!");
       }
        
        
    }
    
    public static void inicializarclone(){
        arraycloneproduto.clear();
            for (Produtos ArrayVendas : ArrayDeDados_Produtos.arrayprodutos) {
                arraycloneproduto.add(ArrayVendas);
        }
            
        }
    public static void subtrair(int id, int quantidade){
        for (int i = 0; i <arraycloneproduto.size(); i++) {
            if(arraycloneproduto.get(i).getId() == id){
              arraycloneproduto.get(i).setQuantidadeestoque( arraycloneproduto.get(i).getQuantidadeestoque() - quantidade);
            }
            
        }
    }
    
    
    
       public static Produtos retornaprodutoespecifico(int id){
        
           for (Produtos produtos : arraycloneproduto) {
               if(produtos.getId() == id){
                   return produtos;
           }       
        }
        
        return null;
    }
       // imprimir os produtos que tem estoque maior que 0;
       public static void imprimeprodutosemestoque(){
            for (Produtos produtos : arraycloneproduto) {
                if(produtos.getQuantidadeestoque()>0){
                    System.out.println("ID: "+produtos.getId()+" |Nome: "+produtos.getNome()+" |Valor: "+produtos.getValor()+"   |Estoque: "+produtos.getQuantidadeestoque());
                }
            }
       } 
      
    public static String retornaendereco() {
        String concatena = ControleVendas.arrayvendaslocal.get(0).getNomeproduto()+ "quantidade: "+arrayvendaslocal.get(0).getQuantidade();
        for (int i=1;i<ControleVendas.arrayvendaslocal.size();i++){
            concatena = concatena + "produto: "+ControleVendas.arrayvendaslocal.get(i).getNomeproduto();
        }
        return concatena; //To change body of generated methods, choose Tools | Templates.
    }
    }
    

