
package Departamentos;

import java.util.ArrayList;
import java.util.Scanner;


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
    public Integer sizedep(){
        return departamento.size();
    }
    
    public void mostrarDepartamentos(){
        for (Departamento departamento1 : departamento) {
            System.out.println("Código: "+departamento1.getCodigo()+"| Nome: "+departamento1.getNome());
        }
        
        
        
    }

        
}
