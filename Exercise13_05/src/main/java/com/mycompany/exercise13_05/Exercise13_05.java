/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.exercise13_05;

/**
 *
 * @author Kai
 */
public class Exercise13_05 {

    public static void main(String[] args) {
        // Create two Circle objects
		Circle circle1 = new Circle(15, "red", true);
		Circle circle2 = new Circle(10, "blue", false);

		// Display circle1
		System.out.println("\nCircle 1: ");
		print(circle1);

		// Display circle2
		System.out.println("\nCircle 2: ");
		print(circle2);

		// Display larger circle
		print("\nThe larger of the two circles was ");
		print(Circle.max(circle1, circle2));

		// Create two Rectangle objects
		Rectangle rectangle1 = new Rectangle(4, 5, "green", true);
		Rectangle rectangle2 = new Rectangle(4.2, 5, "orange", true);

		// Display circle1
		System.out.println("\nRectangle 1: ");
		print(circle1);

		// Display circle2
		System.out.println("\nRectangle 2: ");
		print(circle2);

		// Display larger circle
		print("\nThe larger of the two rectangles was ");
		print(Rectangle.max(rectangle1, rectangle2));
	}

	// Displays a string
	public static void print(String s) {
		System.out.println(s);
	}

	// Displays a GeometricObject
	public static void print(GeometricObject o) {
		System.out.println(o);
	}
    }

