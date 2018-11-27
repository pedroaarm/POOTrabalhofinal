/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import Departamentos.BancoDeDados.ArraydeDados_Departamento;
import Departamentos.BancoDeDados.CriarBD_departamentos;
import Departamentos.BancoDeDados.CriarConexao_Departamento;
import GestaoPessoas.cliente.BancoDeDados.ArrayDeDados_Cliente;
import GestaoPessoas.cliente.BancoDeDados.CriarBD_Cliente;
import GestaoPessoas.funcionario.BancoDedadosFuncionario.ArrayDeDados_Funcionario;
import GestaoPessoas.funcionario.BancoDedadosFuncionario.CriarConexao_Funcionario;
import GestaoPessoas.funcionario.BancoDedadosFuncionario.CriarBD_Funcionario;
import Produtos.BancoDeDados.ArrayDeDados_Produtos;
import Produtos.BancoDeDados.CriarBanco_Produtos;
import Venda.BancoDeDados.BDTabelaComprasParceladas;
import Venda.BancoDeDados.BDTabelaVendasMistas;
import Venda.BancoDeDados.CriaBdVenda;
import Venda.BancoDeDados.CriaConexaoVendas;

/**
 *
 * @author pedro
 */
public class InicializarDados {
    public static void inicializar(){
             CriarBanco_Produtos.criarTab();
        CriarBD_Cliente.criarTab(); 
        CriarBD_departamentos BdDep = new CriarBD_departamentos();
       CriarConexao_Departamento conexaoDp = new CriarConexao_Departamento();
        CriarBD_departamentos.criarTab();
        conexaoDp.conectar();
        
        
         ArraydeDados_Departamento.inicializarArrayDepartamento();
         ArrayDeDados_Produtos.inicializarArrayProdutos();
         ArrayDeDados_Cliente.InicializararrayCliente();
         CriarBD_Funcionario.criarTab();
         CriarConexao_Funcionario conexaofunc = new CriarConexao_Funcionario();
         ArrayDeDados_Funcionario.inicializarArrayFuncionario();
         CriaBdVenda.criarTab();
         CriaConexaoVendas conexaovendas = new CriaConexaoVendas();
         conexaovendas.conectar();
         BDTabelaComprasParceladas.criarTab();
         BDTabelaVendasMistas.criarTab();
         
         
                 
         
    }
    
}
