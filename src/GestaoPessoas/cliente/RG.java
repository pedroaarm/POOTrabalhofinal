/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoPessoas.cliente;

import TratamentodeErros.ValidarDocumento;
import TratamentodeErros.ValidarEntrada;

/**Classe onde reune a informação de RG, onde será necessário para cadastro de cliente
 *
 * @author pedro
 */
public class RG {
    
    private String numero;

    public RG(String numero) {
        this.numero = numero;
    }

    public RG() {
    }
    
   

    public void cadastroRG(){
        boolean verifica;
         String rg;
        System.out.println("Digite o numero do RG: ");
        do{
            System.out.print("RG -> ");    
         rg = ValidarEntrada.validarString();
        verifica = ValidarDocumento.SoTemNumeros(rg);
               if(verifica == false){
                System.out.println("RG invalido, coloque apenas numeros");
            }
            }while(verifica == false);
       setNumero(rg);
    }
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
}
