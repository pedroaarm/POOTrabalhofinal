/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import TratamentodeErros.ValidarEntrada;
import java.util.Scanner;


/**
 * Essa Classe reune todos os menus utilizados nos Packge de Departamento, tendo mais o menos a mesma função.
 * Quando é mostrado as opções na tela, é pedido a opção, que leva o programa para a classe "Validar Entrada", onde o usuario vai digitar o valor e será verificado se esse valor é coeso.
 *
 * @author pedro
 */
public class Menus {
   
    /***
     * Menu Principal do programa.
     * 
     * @return Retorna a opção desejada, já verificado o tratamendo de erro.
     */
     public Integer MenuPrincipal() {
         int  opcao=0;
         int checar=0;
        
                         
            opcao = 0;
         System.out.println("\n  ==================================");
			System.out.println("  |     1 - Gestão de Produtos      |");
			System.out.println("  |     2 - Gestão de Vendas -Não implementado        |");
			System.out.println("  |     3 - Gestão de Pessoas  -NI     |");
			System.out.println("  |     0 - Sair    -- NI                |");
			System.out.println("  ===================================\n");
                        System.out.print(" Opção -> ");
                        opcao = ValidarEntrada.validaropcao();
         
         
        return opcao;
     }
     /**
      * 
      * Menu de Gestão de Departamento.
      * @return Retorna a opção desejada, já verificado o tratamendo de erro. 
      */
     public Integer MenuGestao(){
         
         int opcao =0;
         System.out.println("\n  ==================================");
			System.out.println("  |     1 - Adicionar Produtos         |");
			System.out.println("  |     2 - Buscar Produto             |");			
                        System.out.println("  |     3 - Remover Produtos  -        |");
			System.out.println("  |     4 - Editar Produto             |");
			System.out.println("  |     5 - Gestão de Departamentos    |");
			System.out.println("  |     0 - Voltar                     |");
			System.out.println("  ===================================\n");
                        System.out.print(" Opção -> ");
                        opcao = ValidarEntrada.validaropcao();
         
         return opcao;
     }
          public Integer MenuGestaoProdutoEditar(){
          int opcao =0;
         System.out.println("\n  ==================================");
         		System.out.println("  |     1 - Editar Nome            |");  
			System.out.println("  |     2 - Adicionar Estoque      |");
			System.out.println("  |     3 - Alterar Preço          |");                        
			System.out.println("  |     4 - Editar Descricao       |");
			System.out.println("  |     5 - Editar Referencia      |");
			System.out.println("  |     0 - Voltar                 |");
			System.out.println("  ===================================\n");
                        System.out.print(" Opção -> ");
                        opcao = ValidarEntrada.validaropcao();
         
         return opcao;
     }
     
     /**
      * Menu Gestor
      * 
      * @return Retorna a opção desejada, já verificado o tratamendo de erro. 
3      */
     public Integer MenuGestaoDepartamentos(){
          int opcao =0;
         System.out.println("\n  ==================================");
         		System.out.println("  |     1 - Adicionar Departamento |");  
			System.out.println("  |     2 - Mostrar Todos os Departamentos   |");
			System.out.println("  |     3 - Mostrar Departamento Especifico |");                        
			System.out.println("  |     4 - Editar Departamentos            |");
			System.out.println("  |     5 - Excluir Departamento            |");
			System.out.println("  |     0 - Voltar                            |");
			System.out.println("  ===================================\n");
                        System.out.print(" Opção -> ");
                        opcao = ValidarEntrada.validaropcao();
         
         return opcao;
     }
          public Integer Produtos() {
         int  opcao=0;
         int checar=0;
        
                         
            opcao = 0;
         System.out.println("\n  ==================================");
			System.out.println("  |     1 - Mostrar Todos os produtos      |");
			System.out.println("  |     2 - Buscar Produto Especifico        |");
			System.out.println("  |     0 - Sair    -- NI                |");
			System.out.println("  ===================================\n");
                        System.out.print(" Opção -> ");
                        opcao = ValidarEntrada.validaropcao();
         
         
        return opcao;
     }

               public Integer MenuGestaopessoas(){
         
         int opcao =0;
         System.out.println("\n  ==================================");
			System.out.println("  |     1 - Clientes        |");
			System.out.println("  |     2 - Funcionários    |");			
			System.out.println("  |     0 - Voltar          |");
			System.out.println("  ===================================\n");
                        System.out.print(" Opção -> ");
                        opcao = ValidarEntrada.validaropcao();
         
         return opcao;
     }
               
