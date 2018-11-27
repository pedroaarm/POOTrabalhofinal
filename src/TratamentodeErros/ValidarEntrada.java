/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TratamentodeErros;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *Essa Classe contém os tratametos de Excessão necessários para o praograma
 * @author pedro
 */
public class ValidarEntrada {
    
       public static Scanner in = new Scanner (System.in);
       
       /**
        * Esse medodo valida uma opção de um menu qualquer.
        * Nesse metodo é digitado um valor qualquer, e a Exption verifica se esse valor é valido, se for válido, esse numero é retornado, caso contrário, é mostrado uma menssagem de erro.
        * @exception Verifica se realmente o caracter digitado foi um numero.
        * @return o numero digitado (caso seja válido).
        * 
        */
       public static int validaropcao(){
            Integer numero = 0;
            do{
            try{
               do{
                numero = in.nextInt();
                in.nextLine(); // Impedir o Erro do Teclado
                    if(numero <0){
                        System.err.println("Nao é permitido digitar numeros negativos!");
                    }
                }while(numero<-1);
                return numero;
            }catch (InputMismatchException e){
                in.nextLine();
          System.err.println("\nEntrada inválida. Digite novamente!\n"); 
        }
    
}while(true);
}
       
       public static int validarInteiro(){
                      Integer numero;
            do{
            try{
                 do{
                numero = in.nextInt();
                in.nextLine(); // Impedir o Erro do Teclado
                    if(numero <0){
                        System.err.println("Nao é permitido digitar numeros negativos!");
                    }
                }while(numero<-1);
                return numero;
            }catch (InputMismatchException e){
                in.nextLine();
          System.err.println("\nEntrada inválida. Digite novamente!\n"); 
        }
    
}while(true); 
           
       }
       
       /**
        * Esse metodo é reponsavel por validar uma String, ou seja, obriga ao usuario a digitar um nome valido.
        * 
        * 
        * 
        * @return o nome digitado, caso seja valido.
        */
   public static String validarString(){
           String nome;
           do{
           try{
    
           nome = in.nextLine();
         
           return nome;
           
             }catch (Exception e){
                 System.err.println("Você digitou caracteres não permitido, tente novamente. Ref.Erro: "+e);
             }
           }while(true);
}
   public static Float validarFloat(){
       Float numero;      

       do{
           try{
  
               numero = in.nextFloat();
               return numero;
           }catch (Exception e){
                in.nextLine();
               System.err.println("Aconceteu o seguinte erro: "+e);
           }
       }while (true);   
   }
   
      public static BigDecimal validarBigDecimal(){
       BigDecimal numero;      

       do{
           try{
  
               numero = in.nextBigDecimal();
               return numero;
           }catch (Exception e){
                in.nextLine();
               System.err.println("Aconceteu o seguinte erro: "+e);
           }
       }while (true);   
   }

}