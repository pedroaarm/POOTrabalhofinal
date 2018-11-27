/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda;

/**Cancela a venda
 *
 * @author pedro
 */
public class CancelarVenda {
    public static void cancelar(){
        ControleVendas.arrayvendaslocal.clear();
        System.out.println("Venda Cancelada!");
    }
}
