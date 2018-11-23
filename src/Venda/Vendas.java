/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda;

import Produtos.BancoDeDados.ArrayDeDadosProdutos;
import Produtos.Produtos;
import TratamentodeErros.ValidarEntrada;

/**
 *
 * @author pedro
 */
public class Vendas {

      private int idproduto;
        private int quantidadedeprodutos;
        private float precounitario;
        private float precototal;

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }
        private String nomeproduto;
        
    public Vendas(int idproduto, int quantidade) {
        this.idproduto = idproduto;
        this.quantidadedeprodutos = quantidade;
        
    }

    public Vendas(int idproduto, int quantidade, float precounitario, float precototal, String nomeproduto) {
        this.idproduto = idproduto;
        this.quantidadedeprodutos = quantidade;
        this.precounitario = precounitario;
        this.precototal = precototal;
        this.nomeproduto = nomeproduto;
    }

   
 

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public int getQuantidade() {
        return quantidadedeprodutos;
    }

    public void setQuantidade(int quantidade) {
        this.quantidadedeprodutos = quantidade;
    }

    public float getPrecounitario() {
        return precounitario;
    }

    public void setPrecounitario(float precounitario) {
        this.precounitario = precounitario;
    }

    public float getPrecototal() {
        return precototal;
    }

    public void setPrecototal(float precototal) {
        this.precototal = precototal;
    }
    
    

        
       
    public static void venda(){
        System.out.println("Digite o ID do produto: ");
        int id = ValidarEntrada.validarInteiro();
        
        int sai;
        float preco;
        boolean verifica = false;
        boolean sair = false;
        do{
        do{

             verifica = ArrayDeDadosProdutos.verificarexistencia(id);
             if(verifica == false){
                 System.out.println("ID inválido, digite o ID novamente");
             }
        }while(verifica == false);
        
        Produtos produto = ArrayDeDadosProdutos.retornaprodutoespecifico(id);
        
        
        System.out.println("Produto: "+ produto.getNome()+ " |Referencia: "+produto.getReferencia()+" |Valor por unidade: "+produto.getValor());
        System.out.println("Deseja continuar a operação?");
        System.out.println("1 - SIM |2- NAO");
        sai = ValidarEntrada.validarInteiro();
        
        
            if(sai == 1){
                boolean verificaquantidade = false;
            do{
        System.out.println("Digite a quantidade: ");
        int quantidade = ValidarEntrada.validarInteiro();
            if(quantidade > produto.getQuantidadeestoque()){
                System.out.println("Nao é possivel fazer essa operacao, quantidade em estoque insuficiente | Quantidade atual: "+produto.getQuantidadeestoque());
            }else{
            verificaquantidade = true;    
             preco = produto.getValor() * quantidade;
                System.out.println("Produto: "+produto.getNome()+ "| R$: "+produto.getValor()+ "X "+quantidade+" = "+ preco);
                boolean saida = false;
                do{
                System.out.println("Colocar no carrinho? 1 - SIM - 2 - NAO");
                int opcao = ValidarEntrada.validarInteiro();
               
                    if(opcao == 1){ 
                        //int idproduto, int quantidade, float precounitario, float precototal, String nomeproduto)
                        Vendas vender = new Vendas(id,quantidade,produto.getValor(),preco,produto.getNome());
                        ControleVendas.arrayvendaslocal.add(vender);
                    }
                        if (opcao == 2){
                        saida = true;
                    }else if (opcao != 1 || opcao != 2){
                        System.out.println("Opção invalida");
                    }
               }while (saida == false);
           
            }
            }
    }while (sai == false);
        }
    
}
