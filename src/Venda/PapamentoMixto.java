/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda;

import GestaoPessoas.cliente.BancoDeDados.ArrayDadosCliente;
import GestaoPessoas.cliente.CadastroCliente;
import GestaoPessoas.cliente.Cliente;
import Produtos.BancoDeDados.ArrayDeDadosProdutos;
import TratamentodeErros.ValidarEntrada;
import Venda.BancoDeDados.BDTabelaVendasMistas;
import java.math.BigDecimal;

/**
 *
 * @author pedro
 */
public class PapamentoMixto {
    
    private int quantidadeparcelas;
    private BigDecimal valorparcelado;
    private BigDecimal valortotal;
    private BigDecimal valorpagoavista;
    
    public static void pagarMisto(){
         int ecadastrado, id;
         Cliente cliente = new Cliente();
           System.out.println("O cliente é cadastrado? 1-SIM | 2-NAO");
           System.out.print("Opcao -> ");
            ecadastrado = ValidarEntrada.validarInteiro();
                if(ecadastrado == 1){
                    do{
                    System.out.println("Digite o ID do cliente: ");
                    id = ValidarEntrada.validarInteiro();
                   cliente = ArrayDadosCliente.verificaexistenciaretornacliente(id);
                    if(cliente == null){
                        System.out.println("Cliente nao encontrado");
                    }else{
                        System.out.println("Nome do cliente: "+cliente.getNome());
                            
                          
                    }
                }while(cliente==null);
                    System.out.println("\n\n");
                    System.out.println("Valor da compra: "+ControleVendas.valortotal);
                    System.out.println("Quanto o cliente deseja pagar a vista?");
                    System.out.print("Valor(R$) -> ");
                    BigDecimal valoravista = ValidarEntrada.validarBigDecimal();
                    int pontosganho = valoravista.intValue()/10;
                    System.out.println("Com essa compra, o cliente ganha"+pontosganho+" Pontos na programa de descontos");
                    System.out.println("Valor a ser parcelado no cartao: "+ControleVendas.valortotal.subtract(valoravista));
                    System.out.println("O cliente deseja pagar em quantas vezes? ");
                    System.out.print("Quantidade -> ");
                    int quantidadedevezes = ValidarEntrada.validarInteiro();
                    
                   
                    BigDecimal valorrestante = (ControleVendas.valortotal.subtract(valoravista));
                     BigDecimal valorparcela = valorrestante.divide(BigDecimal.valueOf(quantidadedevezes));
                    Double parcelab = valorrestante.doubleValue()/quantidadedevezes;
                    System.out.println(quantidadedevezes+" parcelas de "+parcelab);
                    int confirmar;
                    do{
                    System.out.println("Deseja confiamar o pagamento? 1 - SIM | 2 - NAO");
                     System.out.print("Opcao -> ");
                    confirmar = ValidarEntrada.validarInteiro();
                        if(confirmar == 1){
                            System.out.println("Compra Efetivada!");
                            PapamentoMixto pagamentomisto = new PapamentoMixto(quantidadedevezes, valorparcela, ControleVendas.valortotal,valoravista);
                            BDTabelaVendasMistas.adicionarcompramista(cliente, pagamentomisto);
                            System.out.println("");
                            ArrayDadosCliente.adicionarpontos(id, pontosganho);
                            ControleVendas.arraycloneproduto.clear();
                            ControleVendas.valortotal = new BigDecimal("0");
                            ControleVendas.arrayvendaslocal.clear();
                            ArrayDeDadosProdutos.inicializarArrayProdutos();
                            ArrayDadosCliente.InicializararrayCliente();
                             for (int i=0;i<ControleVendas.arrayvendaslocal.size();i++){
                ArrayDeDadosProdutos.subtrairestoque(ControleVendas.arrayvendaslocal.get(i).getIdproduto(), ControleVendas.arrayvendaslocal.get(i));
                             }
                            
                        }
                    }while (confirmar!=1);                        
                        
                    }if(ecadastrado == 2){
                        CadastroCliente.cadastroCliente();
                        
                    }
        
        
    }

    public PapamentoMixto(int quantidadeparcelas, BigDecimal valorparcelado, BigDecimal valortotal, BigDecimal valorpagoavista) {
        this.quantidadeparcelas = quantidadeparcelas;
        this.valorparcelado = valorparcelado;
        this.valortotal = valortotal;
        this.valorpagoavista = valorpagoavista;
    }
    
    

    public int getQuantidadeparcelas() {
        return quantidadeparcelas;
    }

    public void setQuantidadeparcelas(int quantidadeparcelas) {
        this.quantidadeparcelas = quantidadeparcelas;
    }

    public BigDecimal getValorparcelado() {
        return valorparcelado;
    }

    public void setValorparcelado(BigDecimal valorparcelado) {
        this.valorparcelado = valorparcelado;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public BigDecimal getValorpagoavista() {
        return valorpagoavista;
    }

    public void setValorpagoavista(BigDecimal valorpagoavista) {
        this.valorpagoavista = valorpagoavista;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    public String stringavista(){
        return ""+valorpagoavista;
    }
    public String valorparcelado(){
        return ""+valorparcelado;
    }
    
    
    
}
