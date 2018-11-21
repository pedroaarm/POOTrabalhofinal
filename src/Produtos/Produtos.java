/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produtos;

/**
 *Tipos de produtos:
 * Casa;
 * informática e acessórios
 * alimentos e bebidas
 * eletro
 * brinquedos
 * Musica
 * Livos
 * Esporte & lazer
 * @author pedro
 */
public class Produtos {
    
    private String nome;
    private String Descricao;
    private int quantidadeestoque;
    private float valor;
    private Integer id;
   private String referencia;
   private String marca;
   private int departamento;

    public Produtos(String nome, String Descricao, int quantidadeestoque, float valor, String referencia, String marca, int departamento) {
        this.nome = nome;
        this.Descricao = Descricao;
        this.quantidadeestoque = quantidadeestoque;
        this.valor = valor;
        this.referencia = referencia;
        this.marca = marca;
        this.departamento = departamento;
    }

    public Produtos(String nome, String Descricao, int quantidadeestoque, float valor, Integer id, String referencia, String marca, int departamento) {
        this.nome = nome;
        this.Descricao = Descricao;
        this.quantidadeestoque = quantidadeestoque;
        this.valor = valor;
        this.id = id;
        this.referencia = referencia;
        this.marca = marca;
        this.departamento = departamento;
    }
    


    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public int getQuantidadeestoque() {
        return quantidadeestoque;
    }

    public void setQuantidadeestoque(int quantidadeestoque) {
        this.quantidadeestoque = quantidadeestoque;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
}
