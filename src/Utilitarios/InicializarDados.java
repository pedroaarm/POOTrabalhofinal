/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import Departamentos.BancoDeDados.ArraydeDadosDepartamento;
import Produtos.BancoDeDados.ArrayDeDadosProdutos;

/**
 *
 * @author pedro
 */
public class InicializarDados {
    public static void inicializar(){
        
         ArraydeDadosDepartamento.inicializarArrayDepartamento();
         ArrayDeDadosProdutos.inicializarArrayProdutos();
    }
    
}
