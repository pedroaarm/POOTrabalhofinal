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
        BigDecimal valorcomdesconto;
        
        if(cliente.getPontos()>0){
       valorcomdesconto = ControleVendas.valortotal.subtract(new BigDecimal(cliente.getPontos()));
            if(valorcomdesconto.compareTo(BigDecimal.ZERO)>=0){

       ControleVendas.valortotal = ControleVendas.valortotal.subtract(new BigDecimal(cliente.getPontos()));
               }else{
                System.out.println("Com o uso dos pontos, o valor da compra é 0 reais");
            }
            
        }else{
            System.out.println("Quantidade de pontos insuficiente");
        }
        
    }
}
