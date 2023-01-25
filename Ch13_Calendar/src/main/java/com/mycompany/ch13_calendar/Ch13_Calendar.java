/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ch13_calendar;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;


/**
 *
 * @author Kai
 */
public class Ch13_Calendar {

    public static void main(String[] args) {
        //Calendar is an abstract class
        //GregorioanCalendar extends the Calendar class
        
        Calendar gregCal = new GregorianCalendar(); //no constructor arg displays today's date
        System.out.println("Today:\t\t\t\t" + gregCal.get(Calendar.DAY_OF_MONTH)); //Prints hard coded day of the month
        
        Calendar gregCalendar = new GregorianCalendar(2022, 0, 9); //Hard code year, day, month
        System.out.println("Hard Coded Date:\t\t" + gregCalendar.get(Calendar.DAY_OF_MONTH)); //Prints hard coded day of the month
        
        System.out.println("Month \t\t\t\t" + gregCalendar.get(Calendar.MONTH)); //Prints hard coded month in numerical form e.g. 0, 1, 2, etc.
        
        System.out.println("First Day of the Week \t\t" + gregCalendar.getCalendarType()); //Outputs gregory

        System.out.println("Last Day of the Month \t\t" + gregCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)); //Gets date of last hard coded month
        
        System.out.println(gregCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US)); //Prints long form name of hard coded month e.g. January, Februray, etc.
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
