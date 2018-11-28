/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoPessoas;

import GestaoPessoas.cliente.Endereco;
import TratamentodeErros.ValidarEntrada;

/**Essa classe faz o cadastro do endereço
 *
 * @author pedro
 */
public class CadastroEndereco {
    /**Esse metodo pede as informacoes de endereco do pessoa e retorna um objeto de endereco
     * 
     * @return objeto de endereco
     */
        public static  Endereco cadendereco() {
      
        System.out.println("\n\t***Cadastro informações de Endereco***\n");
        System.out.println("Digite o nome da rua: ");
         System.out.print("Nome -> ");
        String rua = ValidarEntrada.validarString();
        System.out.println("Digite o nome do Bairro: ");
        System.out.print("Nome -> ");
        String bairro = ValidarEntrada.validarString();
        System.out.println("Digite a cidade: ");
        System.out.print("Nome -> ");
        String cidade = ValidarEntrada.validarString();
        Endereco endereco = new Endereco(rua,bairro,cidade);
        return endereco;
    }
    
}
