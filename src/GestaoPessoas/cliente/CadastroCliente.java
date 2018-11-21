/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoPessoas.cliente;

import GestaoPessoas.Pessoa;
import TratamentodeErros.ValidarEntrada;
import Utilitarios.Cadastro;

/**
 *
 * @author pedro
 */
class CadastroCliente extends Pessoa   {

    public static Cliente cadastroCliente(){
        RG rg = new RG();
        
        System.out.println("---Cadastro Cliente---");
        System.out.println("Digite o nome: ");
        String nome = ValidarEntrada.validarString();
        System.out.println("Digite o CPF: ");
        String cpf = ValidarEntrada.validarString();
        rg.cadastroRG();
        System.out.println("Digite o numero do telefone: ");
        String telefone = ValidarEntrada.validarString();
        Endereco endereco = cadastroEndereco();
        String enderecostring = endereco.toString();
        Cliente cliente = new Cliente(rg, nome,cpf,telefone, enderecostring);
        
       return cliente;
       
    }
    
    public static Endereco cadastroEndereco() {
      
        System.out.println("---Cadastro de Endereco---");
        System.out.println("Digite o nome da rua: ");
        String rua = ValidarEntrada.validarString();
        System.out.println("Digite o nome do Bairro: ");
        String bairro = ValidarEntrada.validarString();
        System.out.println("Digite a cidade: ");
        String cidade = ValidarEntrada.validarString();
        
        Endereco endereco = new Endereco(rua,bairro,cidade);
        return endereco;
    }
}
