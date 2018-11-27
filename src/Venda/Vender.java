/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda;

import Produtos.BancoDeDados.ArrayDeDados_Produtos;
import Produtos.Produtos;
import TratamentodeErros.ValidarEntrada;
import java.io.IOException;
import java.math.BigDecimal;

/**Classe para inicializar as vendas
 *
 * @author pedro
 */
public class Vender {
    public static BigDecimal valortotal = new BigDecimal("0");
     public static void venda() throws IOException{

         

       ControleVendas.inicializarclone();
        int sai;
        BigDecimal preco;
        BigDecimal valorproduto;
        boolean verifica;
        boolean sair = false;
        int saidageral=1;
        int opcaoum;
        do{
            System.out.println("1 -Mostrar Produtos em estoque | 2 -Adicionar produto no carrinho  ");
            System.out.print("Opção -> ");
            opcaoum = ValidarEntrada.validarInteiro();
            
            
            if(opcaoum == 1){
                System.out.printf("\n\n");
                ControleVendas.imprimeprodutosemestoque();
                System.out.println("");
               System.out.println("Pressione Enter para continuar...");
               System.in.read(); 
                
            }
           
           if(opcaoum ==2) {
            
            int id ;
        do{
            System.out.println("\nDigite o ID do produto: ");
            System.out.print("ID -> ");
                         id = ValidarEntrada.validarInteiro();
             verifica = ArrayDeDados_Produtos.verificarexistencia(id);
             if(verifica == false){
                 System.err.println("ID inválido, tente novamente");
             }
        }while(verifica == false);
        
        Produtos produto = ControleVendas.retornaprodutoespecifico(id);
        
 
        System.out.println("\n\nProduto: "+ produto.getNome()+ " |Referencia: "+produto.getReferencia()+" |Valor por unidade: "+produto.getValor());
        System.out.println("\nDeseja continuar a operação?");
        System.out.println("1 - SIM |2- NAO");
        System.out.print("Opção -> ");
        sai = ValidarEntrada.validarInteiro();
        
        
            if(sai == 1){
                valorproduto = produto.getValor();
                boolean verificaquantidade = false;
            do{
              
        System.out.println("\nDigite a quantidade: ");
        System.out.print("Quantidade -> ");
       int quantidade;
        do{
        quantidade = ValidarEntrada.validarInteiro();
            if(quantidade<1){
                System.out.println("Quantidade invalida");
            }
        }while (quantidade<0);
        
            if(quantidade > produto.getQuantidadeestoque()){
                System.out.println("");
                System.err.println("\nNao é possivel fazer essa operacao, quantidade em estoque insuficiente | Quantidade atual: "+produto.getQuantidadeestoque());
            }else{
            verificaquantidade = true;    
             preco = valorproduto.multiply(BigDecimal.valueOf(quantidade));
                System.out.println("\n\n");
                System.out.println("\nProduto: "+produto.getNome()+ " |Valor (R$): "+produto.getValor()+ " X "+quantidade+" = "+ preco);
                boolean saida = false;
                do{
                System.out.println("\nColocar no carrinho? 1-SIM | 2-NAO");
                System.out.print("Opção -> ");
                int opcao = ValidarEntrada.validarInteiro();
               
                    if(opcao == 1){ 
                        //int idproduto, int quantidade, float precounitario, float precototal, String nomeproduto)
                        Vendas vender = new Vendas(id,quantidade,produto.getValor(),preco,produto.getNome());
                     //   ControleVendas.arrayvendaslocal.add(vender);
                        ControleVendas.adicionarcarrinho(vender);
                       
                        ControleVendas.subtrair(id, quantidade);
                          saida = true;
                          sair =true;
                           saidageral = 0;
                    }
                        if (opcao == 2){
                       saida = true;
                       sair =true;
                       saidageral = 0;
                    }else if (opcao != 1 && opcao != 2){
                        System.err.println("Opção invalida");
                    }
               }while (saida == false);
           
            }
            
    }while (sair == false);
        }
               System.out.println("\n\n\n");
            ControleVendas.mostrarcarrinho();
            System.out.println("\n\n\n");
            System.out.println("\nDeseja continuar comprando? 1-SIM | 2-NAO ");
            System.out.print("Opção -> ");
            saidageral = ValidarEntrada.validarInteiro();
           
           }
}while(saidageral==1);
        
        }
        
}
