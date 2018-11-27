package Main;

import Utilitarios.Menus;

import TratamentodeErros.ValidarEntrada;
import Departamentos.BancoDeDados.ArraydeDados_Departamento;
import Departamentos.CadastroDepartamento;
import GestaoPessoas.cliente.BancoDeDados.ArrayDeDados_Cliente;
import Produtos.BancoDeDados.ArrayDeDados_Produtos;
import Produtos.Cadastro.CadastroProduto;
import Utilitarios.InicializarDados;
import java.util.Scanner;
import GestaoPessoas.cliente.CadastroCliente;
import GestaoPessoas.funcionario.BancoDedadosFuncionario.ArrayDeDados_Funcionario;
import GestaoPessoas.funcionario.GerarContraCheque;
import GestaoPessoas.funcionario.cadastro.CadastroFuncionario;
import Utilitarios.EnumS;
import Venda.CancelarVenda;
import Venda.ControleVendas;
import Venda.EncerrarCompra;
import Venda.VendasPorcliente;
import Venda.Vender;
import java.io.IOException;
import java.sql.SQLException;

/**Classe Principal onde são utilizadas todos as classes e metodos do programa
 *
 * @author pedro
 */
public class System_overflow {

    static Scanner in = new Scanner (System.in);
    public static void main(String[] args) throws IOException, SQLException {
             InicializarDados.inicializar();
//Atentear para os possiveis erros de inicialização
    Menus acessorios = new Menus();
    Integer opcao=0;  
  
     // conexaoDp.CriarStatement();
      // Criar_BD_departamentos.criarTab();
        System.out.println("\n\n### System Overflow - Sistema Comercial de Controle de Compras e Vendas ###");
			     System.out.println(EnumS.SAUDACAO);
                        
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
                                        //cadastro dos produtos
                                        CadastroProduto.cadastro();
                                        break;
                                    case 2:
                                        int gerenciaprotudos;
                                            do{
                                                    
                                                gerenciaprotudos = acessorios.Produtos();
                                            
                                                switch (gerenciaprotudos){
                                                    case 1:
                                                        //imprime os produtos cadastrados
                                                         ArrayDeDados_Produtos.imprimirArryProdutos();
                                                         break;
                                                    case 2:
                                                       //procura um produto
                                                        int nproduto;
                                                         boolean produtoexiste;
                                                        do{
                                                        System.out.println("Digite o id do produto: ");
                                                        nproduto = ValidarEntrada.validarInteiro();
                                                        produtoexiste = ArrayDeDados_Produtos.verificarexistencia(nproduto);
                                                        if(produtoexiste == true){
                                                        ArrayDeDados_Produtos.buscarProdutoNome(nproduto);
                                                System.out.println("Pressione Enter para continuar...");
                                                System.in.read();
                                                        }else{
                                                            System.out.println("Produto não encontrado");
                                                        }
                                                        }while (produtoexiste == false);
                                                        break;
                                                }
                                            }while (gerenciaprotudos!=0);
                                            
                                        break;
                                    case 3:
                                        int excluir=0;
                                        do{
                                            //excluir produtos
                                        System.out.println("\nDigite 1-Para ver os produtos | 2-Excluir produto | 0-Voltar");
                                        System.out.print(" Opção -> ");
                                        excluir = ValidarEntrada.validaropcao();
                                        if(excluir!=0){
                                            switch(excluir){
                                                case 1:
                                                    ArrayDeDados_Produtos.imprimirArryProdutos();
                                                System.out.println("Pressione Enter para continuar...");
                                                System.in.read();
                                                    break;
                                                case 2:
                                                    System.out.println("Digite o ID do produto: ");
                                                    int idproduto = ValidarEntrada.validarInteiro();
                                                    boolean verifica = ArrayDeDados_Produtos.verificarexistencia(idproduto);
                                                    if(verifica == true){
                                                    ArrayDeDados_Produtos.exluirProduto(idproduto);
                                                       
                                               System.out.println("Pressione Enter para continuar...");
                                                System.in.read();
                                                break;
                                                    }else{
                                                        System.out.println("Produto não encontrado");
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("Opcao inválida!");
                                            }
                                        }
                                        }while (excluir!=0);
                                        
                                            break;
                                    case 4:
                                        //editar produtos
                                       int editarproduto;
                                        System.out.println("Digite o Id do produto");
                                        System.out.print("ID ->");
                                        int id = ValidarEntrada.validarInteiro();
                                       do{
                                          
                                           editarproduto = acessorios.MenuGestaoProdutoEditar();
                                           System.out.println("Pressione Enter para continuar...");
                                            System.in.read();
                                               
                                              if(editarproduto != 0){
                                           ArrayDeDados_Produtos.editarProduto(editarproduto,id);
                                              }
                                         
                                       
                                       }while (editarproduto != 0);
                                       break;
                                    case 5: 
                                        //Gestão de Departamento 
                                     int internogestao;
                                            do{
                                       internogestao = acessorios.MenuGestaoDepartamentos();
                                             switch (internogestao){
                                                 case 1:
                                                     CadastroDepartamento.cadastrar();
                                                System.out.println("Pressione Enter para continuar...");
                                                System.in.read();
                                                     break;
                                                 case 2:
                                                     ArraydeDados_Departamento.imprimirTodosDepartamentos();
                                                     break;
                                                 case 3:
                                                     System.out.println("\nDigite o ID do departamendo que deseja buscar: ");
                                                     System.out.print("ID ->");
                                                     int idbusca = ValidarEntrada.validarInteiro();
                                                     ArraydeDados_Departamento.buscarDPId(idbusca);
                                                 System.out.println("Pressione Enter para continuar...");
                                                System.in.read();
                                                     break;
                                                 case 4:
                                                      System.out.println("\nDigite o ID do departamendo que deseja editar: ");
                                                      System.out.print("ID ->");
                                                     int nomeeditar = ValidarEntrada.validarInteiro();
                                                     ArraydeDados_Departamento.editardp(nomeeditar);
                                                     break;
                                                 case 5:
                                                     System.out.println("\nDigite o ID do departamento que deseja excluir: ");
                                                     System.out.print("ID ->");
                                                     int nomeexcluir = ValidarEntrada.validarInteiro();
                                                     ArraydeDados_Departamento.excluirdepartamento(nomeexcluir);
                                                System.out.println("Pressione Enter para continuar...");
                                                System.in.read();  
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
                        case 2:
                            int opcaovendas;
                            
                            do{
                                opcaovendas = acessorios.Menuvendas();
                                 int op1;
                                switch (opcaovendas){
                                   
                                    case 1:
                                        do{
                                        op1  = acessorios.MenuEscolhaproduto();
                                        switch(op1){
                                            
                                            case 1:
                                                Vender.venda();
                                                break;
                                            case 2:
                                                ControleVendas.mostrarcarrinho();
                                                System.out.println("Pressione Enter para continuar...");
                                                System.in.read();  
                                                break;
                                            case 3:
                                                System.out.println("\nDigite o id do produto: ");
                                                System.out.print("ID -> ");
                                                int idprodutoremover = ValidarEntrada.validarInteiro();
                                                ControleVendas.removerprodutocarrinho(idprodutoremover);
                                                ControleVendas.mostrarcarrinho();
                                                System.out.println("Pressione Enter para continuar...");
                                                break;
                                            case 4:
                                                EncerrarCompra.encerrar();
                                                break;
                                            case 5:
                                                CancelarVenda.cancelar();
                                                op1 = 0;
                                                break;
                                        }
                                        }while (op1!=0);
                                        break;
                                    case 2:

                                        int idcliente;
                                         boolean sabexexiste; 
                                       do{
                                           System.out.println("\nDigite o ID do cliente: ");
                                           System.out.print("ID ->");
                                        idcliente = ValidarEntrada.validarInteiro();
                                       
                                         sabexexiste = ArrayDeDados_Cliente.verificarexistenciacliente(idcliente);
                                            if(sabexexiste == true){
                                                
                                                VendasPorcliente.vendascliente(idcliente);
                                                 System.out.println("Pressione Enter para continuar...");
                                                System.in.read(); 
                                                
                                            }else{
                                                System.out.println("Cliente nao encontrado!");
                                            }
                                         
                                       }while (sabexexiste == false);

                                break;
                                
                            }}while (opcaovendas!=0);
                                System.out.println("sair");
                            break;

                        case 3:
                            int op ;
                            do{
                                //Meunu Gestão de pessoas;
                               op = acessorios.MenuGestaopessoas();
                               switch(op){
                                   case 1:
                                       int opgcliente;
                                       opgcliente = acessorios.MenuGestaopessoasCliente();
                                   switch(opgcliente){
                                       case 1:
                                           int clientebusca;
                                           do{
                                               clientebusca = acessorios.MenuGestaopessoasClienteBusca();
                                               switch(clientebusca){
                                                   case 1:
                                                       System.out.println("\n\n");
                                                       ArrayDeDados_Cliente.imprimirArrayCliente();
                                                        System.out.println("\n\nPressione Enter para continuar...");
                                                System.in.read(); 
                                                       break;
                                                   case 2:
                                                       boolean existeverifica;
                                                       System.out.println("\nDigite o ID do Cliente: ");
                                                       System.out.print("ID -> ");
                                                       int idcliente = ValidarEntrada.validarInteiro();
                                                      existeverifica = ArrayDeDados_Cliente.verificarexistenciacliente(idcliente);
                                                      if(existeverifica == true){
                                                      ArrayDeDados_Cliente.buscarClienteID(idcliente);                                                       System.out.println("\n\n");
 
                                                        System.out.println("\n\nPressione Enter para continuar...");
                                                        System.in.read();
                                                      
                                                      }else{
                                                          System.out.println("Cliente nao encontrado");
                                                      }
                                                       break;
                                                   
                                               }
                                           }while(clientebusca != 0);
                                           break;
                                       case 2:
                                         CadastroCliente.cadastroCliente();
                                           break;
                                        case 3:
                                               int opc;
                                                       
                                               do{
                                              System.out.println("---Excluir Cliente---");
                                              System.out.println("\nDigite: 1 - Ver os clientes cadastrados | 2 - Excluir pelo ID do cliente | 0 - Voltar: ");
                                              System.out.print("Opcao -> ");
                                                     
                                                               opc = ValidarEntrada.validaropcao();
                                                       
                                                        switch(opc){
                                                            case 1:
                                                                System.out.println("\n\n");
                                                                ArrayDeDados_Cliente.imprimirArrayCliente();
                                                                 System.out.println("Pressione Enter para continuar...");
                                                                 System.in.read(); 
                                                                break;
                                                            case 2:
                                                                System.out.println("\nDigite o ID do cliente: ");
                                                                System.out.print("ID -> ");
                                                                int id = ValidarEntrada.validarInteiro();
                                                                ArrayDeDados_Cliente.excluircliente(id);
                                                                break;
                                                        }

                                                           
                                               }while(opc !=0);
                                                       break;
                                        case 4: // edicao cliente
                                        int editarcliente;
                                            System.out.println("\nDigite o ID do cliente: ");
                                            System.out.print("ID -> ");
                                        int id = ValidarEntrada.validarInteiro();
                                        do{
                                            
                                           editarcliente =  acessorios.MenuClienteEditar();
                                           
                                                if(editarcliente!=0){
                                                    ArrayDeDados_Cliente.editarcliente(editarcliente, id);
                                                    
                                                }
                                            
                                        }while(editarcliente !=0);
                                            
                                        
                                        
                                   }
                                 case 2:
                               int opfuncionario;
                               do{

                              opfuncionario = acessorios.MenuGestaopessoasFuncionario();
                              
                              switch(opfuncionario){
                                  case 1:
                                      int opbfuncionarios=0;
                                      do{
                                    opbfuncionarios = acessorios.MenuGestaopessoasFuncionarioBusca();
                                        switch(opbfuncionarios){
                                            case 1:
                                                //imprimir funcionario
                                                System.out.println("\n\n");
                                                ArrayDeDados_Funcionario.imprimirArrayCliente();
                                                System.out.println("\n\n");
                                                 System.out.println("Pressione Enter para continuar...");
                                                System.in.read(); 
                                                break;
                                            case 2:
                                               //buscar funcionario especifico para imprimir
                                                System.out.println("\nDigite o ID do funcionario: ");
                                                System.out.print("ID -> ");
                                                int idfuncionaro = ValidarEntrada.validarInteiro();
                                                ArrayDeDados_Funcionario.buscarFuncionario(idfuncionaro);
                                                 System.out.println("\n\nPressione Enter para continuar...");
                                                System.in.read(); 
                                                break;
                                                
                                            }
                                    
                                      }while (opbfuncionarios != 0);
                                      break;
                                  case 2:
                                      CadastroFuncionario.cadastro();
                                      break;
                                  case 3:
                                      //excluir funcionario
                                      System.out.println("\nDigite o ID do funcionario: ");
                                      System.out.print("ID -> ");
                                      int idfuncionaro = ValidarEntrada.validarInteiro();
                                      ArrayDeDados_Funcionario.excluirfuncionario(idfuncionaro);
                                      break;
                                  case 4:
                                      //editar funcionario
                                     System.out.println("\nDigite o ID do funcionario: ");
                                     System.out.print("ID -> ");
                                     int idfunceditar = ValidarEntrada.validarInteiro();
                                    
                                     int opcaomenu;
                                     do{
                                         opcaomenu = acessorios.MenuFuncionarioEditar();
                                             
                                                     ArrayDeDados_Funcionario.editarfuncionaro(opcaomenu, idfunceditar);
                                                
                                         
                                     }while(opcaomenu!=0);
                                     break;
                                   case 5:
                                   //gerar contracheque
                                   boolean existe;
                                   int idfuncionario;
                                   do{
                                   System.out.println("\nDigite o ID do funcionario: ");
                                   System.out.print("ID -> ");
                                   idfuncionario = ValidarEntrada.validarInteiro();
                                    existe = ArrayDeDados_Funcionario.saberseexistefuncionario(idfuncionario);
                                   if(existe == true){
                                       GerarContraCheque.gerarcontracheque(idfuncionario);
                                   }else{
                                       System.out.println("Funcionario nao encontrado");
                                   }

                               }while(existe == false);
                              }                               
                               }while(opfuncionario!= 0);
                               break;

                                   }

                    }while(op!=0);
                    }
                    
                }while (opcao !=0);  
     
    }
                   
               
}

    

