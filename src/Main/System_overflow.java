/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Utilitarios.Menus;
import Departamentos.BancoDeDados.Criar_BD_departamentos;
import Departamentos.BancoDeDados.Criar_Conexao_Departamento;
import TratamentodeErros.ValidarEntrada;
import Departamentos.BancoDeDados.ArraydeDadosDepartamento;
import Produtos.BancoDeDados.ArrayDeDadosProdutos;
import Produtos.BancoDeDados.CriarBancoProdutos;
import Produtos.Cadastro.CadastroProduto;
import Utilitarios.InicializarDados;
import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimerTask;
import GestaoPessoas.cliente.BancoDeDados.CriarBancodeDados_Cliente;

/**
 *
 * @author pedro
 */
public class System_overflow {

    static Scanner in = new Scanner (System.in);
    public static void main(String[] args) {
     
     CriarBancoProdutos.criarTab();
    Menus acessorios = new Menus();
    Integer opcao=0;  
        Criar_BD_departamentos BdDep = new Criar_BD_departamentos();
       Criar_Conexao_Departamento conexaoDp = new Criar_Conexao_Departamento();
        Criar_BD_departamentos.criarTab();
        conexaoDp.conectar();
        InicializarDados.inicializar();
        CriarBancodeDados_Cliente.criarTab();
                
  

     // conexaoDp.CriarStatement();
      // Criar_BD_departamentos.criarTab();
        System.out.println("\n\n### System Overflow - Sistema Comercial de Controle de Compras e Vendas ###");
			
                        
                do{
                  opcao = acessorios.MenuPrincipal(); //Menu Principal
                    System.out.println("A opção foi: "+opcao);
                    
                    switch (opcao){
                   
                        case 1:
                            int interno;
                        
                                do{
                                     interno= acessorios.MenuGestao();//Entrando na opção de gestão
                                switch(interno){
                                    case 1:
                                        CadastroProduto.cadastro();
                                        break;
                                    case 2:
                                        int gerenciaprotudos;
                                            do{
                                                gerenciaprotudos = acessorios.Produtos();
                                            
                                                switch (gerenciaprotudos){
                                                    case 1:
                                                         ArrayDeDadosProdutos.imprimirArryProdutos();
                                                         break;
                                                    case 2:
                                                        System.out.println("Digite o nome do produto: ");
                                                        String nproduto = in.nextLine();
                                                        ArrayDeDadosProdutos.buscarProdutoNome(nproduto);
                                                        break;
                                                }
                                            }while (gerenciaprotudos!=0);
                                            
                                        break;
                                    case 3:
                                        int excluir=0;
                                        do{
                                        System.out.printf("\nDigite 1 - Para ver os produtos | 2 - Excluir produto | 3- Voltar\nOpção:");
                                        excluir = ValidarEntrada.validaropcao();
                                            switch(excluir){
                                                case 1:
                                                    ArrayDeDadosProdutos.imprimirArryProdutos();
                                                    break;
                                                case 2:
                                                    System.out.println("Digite o ID do produto: ");
                                                    int idproduto = ValidarEntrada.validarInteiro();
                                                    boolean verifica = ArrayDeDadosProdutos.verificarexistencia(idproduto);
                                                    if(verifica == true){
                                                    ArrayDeDadosProdutos.exluirProduto(idproduto);
                                                    }else{
                                                        System.out.println("Produto não encontrado");
                                                    }
                                                    break;
                                            }
                                        }while (excluir!=0);
                                            

                                    case 4: 
                                     int internogestao;
                                            do{
                                       internogestao = acessorios.MenuGestaoDepartamentos();
                                             switch (internogestao){
                                                 case 1:
                                                     ArraydeDadosDepartamento.imprimirTodosDepartamentos();
                                                     break;
                                                 case 2:
                                                     System.out.println("Digite o nome do departamendo que deseja buscar: ");
                                                     String nome = ValidarEntrada.validarString();
                                                     ArraydeDadosDepartamento.buscarDpNome(nome);
                                                     break;
                                                 case 3:
                                                      System.out.println("Digite o nome do departamendo que deseja editar: ");
                                                     String nomeeditar = ValidarEntrada.validarString();
                                                     ArraydeDadosDepartamento.editardp(nomeeditar);
                                                     break;
                                                 case 4:
                                                     System.out.println("Digite o nome do departamento que deseja excluir: ");
                                                     String nomeexcluir = ValidarEntrada.validarString();
                                                     ArraydeDadosDepartamento.excluirdepartamento(nomeexcluir);
                                                     break;
                                                  default:
                                                  System.out.println("Opção inválida");
                                                    break;
                                             }
                                            }while (internogestao!=0);
                                            break;
                                }
                                }while (interno!=0);
                            
                           
                          break;  
                        
                    }
                    
                }while (opcao !=0);  
     
    }
                   
               
}

    

