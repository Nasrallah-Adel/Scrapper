/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scrapper;

/**
 *
 * @author nasrallah
 */
public class Lets_play {

    public static void main(String[] args) {
        Udemy ud = new Udemy();
        Coursera co = new Coursera();
        Tedx ted = new Tedx();
        ud.Getter_beginner("Java Programming");
        ud.Getter_intermediate("Java Programming");
        ud.Getter_expert("Java Programming");
//        co.Getter_beginner("Java Programming");
//        ted.Getter();
        
    }
}
