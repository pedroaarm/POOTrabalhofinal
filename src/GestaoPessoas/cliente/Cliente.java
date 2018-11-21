/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoPessoas.cliente;

import GestaoPessoas.Pessoa;

/**
 *
 * @author pedro
 */
public class Cliente extends Pessoa {
    
    private int idcliente;
    private RG rg;

    public Cliente() {
    }

    public Cliente(RG rg, String nome, String CPF, String telefone, String endereco) {
        super(nome, CPF, telefone, endereco);
        this.rg = rg;
    }

    public Cliente(RG rg) {
        this.rg = rg;
    }

    
    
    public Cliente(int idcliente, String email, RG rg, String nome, String CPF, String telefone, String endereco) {
        super(nome, CPF, telefone, endereco);
        this.idcliente = idcliente;

        this.rg = rg;
    }

    public Cliente(int idcliente, String email, RG rg) {
        this.idcliente = idcliente;
        this.rg = rg;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public RG getRg() {
        return rg;
    }

    public void setRg(RG rg) {
        this.rg = rg;
    }
}
    
   