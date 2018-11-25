/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda;

import Produtos.BancoDeDados.ArrayDeDadosProdutos;
import Produtos.Produtos;
import TratamentodeErros.ValidarEntrada;
import Utilitarios.LimparTela;
import java.math.BigDecimal;

/**
 *
 * @author pedro
 */
public class Vender {
    public static BigDecimal valortotal = new BigDecimal("0");
     public static void venda(){

         

       ControleVendas.inicializarclone();
        int sai;
        BigDecimal preco;
        BigDecimal valorproduto;
        boolean verifica = false;
        boolean sair = false;
        int saidageral=1;
        int opcaoum;
        do{
            System.out.println("1 - Mostrar Produtos em estoque | 2 - adicionar produto no carrinho:  ");
            opcaoum = ValidarEntrada.validarInteiro();
            
            
            if(opcaoum == 1){
                ControleVendas.imprimeprodutosemestoque();
            }
           
           if(opcaoum ==2) {
            
            int id ;
        do{
            System.out.println("Digite o ID do produto ou 0 pra sair ");
                         id = ValidarEntrada.validarInteiro();
             verifica = ArrayDeDadosProdutos.verificarexistencia(id);
             if(verifica == false){
                 System.err.println("ID inválido, tente novamente");
             }
        }while(verifica == false);
        
        Produtos produto = ControleVendas.retornaprodutoespecifico(id);
        
 
        System.out.println("Produto: "+ produto.getNome()+ " |Referencia: "+produto.getReferencia()+" |Valor por unidade: "+produto.getValor());
        System.out.println("Deseja continuar a operação?");
        System.out.println("1 - SIM |2- NAO");
        sai = ValidarEntrada.validarInteiro();
        
        
            if(sai == 1){
                valorproduto = produto.getValor();
                boolean verificaquantidade = false;
            do{
              
        System.out.println("Digite a quantidade: ");
       int quantidade;
        do{
        quantidade = ValidarEntrada.validarInteiro();
            if(quantidade<1){
                System.out.println("Quantidade invalida");
            }
        }while (quantidade<0);
        
            if(quantidade > produto.getQuantidadeestoque()){
                System.out.println("");
                System.err.println("Nao é possivel fazer essa operacao, quantidade em estoque insuficiente | Quantidade atual: "+produto.getQuantidadeestoque());
            }else{
            verificaquantidade = true;    
             preco = valorproduto.multiply(BigDecimal.valueOf(quantidade));
             
                System.out.println("Produto: "+produto.getNome()+ " |R$: "+produto.getValor()+ " X "+quantidade+" = "+ preco);
                boolean saida = false;
                do{
                System.out.println("Colocar no carrinho? 1-SIM | 2-NAO");
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
            LimparTela.limparpouco();
            System.out.println("Produtos no carrinho:");
            ControleVendas.mostrarcarrinho();
             LimparTela.limparpouco();
            System.out.println("Deseja continuar comprando? 1-SIM | 2-NAO ");
            saidageral = ValidarEntrada.validarInteiro();
             LimparTela.limparpouco();
           }
}while(saidageral==1);
        
        }
        
}
