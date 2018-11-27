/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

/**
 *
 * @author pedro
 */
public enum Saudacao {
   SAUDACAO("sEJA BEM VINDO!");

   private String descricao;
   Saudacao(String descricao) {
        this.descricao = descricao;
    }
 
    public String getDescricao() {
        return descricao;
    }


    }
