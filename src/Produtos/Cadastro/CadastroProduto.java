/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produtos.Cadastro;

import Departamentos.BancoDeDados.ArraydeDados_Departamento;
import Produtos.Produtos;
import TratamentodeErros.ValidarEntrada;
import java.io.IOException;
import java.math.BigDecimal;


/**Faz o cadastro de produtos e chammas as outras funcoes para isso
 public 
 * @author pedro
 */
public class CadastroProduto {

    public static Produtos cadastro() throws IOException{

        System.out.println("---Cadastro de Produto---");
        System.out.println("");
        System.out.println("");
        
        System.out.println("Digite o nome do Produto: ");
        String nomeproduto = ValidarEntrada.validarString();
        System.out.println("Digite a Marca: ");
        String marca = ValidarEntrada.validarString();
        System.out.println("Digite uma descrição: ");
        String descricao = ValidarEntrada.validarString();
        System.out.println("Digite o Valor: ");
        BigDecimal valor = ValidarEntrada.validarBigDecimal();
        System.out.println("Digite a quantidade em estoque: ");
        Integer estoque = ValidarEntrada.validarInteiro();
        System.out.println("Digite a referencia: ");
        String referencia = ValidarEntrada.validarString();
        
        System.out.println("---Cadastro do produto em um departamento---");
        int numero,departamento=0,sair=0;
       do{
        System.out.printf("Digite:\n1 - Mostrar Departamentos para cadastro do produto |2-Cadastrar em um Departamento:\n");
        int op = ValidarEntrada.validaropcao();
        
            switch(op){
                case 1:
                    ArraydeDados_Departamento.imprimirTodosDepartamentos();
                    break;
                case 2:
                    int chave =0;
                        do{
                       System.out.println("Digite o numero do departamento: ");
                       departamento = ValidarEntrada.validarInteiro();
                       boolean verifica = ArraydeDados_Departamento.buscarDPId(departamento);
                        if(verifica == true){
                            System.out.println("");
                            System.out.println("Produto Cadastrado!");
                              System.out.println("pressione Enter para continuar...");
                               System.in.read();
                               System.out.println("");
                            chave =1;
                            sair = 1;
                        }else{
                            System.out.println("Esse departamento não existe, tente novamente");
                            
                        }
                        break;
                        
                }while (chave !=1);
            }
       }while(sair!=1);
       
        Produtos produto = new Produtos(nomeproduto,descricao,estoque,valor,referencia, marca, departamento);
          

        Adicionar_Produto.addBanco(produto);
        
        
        return produto;
    }
    
}


