/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda;

import GestaoPessoas.cliente.Cliente;
import java.math.BigDecimal;

/**
 *
 * @author pedro
 */
public class ProgramadeDesconto {
    public static void programadevantagens(Cliente cliente){
        
        if(cliente.getPontos()>0){//verificar se os pontos que o cliente possui é maior que 0
             
               if((ControleVendas.valortotal.intValue() - cliente.getPontos()) <=0 ){
                   System.out.println("Com o desconto dos pontos o valor da compra eh: 0 reais");
               }else{
                   ControleVendas.valortotal = ControleVendas.valortotal.subtract(new BigDecimal (cliente.getPontos()));
                   System.out.println("O valor da compra eh: "+ControleVendas.valortotal);

       ControleVendas.valortotal = ControleVendas.valortotal.subtract(new BigDecimal(cliente.getPontos()));
       //Tirar o valor dos pontos no BD do cliente;
            
        }
        }else{
            System.out.println("O cliente tem 0 pontos");
        }
        
    }
}
