/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import Departamentos.BancoDeDados.ArraydeDadosDepartamento;
import Departamentos.BancoDeDados.Criar_BD_departamentos;
import Departamentos.BancoDeDados.Criar_Conexao_Departamento;
import GestaoPessoas.cliente.BancoDeDados.ArrayDadosCliente;
import GestaoPessoas.cliente.BancoDeDados.CriarBancodeDados_Cliente;
import GestaoPessoas.funcionario.BancoDedadosFuncionario.ConexaoFuncionario;
import GestaoPessoas.funcionario.BancoDedadosFuncionario.CriarTabelaFuncionario;
import Produtos.BancoDeDados.ArrayDeDadosProdutos;
import Produtos.BancoDeDados.CriarBancoProdutos;

/**
 *
 * @author pedro
 */
public class InicializarDados {
    public static void inicializar(){
             CriarBancoProdutos.criarTab();
        
        Criar_BD_departamentos BdDep = new Criar_BD_departamentos();
       Criar_Conexao_Departamento conexaoDp = new Criar_Conexao_Departamento();
        Criar_BD_departamentos.criarTab();
        conexaoDp.conectar();

        CriarBancodeDados_Cliente.criarTab(); 
         ArraydeDadosDepartamento.inicializarArrayDepartamento();
         ArrayDeDadosProdutos.inicializarArrayProdutos();
         ArrayDadosCliente.InicializararrayCliente();
         CriarTabelaFuncionario.criarTab();
         ConexaoFuncionario conexaofunc = new ConexaoFuncionario();
         
    }
    
}
