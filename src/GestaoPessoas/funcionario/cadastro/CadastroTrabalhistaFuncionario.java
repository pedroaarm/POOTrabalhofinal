/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoPessoas.funcionario.cadastro;

import TratamentodeErros.ValidarEntrada;


/**
 *
 * @author pedro
 */
public class CadastroTrabalhistaFuncionario {
    private float salario;
    private int jornadadetrabalho;
    private String funcao; 
    public void cadastrotrabalhistas(){
        
        System.out.println("---Cadastro Trabalhista---");
        System.out.println("Digite a Funcao: ");
       funcao = ValidarEntrada.validarString();
        System.out.println("Digite o salário: ");
        salario = ValidarEntrada.validarFloat();
        System.out.println("Digite a jornada de Trabalho");
        jornadadetrabalho = ValidarEntrada.validarInteiro();
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
    

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getJornadadetrabalho() {
        return jornadadetrabalho;
    }

    public void setJornadadetrabalho(int jornadadetrabalho) {
        this.jornadadetrabalho = jornadadetrabalho;
    }
    
    
}
