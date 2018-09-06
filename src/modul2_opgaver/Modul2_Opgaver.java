/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul2_opgaver;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author bemma
 */
public class Modul2_Opgaver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello! Please input an assignment to show the result for.");
        System.out.println("Assignments: 2.1, 2.2, 2.6, 2.7, 2.23, A.1, A.2, A.3");
        Scanner scanner = new Scanner(System.in);             //Open a scanner. This will scan for console input.
        AssignmentManager manager = new AssignmentManager();  //Create an instance of the AssignmentManager.
        while (true) {                                        //Create an infinite loop (until broken) to keep listening for console input.
            String input = scanner.next();                    //Wait for the next string input by a user in the console.
            
            //Check if the input mathes any of the words in the Stream and if it does the program is ended by breaking the while loop. 
            if (Stream.of("end", "stop", "shutdown", "close", "kill").anyMatch(predicate -> predicate.equalsIgnoreCase(input))) {
                System.out.println("Ending program!");
                break;
            } else {
                //Call the printResultOf method in the AssignmentManager and print the result of the given assignment if any else print an info message.
                if (manager.printResultOf(input, scanner)) {
                    Stream.of("", "", "", "Input another assignment name to view the result").forEach(s -> System.out.println(s));
                }
            }
        }
        scanner.close(); //Close the scanner.
    }
}
