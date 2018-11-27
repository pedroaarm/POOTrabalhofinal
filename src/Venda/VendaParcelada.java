/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda;

import GestaoPessoas.cliente.BancoDeDados.ArrayDadosCliente;
import GestaoPessoas.cliente.Cliente;
import Produtos.BancoDeDados.ArrayDeDadosProdutos;
import Produtos.BancoDeDados.MovimentacaoArray;
import TratamentodeErros.ValidarEntrada;
import Venda.BancoDeDados.BDTabelaComprasParceladas;
import Venda.BancoDeDados.ManipulacaoBDVendas;
import static Venda.EncerrarCompra.cliente;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 *
 * @author pedro
 */
public class VendaParcelada {
    
    
   private  Integer parcelas;
    private BigDecimal valorparcela;
    private Cliente clientes;
    
    public static void vendaparcelada() throws IOException{
        
         int idcliente1,idcliente;
         
        System.out.println("1 - Mostrar Lista de Clientes | 2 - Fazer identificacao:");
        idcliente1 = ValidarEntrada.validarInteiro();
            if(idcliente1 == 1){
                System.out.println("\n\n");
              ArrayDadosCliente.imprimirArrayCliente();
               System.out.println("Pressione Enter para continuar...");
                     System.in.read(); 
                                          
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
               Integer parcelas;
                do{
                System.out.println("Digite o numero de vezes que o cliente deseja pagar: ");
                 parcelas = ValidarEntrada.validarInteiro();
                 if(parcelas>12){
                     System.out.println("**Só é permitido ate 12 parcelas**");
                 }
                }while(parcelas>12);
                System.out.println("Valor total:"+ControleVendas.valortotal);
                Double valorparcelas = ControleVendas.valortotal.doubleValue()/parcelas;
                BigDecimal vapar = ControleVendas.valortotal.divide(BigDecimal.valueOf(parcelas));
                System.out.println(parcelas+ " parcelas de "+valorparcelas);

                    int encerrar;
                    do{
                System.out.println("Deseja confirmar a compa? 1-SIM | 2-NAO");
                encerrar = ValidarEntrada.validarInteiro();
                    if(encerrar == 1){
                  
                        System.out.println("Compra Efetivada!");
                   VendaParcelada vendaparcelada = new VendaParcelada(parcelas, vapar, cliente);
                       BDTabelaComprasParceladas.adicionarcompraparcelada(cliente, vendaparcelada);
                        for (int i=0;i<ControleVendas.arrayvendaslocal.size();i++){
                ArrayDeDadosProdutos.subtrairestoque(ControleVendas.arrayvendaslocal.get(i).getIdproduto(), ControleVendas.arrayvendaslocal.get(i));

                            ControleVendas.arraycloneproduto.clear();
                            ControleVendas.valortotal = new BigDecimal("0");
                            ControleVendas.arrayvendaslocal.clear();
                            ArrayDeDadosProdutos.inicializarArrayProdutos();
                            ArrayDadosCliente.InicializararrayCliente();                                                 }
                   
                       System.out.println("Press Enter to continue...");
                     System.in.read(); // esperar digitar enter pra sair;
                     
                     
                     
                        encerrar = 1;
                    }if(encerrar == 2){
                        encerrar =1;
                    }if(encerrar > 3){
                        System.out.println("opcao invalida");
                    }
                    }while(encerrar != 1);
        
    }
                    
 
    
        
        
    

    public VendaParcelada(Integer parcelas, BigDecimal valorparcela, Cliente clientes) {
        this.parcelas = parcelas;
        this.valorparcela = valorparcela;
        this.clientes = clientes;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    public BigDecimal getValorparcela() {
        return valorparcela;
    }

    public void setValorparcela(BigDecimal valorparcela) {
        this.valorparcela = valorparcela;
    }

    public Cliente getClientes() {
        return clientes;
    }

    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return  ""+valorparcela;
    }
    
    
}
