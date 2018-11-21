/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import Departamentos.BancoDeDados.ArraydeDadosDepartamento;
import static Departamentos.BancoDeDados.ArraydeDadosDepartamento.Hashdepartamento;
import java.util.Map;

/**
Essa Classe serva para saber se existe algum departamento com o nome que esta tentando ser cadastrado.
 */
public class ValidarNovoDepartamento {

    public ValidarNovoDepartamento() {
    }
    
    /**
     * 
     * 
     * 
   * @param nome esse paramentro é o nome do departamento que o cliente deseja buscar.
     * @return Retorna true caso o departamento seja encontrado, ou false caso o departamento não exista no banco de dados. 
     */
   public static boolean validar(String nome){
       
        //Saber se o departamento existe;
        
            for (int i=0;i<ArraydeDadosDepartamento.Hashdepartamento.size();i++){
                    for (Map.Entry<Integer,String> hashdp : Hashdepartamento.entrySet()) {
                        if (hashdp.getValue().equals(nome)){
                            return false;
                        }
                    }
         
        
            }
        return true;   
}
}