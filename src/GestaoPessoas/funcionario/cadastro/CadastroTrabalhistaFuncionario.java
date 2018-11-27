/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoPessoas.funcionario.cadastro;

import TratamentodeErros.ValidarEntrada;


/**Nessa classe tem as informações Trabalhistas (salario,funcao,etc), também faz o cadastros das mesmas
 *
 * @author pedro
 */
public class CadastroTrabalhistaFuncionario {
    private float salario;
    private int jornadadetrabalho;
    private String funcao; 
    
    
    /**Pede as informacoes sobre as informacoes atrabalhistas
     * 
     */
    public void cadastrotrabalhistas(){
        
        System.out.println("---Cadastro Trabalhista---");
        System.out.println("Digite a Funcao: ");
        System.out.print("Funcao ->");
       funcao = ValidarEntrada.validarString();
        System.out.println("\nDigite o salário: ");
        System.out.print("Salario ->");
        salario = ValidarEntrada.validarFloat();
        System.out.println("Digite a jornada de Trabalho");
        System.out.print("JT ->");
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
