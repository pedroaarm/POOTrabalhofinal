/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoPessoas.funcionario;


import GestaoPessoas.Pessoa;

/**Objeto de funcionarios
 *
 * @author pedro
 */
public class Funcionario extends Pessoa {
    
    private float salario;
    private int jornadaTrabalho;
    private int IDfuncionario;
    private String funcao;

     public Funcionario(float salario, int jornadaTrabalho, String nome, String CPF, String telefone, String endereco, String funcao) {
        super(nome, CPF, telefone, endereco);
        this.salario = salario;
        this.jornadaTrabalho = jornadaTrabalho;
        this.funcao = funcao;
    }
    
    public Funcionario(float salario, int jornadaTrabalho, int IDfuncionario, String nome, String CPF, String telefone, String endereco,String funcao) {
        super(nome, CPF, telefone, endereco);
        this.salario = salario;
        this.jornadaTrabalho = jornadaTrabalho;
        this.IDfuncionario = IDfuncionario;
        this.funcao = funcao;
    }

    public Funcionario(float salario, int jornadaTrabalho, int IDfuncionario) {
        this.salario = salario;
        this.jornadaTrabalho = jornadaTrabalho;
        this.IDfuncionario = IDfuncionario;
    }

    public Funcionario() {
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
