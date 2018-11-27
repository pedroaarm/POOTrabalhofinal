/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoPessoas.cliente;

import GestaoPessoas.CadastroEndereco;
import GestaoPessoas.CadastroInformacoesPessoais;
import GestaoPessoas.cliente.BancoDeDados.AdicionaCliente;


/**Aqui é feito o cadastro do cliente
 *
 * @author pedro
 */
public class CadastroCliente   {
    /**Nesse metodo é clamadas e instanciada todas as classes necessarias para obter informações suficientes para o cadastro de clientes
     * 
     */

    public static void cadastroCliente(){
        
        RG rg = new RG();
        CadastroInformacoesPessoais cadastropessoal = new CadastroInformacoesPessoais();
        cadastropessoal.cadastroinformacoespessoais();
        rg.cadastroRG();
        Endereco endereco = CadastroEndereco.cadendereco();
        Cliente cliente = new Cliente(rg.getNumero(), cadastropessoal.getNome(),cadastropessoal.getCpf(),cadastropessoal.getTelefone(), endereco.toString(),0);
     
        AdicionaCliente.addcliente(cliente);
    }
    
}
