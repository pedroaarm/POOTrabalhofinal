/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TratamentodeErros;

/**Classe com proposito de verificar se uma strig de algum documento tem apenas numeros, impedindo salvar documentos com letras no BD
 *
 * @author pedro
 */
public class ValidarDocumento {
   public static boolean SoTemNumeros(String texto) {
   try {
      Long.parseLong(texto);
      return true;
   } catch (NumberFormatException e) {
      return false;
   }
   }
}
       

