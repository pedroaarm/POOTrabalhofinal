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
    
    private int idcliente=0;
    private String rg;
    private Integer pontos;

    public Cliente() {
    }

    public Cliente(String rg, String nome, String CPF, String telefone, String endereco, Integer pontos) {
        super(nome, CPF, telefone, endereco);
        this.rg = rg;
        this.pontos = pontos;
    }

    public Cliente(String rg) {
        this.rg = rg;
    }

    public Cliente(int idcliente, String rg, String nome, String CPF, String telefone, String endereco, Integer pontos) {
        super(nome, CPF, telefone, endereco);
        this.idcliente = idcliente;
        this.rg = rg;
        this.pontos = pontos;
    }

    public Cliente(int idcliente, String rg) {
        this.idcliente = idcliente;
        this.rg = rg;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    
    
   

    public Cliente(int idcliente, String email, String rg) {
        this.idcliente = idcliente;
        this.rg = rg;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
    
   