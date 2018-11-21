/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Departamentos;

import TratamentodeErros.ValidarEntrada;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class Operações {
    
            void pesquisardepartamento(ArrayList<Departamento> departamento){
            System.out.println("Digite o nome do departamento: ");
            String nomedp = ValidarEntrada.validarString();
            for (Departamento departamento1 : departamento) {
                if(nomedp.equals(departamento1.getNome())){
                    System.out.println("Código: "+departamento1.getCodigo()+" Nome: "+departamento1.getNome());
                }
                
            }
        }
    
}
