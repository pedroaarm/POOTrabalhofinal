/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoPessoas.funcionario;

import GestaoPessoas.cliente.Endereco;
import GestaoPessoas.Pessoa;

/**
 *
 * @author pedro
 */
public class Funcionario extends Pessoa {
    
    private float salario;
    private int jornadaTrabalho;
    private int IDfuncionario;

     public Funcionario(float salario, int jornadaTrabalho, String nome, String CPF, String telefone, String endereco) {
        super(nome, CPF, telefone, endereco);
        this.salario = salario;
        this.jornadaTrabalho = jornadaTrabalho;
    }
    
    public Funcionario(float salario, int jornadaTrabalho, int IDfuncionario, String nome, String CPF, String telefone, String endereco) {
        super(nome, CPF, telefone, endereco);
        this.salario = salario;
        this.jornadaTrabalho = jornadaTrabalho;
        this.IDfuncionario = IDfuncionario;
    }

    public Funcionario(float salario, int jornadaTrabalho, int IDfuncionario) {
        this.salario = salario;
        this.jornadaTrabalho = jornadaTrabalho;
        this.IDfuncionario = IDfuncionario;
    }

    public Funcionario() {
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getJornadaTrabalho() {
        return jornadaTrabalho;
    }

    public void setJornadaTrabalho(int jornadaTrabalho) {
        this.jornadaTrabalho = jornadaTrabalho;
    }

    public int getIDfuncionario() {
        return IDfuncionario;
    }

    public void setIDfuncionario(int IDfuncionario) {
        this.IDfuncionario = IDfuncionario;
    }
    
    
}
