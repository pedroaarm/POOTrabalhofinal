/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda;

import GestaoPessoas.cliente.BancoDeDados.ArrayDeDados_Cliente;
import GestaoPessoas.cliente.CadastroCliente;
import GestaoPessoas.cliente.Cliente;
import Produtos.BancoDeDados.ArrayDeDados_Produtos;
import TratamentodeErros.ValidarEntrada;
import Venda.BancoDeDados.BDTabelaComprasParceladas;
import Venda.BancoDeDados.ManipulacaoBDVendas;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class EncerrarCompra {
    static Cliente cliente;
    public static void encerrar() throws IOException, SQLException{
        int idcliente;

        int op; 
        if(ControleVendas.valortotal.intValue()>0){
          do{
        System.out.println("\n\n\n");
        System.out.println("Forma de pagamento: 1-A Vista |2 -Cartao de credito |3 -Pagamento Misto |0 -Voltar");
        System.out.print("Opcao -> ");
         op = ValidarEntrada.validarInteiro();
      
            if(op ==1){
                int ident;
                System.out.println("\nO Cliente deseja se identificar? 1-SIM | 2-NAO");
                System.out.print("Opcao -> ");
                ident = ValidarEntrada.validarInteiro();
                    if(ident ==1){
                        int ecadastrado;
                        System.out.println("\nO cliente é cadastrado? 1-SIM | 2-NAO");
                        System.out.print("Opcao ->");
                        ecadastrado = ValidarEntrada.validarInteiro();
                        if(ecadastrado == 1){
                                    boolean verificacliente=false;
                                    int idcliente1;
                                    do{
                                        System.out.println("\n1 - Mostrar Lista de Clientes | 2 - Fazer identificacao:");
                                        System.out.print("Opcao -> ");
                                        idcliente1 = ValidarEntrada.validarInteiro();
                                            if(idcliente1 == 1){
                                                System.out.println("\n\n");
                                                ArrayDeDados_Cliente.imprimirArrayCliente();
                                               System.out.println("Press Enter to continue...");
                                                System.in.read();
                                                System.out.println("");
                                                System.out.println("");
                                                
                                                
                                            }if(idcliente1 == 2){
                                                do{
                                                System.out.println("\nDigite o id do cliente: ");
                                                System.out.print("ID -> ");
                                                idcliente = ValidarEntrada.validarInteiro();
                                                cliente = ArrayDeDados_Cliente.verificaexistenciaretornacliente(idcliente);
                                                if(cliente  == null){
                                                    System.out.println("\nCliente nao encontrado, tente novamente.");
                                                }else{
                                                    //parte do cliente identificado a vista
                                                    System.out.println("\nO cliente deseja participar do programa de pontos? o cliente possui"+cliente.getPontos()+" pontos ");
                                                    System.out.println("1 - SIM | 2 - NAO");
                                                    System.out.print("Opcao -> ");
                                                    int opcaopontos = ValidarEntrada.validarInteiro();
                                                        if(opcaopontos == 1){
                                                            ProgramadeDesconto.programadevantagens(cliente);
                                                            if(ControleVendas.valortotal.doubleValue()>0){
                                                                boolean verificar=false;
                                                                do{
                                                                System.out.println("\nValor final da compra: "+ControleVendas.valortotal);
                                                                if(ControleVendas.valortotal.intValue()>0){
                                                                System.out.println("Digite o valor em R$ dado pelo cliente: ");
                                                                System.out.print("Valor -> ");
                                                                BigDecimal valordado = ValidarEntrada.validarBigDecimal();
                                                                    if(valordado.compareTo(ControleVendas.valortotal)>=0){//verifica se o valor total com descontos eh maios que 0;
                                                                        System.out.println("\nTroco: "+valordado.subtract(ControleVendas.valortotal));
                                                                        System.out.println("Compra efetivada!");
                                                                        System.out.println("Press Enter to continue...");
                                                     System.in.read(); // esperar digitar enter pra sair;
                                                                        //efetivar compra, gravar no banco;
                                                                        ManipulacaoBDVendas.adicionaraobanco(cliente);
                                                                        for (int i=0;i<ControleVendas.arrayvendaslocal.size();i++){
                                                                        ArrayDeDados_Produtos.subtrairestoque(ControleVendas.arrayvendaslocal.get(i).getIdproduto(), ControleVendas.arrayvendaslocal.get(i));
                                                                        verificar = true;
                                                                        }
                                                                    }else{
                                                                        System.err.println("\nValor insuficiente");
                                                                        verificar = false;
                                                                    }
                                                                }
                                                                    System.out.println("\nCompra Efetivada!");
                                                                    ManipulacaoBDVendas.adicionaraobanco(cliente);
                                                                    ArrayDeDados_Cliente.retirarpontos(idcliente);
                                                                     System.out.println("\nPress Enter to continue...");
                                                                     System.in.read();
                                                                }while(verificar == false);
                                                            }else{

                            ControleVendas.arraycloneproduto.clear();
                            ControleVendas.valortotal = new BigDecimal("0");
                            ControleVendas.arrayvendaslocal.clear();
                            ArrayDeDados_Produtos.inicializarArrayProdutos();
                            ArrayDeDados_Cliente.InicializararrayCliente();
                                                                                 
                                                                System.out.println("\nPress Enter to continue...");
                                                              System.in.read();
                                                                
                                                            }
                                                        }
                                                    
                                                    verificacliente = true;
                                                }
                                                }while(cliente == null);
                                               
                                            }if(idcliente1>2){
                                                System.out.println("Opcao invalida");
                                            }}while (verificacliente == false);
                                                
                                                
                    }if(ecadastrado == 2){
                       
                        CadastroCliente.cadastroCliente();
                    }if(ecadastrado > 2){
                        System.out.println("\nopcao invalida");
                    }
            }if(ident == 2){
                
  if(ControleVendas.valortotal.doubleValue()>0){
             boolean verificar=false;
                do{
                 System.out.println("\nValor final da compra: "+ControleVendas.valortotal);
                  if(ControleVendas.valortotal.intValue()>0){
                  System.out.println("Digite o valor em R$ dado pelo cliente: ");
                  System.out.print("Valor -> ");
                  BigDecimal valordado = ValidarEntrada.validarBigDecimal();
                   if(valordado.compareTo(ControleVendas.valortotal)>=0){//verifica se o valor total com descontos eh maios que 0;
                   System.out.println("\nTroco: "+valordado.subtract(ControleVendas.valortotal));
                  System.out.println("Compra efetivada!");
                  op=0;
                   System.out.println("Press Enter to continue...");
                     System.in.read(); // esperar digitar enter pra sair;
                                                                        //efetivar compra, gravar no banco;
 
                     for (int i=0;i<ControleVendas.arrayvendaslocal.size();i++){
                      ArrayDeDados_Produtos.subtrairestoque(ControleVendas.arrayvendaslocal.get(i).getIdproduto(),ControleVendas.arrayvendaslocal.get(i));
                        verificar = true;
                              }
                        }else{
                           System.out.println("\nValor insuficiente");
                        verificar = false;
                                     }
                       }
  
                                  }while(verificar == false);
                                   }else{
                                  ManipulacaoBDVendas.adicionaraobanco(null);
                                  System.out.println("\nCompra Efetivada!");
                                   ControleVendas.arraycloneproduto.clear();
                                                                
                                                                
                                                            }
                                                        }
                                                    
            //jogar no BD;
    }if(op == 2){
        VendaParcelada.vendaparcelada();
        op=0;

               
    }if(op ==3){
        PapamentoMixto.pagarMisto();
        op=0;
    }
    if(op >3){
        System.out.println("Opcao Invalida!");
    }
    }while(op!=0 );
    }
        else{
            System.out.println("Carrinho Vazio!");
    }
}

 
    

    public static void encerrarcomcadastro(Cliente cliente){
        
        System.out.println("\nO cliente tem "+cliente.getPontos()+ " no programa de vantagens, deseja utilizar como desconto? ");
        System.out.println("1 - SIM | 2 - NAO");
        System.out.print("Opcao -> ");
          int op = ValidarEntrada.validarInteiro();
          do{
            if(op == 1){
                ProgramadeDesconto.programadevantagens(cliente);
                System.out.println("O valor da compra com o uso dos pontos eh: "+ControleVendas.valortotal);
            }if(op > 2){
                System.out.println("Opcao invalida!");
            }
          } while(op == 1 || op ==2);
    }
    
}