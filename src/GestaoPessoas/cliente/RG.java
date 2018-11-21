/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoPessoas.cliente;

import TratamentodeErros.ValidarEntrada;

/**
 *
 * @author pedro
 */
public class RG {
    
    private String numero;

    public RG(String numero) {
        this.numero = numero;
    }

    public void cadastroRG(){
        
        System.out.println("Digite o numero do RG: ");
        String rg = ValidarEntrada.validarString();
        setNumero(rg);
    }
    
    RG() {
        
    }
   
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
}
