import java.util.*;

/**
 * This class is the user interface for the Sieve program. It will get a valid value from the user
 * and print out a list of all the prime numbers up to that value. It will also print out the percentage
 * of prime numbers. The program will continue to prompt the user for another value until the user
 * stops the program with the exit code.
 * 
 * @author Grace Thompson
 * @version 3/12/13
 */
public class SieveUI {
    public static final int ROWS = 12;
    
    public static void main(String[] args) {
        intro();
        Scanner console = new Scanner(System.in);
        int num = 2; //initialize variable, it will take on a real value input by the user in the do/while loop

        do {
            System.out.print("Enter a positive integer of at least 2, or enter 0 to quit: ");
            while (!console.hasNextInt()) { //input validation for values that are not integers
                System.out.println();
                System.out.print("That's not an integer! Try again: ");
                console.next();
            }
            num = console.nextInt();
            while (num < 2 && num != 0) { //input validation for values that are less than 2
                System.out.println();
                System.out.println("Sorry, the value must be an integer of no less than 2.");
                System.out.println();
                System.out.print("Enter an integer, or enter 0 to quit: ");
                num = console.nextInt();
            }
            if(num != 0) { //prevents program from passing in 0 and throwing the IllegalArgumentException in Sieve class!
                displayResults(num);
                System.out.println();
            }
        }
        while(num != 0); //will continue as long as user does not enter 0
        System.out.println();
        System.out.println("Thanks for playing, see you again soon!"); //closing statement
   
    }
    /**
     * this method takes the ArrayLists and prints out the prime numbers as well as the percent of primes to the whole set of 
     * numbers in the specified range.
     * @param user-dictated value
     */
    public static void displayResults(int num) {
        ArrayList<Integer> numbers = Sieve.findPrimes(num); //gets list of Prime numbers from Sieve class
        System.out.println();
        printlist(num, numbers);
        double percent = findPercent(num, numbers); //find percent of primes
        System.out.println();
        System.out.printf("%% prime = % ,.1f\n", percent);
        System.out.println();
    }
    /**
     * this method will print out all the prime numbers found in 12 numbers per line.
     * @param user-dictated value
     * @param ArrayList of prime numbers
     */
    public static void printlist(int num, ArrayList<Integer> numbers) {

        System.out.println("Primes up to "+num+" are as follows: ");
        System.out.println();
        for(int i = 0; i < numbers.size(); i++) {
            if(i % ROWS == 0 && i > 0) { //separates prime numbers into 12 numbers per row
                System.out.println();
                System.out.print(numbers.get(i) + " ");
            }
            else {
                System.out.print(numbers.get(i) + " ");
            }
        }
    }
    /**
    * this method will find the percentage of numbers in the range that are prime and 
    * print it to one decimal point.
    * @param user input value
    * @param ArrayList of prime numbers
    * @return percent of primes
    */
    public static double findPercent(int num, ArrayList<Integer> numbers) {
        return ((double) numbers.size() / (double) num) * 100;
    }
    /**
     * Introduction for user interface
     */ 
    public static void intro() {
        System.out.println("Welcome to the Math Tutoring Center!");
        System.out.println();
        System.out.println("This program computes prime numbers up to a specified value.");
        System.out.println("Simply specify the value to find primes up to, or select 0 to exit.");
        System.out.println();
        System.out.println("Ready? Let's begin.");
        System.out.println();
        
    }
}

