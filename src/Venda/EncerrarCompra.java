/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda;

import GestaoPessoas.cliente.BancoDeDados.ArrayDadosCliente;
import GestaoPessoas.cliente.CadastroCliente;
import GestaoPessoas.cliente.Cliente;
import TratamentodeErros.ValidarEntrada;
import java.math.BigDecimal;

/**
 *
 * @author pedro
 */
public class EncerrarCompra {
    static Cliente cliente;
    public static void encerrar(){
        int idcliente;
        boolean verificarexistenciacliente;
    
        System.out.println("Forma de pagamento: 1-A Vista | 2 - Cartao de credito 3 - Pagamento Misto");
        int op = ValidarEntrada.validarInteiro();
            if(op ==1){
                int ident;
                System.out.println("O Cliente deseja se identificar? 1-SIM | 2-NAO");
                ident = ValidarEntrada.validarInteiro();
                    if(ident ==1){
                        int ecadastrado;
                        System.out.println("O cliente é cadastrado? 1-SIM | 2-NAO");
                        ecadastrado = ValidarEntrada.validarInteiro();
                        if(ecadastrado == 1){
                                    boolean verificacliente=false;
                                    int idcliente1;
                                    do{
                                        System.out.println("1 - Mostrar Lista de Clientes | 2 - Fazer identificacao:");
                                        idcliente1 = ValidarEntrada.validarInteiro();
                                            if(idcliente1 == 1){
                                                ArrayDadosCliente.imprimirArrayCliente();
                                                
                                            }if(idcliente1 == 2){
                                                do{
                                                System.out.println("Digite o id do cliente: ");
                                                idcliente = ValidarEntrada.validarInteiro();
                                                cliente = ArrayDadosCliente.verificaexistenciaretornacliente(idcliente);
                                                if(cliente  == null){
                                                    System.out.println("Cliente nao encontrado, tente novamente.");
                                                }else{
                                                    verificacliente = true;
                                                }
                                                }while(cliente == null);
                                               
                                            }if(idcliente1>2){
                                                System.out.println("Opcao invalida");
                                            }}while (verificacliente == false);
                                                
                                                
                    }if(ecadastrado == 2){
                       
                        CadastroCliente.cadastroCliente();
                    }if(ecadastrado > 2){
                        System.out.println("opcao invalida");
                    }
            }if(ident == 2){
                System.out.println("");
                
                ControleVendas.mostrarcarrinho();
                boolean valorsuficiente=true;
                do{
                System.out.println("Valor em dinheiro dado pelo cliente: ");
                BigDecimal valor = ValidarEntrada.validarBigDecimal();
                    if(valor.compareTo(ControleVendas.valortotal)<0  ){
                        System.out.println("Valor insuficiente");
                    }else{
                        valorsuficiente =true;
                    }
            }while(valorsuficiente == true);
                System.out.println("");
         }
            //jogar no BD;
    }if(op == 2){
        //parcelado com cartao
        
       int idcliente1;
        System.out.println("1 - Mostrar Lista de Clientes | 2 - Fazer identificacao:");
        idcliente1 = ValidarEntrada.validarInteiro();
            if(idcliente1 == 1){
              ArrayDadosCliente.imprimirArrayCliente();
                                          
            }if(idcliente1 == 2){
              do{
                 System.out.println("Digite o id do cliente: ");
                idcliente = ValidarEntrada.validarInteiro();
                cliente = ArrayDadosCliente.verificaexistenciaretornacliente(idcliente);
                  if(cliente  == null){
                      System.out.println("Cliente nao encontrado, tente novamente.");
                   }
             }while(cliente == null);
               }if(idcliente1>2){
                     System.out.println("Opcao invalida");
              
               }
                System.out.println("Digite o numero do cartão");
                Integer numerocartao = ValidarEntrada.validarInteiro();
                System.out.println("Digite o codigo de seguranca");
                int codigoseguranca = ValidarEntrada.validarInteiro();
                System.out.println("Digite o numero de vezes que o cliente deseja pagar: ");
                int parcelas = ValidarEntrada.validarInteiro();
                
                BigDecimal valorparcelas = Vender.valortotal.divide(BigDecimal.valueOf(parcelas));
                System.out.println(parcelas+ " parcelas de "+valorparcelas);
                    System.out.println("Deseja confirmar a compa? 1-SIM | 2-NAO");
                    int encerrar;
                    do{
                encerrar = ValidarEntrada.validarInteiro();
                    if(encerrar == 1){
                        //fazer o Banco encerrar a compra
                        encerrar = 1;
                    }if(encerrar == 2){
                        encerrar =1;
                    }if(encerrar > 3){
                        System.out.println("opcao invalida");
                    }
                    }while(encerrar == 1);
                
        
        
        
        
        
        
    }
    
}
    public static void encerrarcomcadastro(Cliente cliente){
        
        System.out.println("O cliente tem "+cliente.getPontos()+ " no programa de vantagens, deseja utilizar como desconto? ");
        System.out.println("1 - SIM | 2 - NAO");
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