   public Integer MenuGestaopessoasCliente(){
         
         int opcao =0;
         System.out.println("\n  ==================================");
			System.out.println("  |     1 - Buscar Clientes    |");
			System.out.println("  |     2 - Adicionar Clientes |");
			System.out.println("  |     3 - Excluir Cliente    |");   
			System.out.println("  |     4 - Editar Cliente     |");                        
			System.out.println("  |     0 - Voltar             |");
			System.out.println("  ===================================\n");
                        System.out.print(" Opção -> ");
                        opcao = ValidarEntrada.validaropcao();
         
         return opcao;
     }
     
                                public Integer MenuGestaopessoasClienteBusca(){
         
         int opcao =0;
         System.out.println("\n  ==================================");
			System.out.println("  |     1 - Mostrar todos os clintes        |");
			System.out.println("  |     2 - Buscar Especifico    |");                      
			System.out.println("  |     0 - Voltar          |");
			System.out.println("  ===================================\n");
                        System.out.print(" Opção -> ");
                        opcao = ValidarEntrada.validaropcao();
         
         return opcao;
     }
                                  public Integer MenuGestaopessoasFuncionario(){
         
         int opcao =0;
         System.out.println("\n  ==================================");
			System.out.println("  |     1 - Buscar Funcionario    |");
			System.out.println("  |     2 - Adicionar Funcionario |");
			System.out.println("  |     3 - Excluir Funcionario   |");   
			System.out.println("  |     4 - Editar Funcionario    |");                        
			System.out.println("  |     0 - Voltar                |");
			System.out.println("  ===================================\n");
                        System.out.print(" Opção -> ");
                        opcao = ValidarEntrada.validaropcao();
         
         return opcao;
     } 
                                  public Integer MenuGestaopessoasFuncionarioBusca(){
         
         int opcao =0;
         System.out.println("\n  ==================================");
			System.out.println("  |     1 - Mostrar todos os Funcionarios    |");
			System.out.println("  |     2 - Buscar Funcionario Especifico    |");                      
			System.out.println("  |     0 - Voltar                           |");
			System.out.println("  ===================================\n");
                        System.out.print(" Opção -> ");
                        opcao = ValidarEntrada.validaropcao();
         
         return opcao;
     }
                                  
         public Integer MenuClienteEditar(){
          int opcao =0;
         System.out.println("\n  ==================================");
         		System.out.println("  |     1 - Editar Nome            |");  
			System.out.println("  |     2 - Editar CPF      |");
			System.out.println("  |     3 - Editar RG          |");                        
			System.out.println("  |     4 - Editar Endereco       |");
			System.out.println("  |     5 - Editar telefone      |");
			System.out.println("  |     0 - Voltar                 |");
			System.out.println("  ===================================\n");
                        System.out.print(" Opção -> ");
                        opcao = ValidarEntrada.validaropcao();
         
         return opcao;
     }
         
                  public Integer MenuFuncionarioEditar(){
          int opcao =0;
         System.out.println("\n  ==================================");
         		System.out.println("  |     1 - Editar Nome            |");  
			System.out.println("  |     2 - Editar CPF      |");
			System.out.println("  |     3 - Editar salario        |");     
                        System.out.println("  |     4 - Editar Jornada de trabalho        |");   
			System.out.println("  |     5 - Editar Endereco       |");
			System.out.println("  |     6 - Editar telefone      |");
			System.out.println("  |     0 - Voltar                 |");
			System.out.println("  ===================================\n");
                        System.out.print(" Opção -> ");
                        opcao = ValidarEntrada.validaropcao();
         
         return opcao;
     }
     
                  
                  
                                public Integer Menuvendas(){
          int opcao =0;
         System.out.println("\n  ==================================");
         		System.out.println("  |     1 - NOVA VENDA                        |");  
			System.out.println("  |     2 - Verificar Vendas nessa sessao     |");
			System.out.println("  |     3 - Dados de comprar por cliente      |");     
                        System.out.println("  |     4 - Editar Jornada de trabalho        |");   
			System.out.println("  |     5 - Editar Endereco                   |");
			System.out.println("  |     6 - Editar telefone                   |");
			System.out.println("  |     0 - Voltar                            |");
			System.out.println("  ===================================\n");
                        System.out.print(" Opção -> ");
                        opcao = ValidarEntrada.validaropcao();
         
         return opcao;
     }
                                
     public Integer MenuEscolhaproduto(){
          int opcao =0;
         System.out.println("\n  ==================================");
         		System.out.println("  |     1 -Colocar um produto no carrinho    |");  
			System.out.println("  |     2 -Mostrar Produtos no carrinho      |");
			System.out.println("  |     3 -Remover Produto do carrinho     |");   
                        System.out.println("  |     4 -FINALIZAR COMPRA     |"); 
                         System.out.println("  |    5 - cancelar compra     |"); 
                        System.out.println("  |     0 -Sair                              |");
                         System.out.println("\n  ==================================");
                        System.out.print(" Opção -> ");
                        opcao = ValidarEntrada.validaropcao();
         
         return opcao;
     }
     
     
     
}