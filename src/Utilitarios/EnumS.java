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
public enum EnumS {
   Welcome("SEJA BEM VINDO!"),
   Bay("ATE A PROXIMA!");

   private String descricao;
   EnumS(String descricao) {
        this.descricao = descricao;
    }
 
    public String getDescricao() {
        return descricao;
    }


    }
