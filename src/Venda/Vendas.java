package Venda;


import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pedro
 */
public class Vendas {

      private int idproduto;
        private int quantidadedeprodutos;
        private BigDecimal precounitario;
        private BigDecimal precototal;

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

    public Vendas(int idproduto, int quantidade, BigDecimal precounitario,BigDecimal precototal, String nomeproduto) {
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

    public BigDecimal getPrecounitario() {
        return precounitario;
    }

    public void setPrecounitario(BigDecimal precounitario) {
        this.precounitario = precounitario;
    }

    public BigDecimal getPrecototal() {
        return precototal;
    }

    public void setPrecototal(BigDecimal precototal) {
        this.precototal = precototal;
    }

  
    
    

    
    
} 

   
