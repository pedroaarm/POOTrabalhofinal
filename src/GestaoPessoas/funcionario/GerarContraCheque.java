/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoPessoas.funcionario;

import GestaoPessoas.funcionario.BancoDedadosFuncionario.ArrayFuncionario;

/**
 *
 * @author pedro
 */
public class GerarContraCheque {
    public static void gerarcontracheque(int id){
        Funcionario funcionario =ArrayFuncionario.retornafuncionario(id);
        
            System.out.println("---CONTRACHEQUE---");
            System.out.println("Nome: "+funcionario.getNome());
            System.out.println("ID: "+funcionario.getIDfuncionario());
            System.out.println("CPF: "+funcionario.getCPF());
            System.out.println("Salario"+funcionario.getSalario());
            System.out.println("Horas Trabalhadas:"+funcionario.getJornadaTrabalho());
    }
    
}
