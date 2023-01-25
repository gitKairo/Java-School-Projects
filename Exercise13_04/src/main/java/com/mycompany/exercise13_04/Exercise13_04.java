/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.exercise13_04;

import java.time.Year;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;


/**
 *
 * @author Kai
 */
public class Exercise13_04 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Calendar gregCal = new GregorianCalendar();
        
        //Ask user for a year
        System.out.print("Enter Full year (e.g., 2003): ");
        int year = input.nextInt();
        
        
        //prompt user to enter a month
        System.out.print("Please enter a month between 1 and 12: ");
        int month = input.nextInt();
        
        //print calendar for month of the year
        printMonth(year, month);
        
        //print days in given year
        System.out.println("Days in that year: " + gregCal.getActualMaximum(Calendar.DAY_OF_YEAR));
    }
    
    //print the calendar for the month of the year
    public static void printMonth(int year, int month) {
        //print heading of the calendar
        printMonthTitle(year, month);
        
        //print body of the calendar
        printMonthBody(year, month);
    }
    
    //print the month title, e.g. February, 2003
    public static void printMonthTitle(int year, int month) {
        System.out.println("    " + getMonthName(month)
          + " " + year);
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }
    
    //Get the english name for the month
    public static String getMonthName(int month) {
        String monthName = "";
        switch (month) {
            case 1: monthName = "January"; break;
            case 2: monthName = "February"; break;
            case 3: monthName = "March"; break;
            case 4: monthName = "April"; break;
            case 5: monthName = "May"; break;
            case 6: monthName = "June"; break;
            case 7: monthName = "July"; break;
            case 8: monthName = "August"; break;
            case 9: monthName = "September"; break;
            case 10: monthName = "October"; break;
            case 11: monthName = "November"; break;
            case 12: monthName = "December";
        }
        return monthName;
    }
    
    //print month body
    public static void printMonthBody(int year, int month) {
        //get start day of week for the first date in month
        int startDay = getStartDay(year, month);
        
        //get number of days in month
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);
        
        //pad space before first day of month
        int i =0;
        for (i = 0; i < startDay; i++)
            System.out.print("    ");
        
        for(i = 1; i <= numberOfDaysInMonth; i++) {
            System.out.printf("%4d", i);
            
            if ((i + startDay) % 7 == 0)
                System.out.println();
        }
        
        System.out.println();
    }
    
    /** Get start day of month/1/year */
    public static int getStartDay(int year, int month) {
        final int START_OF_DAY_FOR_JAN_1_1800 = 3;
        //get total num of days from 1/1/1800 to month/1/year
        int totalNumberOfDays = getTotalNumberOfDays(year, month);
        
        //return the start day for month/1/year
        return (totalNumberOfDays + START_OF_DAY_FOR_JAN_1_1800) % 7;
    }
    
    //Get total num of days since January 1, 1800
    public static int getTotalNumberOfDays(int year, int month) {
        int total = 0;
        
        //get the total days from 1800 to 1/1/year
        for (int i = 1800; i < year; i++)
            if (isLeapYear(i))
                total = total + 366;
            else
                total = total + 365;
        
        //add days from Jan to the month prior to the calendar month
        for (int i = 1; i < month; i++)
            total = total + getNumberOfDaysInMonth(year, i);
        
        return total;
    }
    
    public static int getNumberOfDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 ||
          month == 8 || month == 10 || month == 12)
            return 31;
        
        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        
        if (month == 2) return isLeapYear(year) ? 29 : 28;
        
        return 0; // if month is incorrect
    }
    
    //Determine if it is a leap year
    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0 );
    }
}
