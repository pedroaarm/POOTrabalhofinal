/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoPessoas.cliente;

import GestaoPessoas.CadastroEndereco;
import GestaoPessoas.CadastroInformacoesPessoais;
import GestaoPessoas.Pessoa;
import GestaoPessoas.cliente.BancoDeDados.AdicionaCliente;
import TratamentodeErros.ValidarEntrada;
import Utilitarios.Cadastro;

/**
 *
 * @author pedro
 */
public class CadastroCliente   {

    public static void cadastroCliente(){
        
        RG rg = new RG();
        CadastroInformacoesPessoais cadastropessoal = new CadastroInformacoesPessoais();
        cadastropessoal.cadastroinformacoespessoais();
        rg.cadastroRG();
        Endereco endereco = CadastroEndereco.cadendereco();
        String enderecostring = endereco.toString();
        Cliente cliente = new Cliente(rg.getNumero(), cadastropessoal.getNome(),cadastropessoal.getCpf(),cadastropessoal.getTelefone(), endereco.toString(),0);
     
        AdicionaCliente.addcliente(cliente);
    }
    
}
