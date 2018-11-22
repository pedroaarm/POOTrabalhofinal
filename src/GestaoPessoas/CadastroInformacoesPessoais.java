/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoPessoas;


import TratamentodeErros.ValidarEntrada;

/**
 *
 * @author pedro
 */
public class CadastroInformacoesPessoais {
    private static String nome;
    private static String cpf;
    private static String telefone;
    
 public void cadastroinformacoespessoais(){
        
        System.out.println("---Cadastro Informacoes Pessoais---");
        System.out.println("Digite o nome: ");
        nome = ValidarEntrada.validarString();
        System.out.println("Digite o CPF: ");
        cpf = ValidarEntrada.validarString();
        System.out.println("Digite o numero do telefone: ");
        telefone = ValidarEntrada.validarString();
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
