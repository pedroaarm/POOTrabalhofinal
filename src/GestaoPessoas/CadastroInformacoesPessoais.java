/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoPessoas;


import TratamentodeErros.ValidarDocumento;
import TratamentodeErros.ValidarEntrada;

/**Esse metodo faz o cadastro de informacoes pessoas
 *
 * @author pedro
 */
public class CadastroInformacoesPessoais {
    
    private static String nome; 
    private static String cpf;
    private static String telefone;
    
   /**Aqui é pedido as informações e passado para o Gets
    * 
    */
 public void cadastroinformacoespessoais(){
        boolean verifica = false;
        System.out.println("\n\t***Cadastro Informacoes Pessoais***\n");
        System.out.println("Digite o nome: ");
        System.out.print("Nome -> ");
        nome = ValidarEntrada.validarString();
        System.out.println("Digite o CPF: ");
        System.out.print("CPF -> ");
        do{
        cpf = ValidarEntrada.validarString();
        verifica = ValidarDocumento.SoTemNumeros(cpf);
            if(verifica == false){
                System.out.println("CPF invalido, coloque apenas numeros");
            }
            }while(verifica == false);
        verifica = false;
        System.out.println("Digite o numero do telefone: ");
        do{
  
        System.out.print("Numero -> ");
        telefone = ValidarEntrada.validarString();
        verifica = ValidarDocumento.SoTemNumeros(telefone);
        if(verifica == false){
                System.out.println("Telefone invalido, coloque apenas numeros");
            }
        
        }while(verifica == false);
        
 }

    public  String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        CadastroInformacoesPessoais.nome = nome;
    }

    public  String getCpf() {
        return cpf;
    }

    public static void setCpf(String cpf) {
        CadastroInformacoesPessoais.cpf = cpf;
    }

    public  String getTelefone() {
        return telefone;
    }

    public static void setTelefone(String telefone) {
        CadastroInformacoesPessoais.telefone = telefone;
    }
 
 
    
}
