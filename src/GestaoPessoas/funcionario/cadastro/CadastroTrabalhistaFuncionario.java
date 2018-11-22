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
    public void cadastrotrabalhistas(){
        System.out.println("---Cadastro Trabalhista---");
        System.out.println("Digite o salário: ");
        salario = ValidarEntrada.validarFloat();
        System.out.println("Digite a jornada de Trabalho");
        jornadadetrabalho = ValidarEntrada.validarInteiro();
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
