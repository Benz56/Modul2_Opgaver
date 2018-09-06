/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul2_opgaver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author bemma
 */
final class AssignmentManager {

    private static final String VALID_ASSIGNMENTS = "Assignment not found. Valid Assignments: 2.1, 2.2, 2.6, 2.7, 2.23, A.1, A.2, A.3";
    //Map containing all initialised assignments mapped by their assignment name to an anounymous class/lambda expression taking the scanner as a parameter.
    private final Map<String, FIAssignment> assignments = new HashMap<>();

    /**
     * No-args constructor to automatically initialise the assignments.
     */
    public AssignmentManager() {
        initialiseAnsweredAssignments(); //Initialise all assignments and put them in the map.
    }

    /**
     * This method initialises all answered assignments and puts them in the
     * assignments map referenced by the assignment name. This contains all the
     * answers as well.
     */
    final void initialiseAnsweredAssignments() {
        assignments.put("2.1", scanner -> { //Assignment 2.1
            System.out.println("Please input an Integer or Double miles value:");
            Double miles = null;
            while (miles == null) {
                miles = getNumericInput(scanner);
            }
            System.out.println(" " + miles + " miles is " + String.format("%.2f", miles * 1.6) + " kilometers.");
        });
        assignments.put("2.2", scanner -> { //Assignment 2.2
            System.out.println("Please input the side length of an equilateral triangle:");
            Double length = null;
            while (length == null) {
                length = getNumericInput(scanner);
            }
            double area = (Math.sqrt(3) / 4) * Math.pow(length, 2);
            double volume = area * length;
            System.out.println(" The area of the triangle is " + String.format("%.2f", area));
            System.out.println(" The volume of the triangular prism is " + String.format("%.2f", volume));
        });
        assignments.put("2.6", scanner -> { //Assignment 2.6
            System.out.println("Please input an Integer value:");
            Integer value = null;
            while (value == null) {
                value = getIntegerInput(scanner);
            }
           
            char[] arr = value.toString().toCharArray();
            int multipliedDigits = Character.getNumericValue(arr[0]);
            for (int i = 1; i < value.toString().length(); i++) {
                multipliedDigits = multipliedDigits * Character.getNumericValue(arr[i]);
            }
            System.out.println(" All digits multiplied is " + multipliedDigits);
        });
        assignments.put("2.23", scanner -> { //Assignment 2.23
            Double distance, mileage, price;
            distance = mileage = price = null;
            System.out.println(" Please enter the distance in miles of the ride:");
            while (distance == null) {
                distance = getNumericInput(scanner);
            }
            System.out.println(" Please enter the miles pr. gallon:");
            while (mileage == null) {
                mileage = getNumericInput(scanner);
            }
            System.out.println(" Please enter the price pr. gallon:");
            while (price == null) {
                price = getNumericInput(scanner);
            }
            System.out.println(" The cost of the drive is " + String.format("%.2f", distance / mileage * price));      
        });
        assignments.put("a.1", scanner -> { //Assignment a.1
            System.out.println("Printing volumes:");
            for (int radius = 1; radius <= 5; radius++) {
                System.out.println(" Radius " + radius + " equals a volume of: " + String.format("%.2f", Math.PI * Math.pow(radius, 2)));
            }
        });
        assignments.put("a.2", scanner -> { //Assignment a.2
            System.out.println("Printing circumferences:");
            Stream.of(3, 7).forEach(radius -> System.out.println(" Radius " + radius + " equals a circumference of: " + String.format("%.2f", 2 * Math.PI * radius)));
        });
        assignments.put("a.3", scanner -> { //Assignment a.3
            System.out.println("Printing temperature differences:");
            final List<String> days = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
            final List<Double> temperatures = Arrays.asList(21.5, 23.7, 19.6, 22.5, 25.3, 21.7, 18.9);

            for (int i = 1; i < 7; i++) {
                final int yesterday = i - 1;
                System.out.println(" Temparture difference between " + days.get(yesterday) + " and " + days.get(i) + " is " + String.format("%.2f", Math.abs(temperatures.get(i) - temperatures.get(yesterday))));
            }
        });
    }

    /**
     * This method will print out the result of the given assignment.
     *
     * @param assignmentName the assignments which answer you wish to print.
     * @param scanner the scanner to listen for input.
     * @return whether or not there was an assignment with the given name.
     */
    final boolean printResultOf(String assignmentName, Scanner scanner) {
        FIAssignment assignment = assignments.get(assignmentName.toLowerCase());
        if (assignment != null) {
            System.out.println("--[- Assignment " + assignmentName + " -]--");
            assignment.print(scanner);
            System.out.println("--[------------------]--");
        } else {
            System.out.println(VALID_ASSIGNMENTS);
        }
        return assignment != null;
    }

    /**
     * Gets the next double or integer value from the scanner.
     *
     * @param scanner the scanner to read input from.
     * @return the input or null if the input was invalid.
     */
    private Double getNumericInput(Scanner scanner) {
        try {
            return scanner.nextDouble();
        } catch (Exception ignoredException) {
            System.out.println("Invalid input. Please input a Double or Integer value!");
            scanner.next();
        }
        return null;
    }
    
    /**
     * Gets the next integer value from the scanner.
     *
     * @param scanner the scanner to read input from.
     * @return the input or null if the input was invalid.
     */
    private Integer getIntegerInput(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (Exception ignoredException) {
            System.out.println("Invalid input. Please input Integer value!");
            scanner.next();
        }
        return null;
    }
}
