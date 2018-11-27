
package Departamentos;

import java.util.ArrayList;
import java.util.Scanner;

/** Essa classe serve como objeto para a criacão de derpartamentos.
@autor pedro
* 

*/

public class Departamento {
    Scanner in = new Scanner (System.in); 
    private String Nome;
    private Integer codigo;
    
    public ArrayList <Departamento> departamento = new ArrayList<>();

    public Departamento() {
    }

    public Departamento(String Nome, Integer codigo) {
        this.Nome = Nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    //retorna 
  
    

    
        
        
    }

