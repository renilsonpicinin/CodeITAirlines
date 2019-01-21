/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author renilson
 */
public class StringUtil {
    
    public static boolean somenteLetras(String s){
        return s.matches("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$") && !s.isEmpty();
    }
    
    public static boolean somenteNumeros(String s){
        return s.matches("^[0-9]*$") && !s.isEmpty();
    }
}
