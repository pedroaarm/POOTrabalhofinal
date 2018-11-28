/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoPessoas.funcionario;

import GestaoPessoas.funcionario.BancoDedadosFuncionario.ArrayDeDados_Funcionario;
import TratamentodeErros.ValidarEntrada;
import java.io.IOException;

/**Gera o ContraCheque do funcionario de acordo com o tempo que ele trabalhou fazendo o calculo junto com o tempo cadastrado no sistema
 *
 * @author pedro
 */
public class GerarContraCheque {
    public static void gerarcontracheque(int id) throws IOException{
        Funcionario funcionario =ArrayDeDados_Funcionario.retornafuncionario(id); //  cria um objeto de funcionario
        System.out.println("Digite a quantidad de Horas que o funcionario trabalhou: ");
        System.out.print("horas -> ");
        Integer horas = ValidarEntrada.validarInteiro();
        float salario = (funcionario.getSalario()/funcionario.getJornadaTrabalho())*horas;
            System.out.println("\n\t***CONTRACHEQUE***\n");
            System.out.println("Nome: "+funcionario.getNome());
            System.out.println("ID: "+funcionario.getIDfuncionario());
            System.out.println("CPF: "+funcionario.getCPF());
            System.out.println("Salario"+salario);
            
           System.out.println("\n\nPressione Enter para continuar...");
            System.in.read(); 

    }
    
}
