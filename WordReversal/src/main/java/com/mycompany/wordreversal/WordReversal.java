/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.wordreversal;

import java.util.Scanner;

/**
 *
 * @author Kai
 */
public class WordReversal {

    public static void main (String[] args) {
        Scanner wordInput = new Scanner(System.in); //Created Scanner Obj
        
        System.out.println("Please enter a sentence to be reversed: "); //Prompt a user for input
        
        String word = wordInput.nextLine(); //Collect user input
        wordInput.close();
        
        String words[] = word.split("\\s");
        String wordReversed = "";
        
        //Reverse each words position
        for (int i = 0; i < words.length; i++ ) {
            if (i == words.length - 1){
                wordReversed = words[i] + wordReversed;
            } else {
                wordReversed = " " + words[i] + wordReversed;
            }   
        }
        
        //Output Reversed String
        System.out.println("Your sentence reversed is: " + wordReversed);
    }
}
