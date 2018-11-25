/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda;

import Produtos.BancoDeDados.*;
import static Produtos.BancoDeDados.ArrayDeDadosProdutos.arrayprodutos;
import Produtos.Produtos;
import java.math.BigDecimal;
import java.util.ArrayList;


/**
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

            for (Vendas vendas : arrayvendaslocal) {
                System.out.println("Produtos: "+vendas.getNomeproduto()+ " |Valor unitario"+vendas.getPrecounitario()+" |Quantidade: "+vendas.getQuantidade()+"Valor total: "+vendas.getPrecototal());
               valortotal =valortotal.add(vendas.getPrecototal());
            }
            System.out.println("VALOR TOTAL DA COMPRA: "+valortotal);
        }
        
    }
    
    public static void inicializarclone(){
            for (Produtos ArrayVendas : ArrayDeDadosProdutos.arrayprodutos) {
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
        
    }
    

