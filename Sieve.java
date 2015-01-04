import java.util.*;

/**
 * The Sieve class creates two lists: one is a list of consecutive integers from 2 through a number
 * determined by the user. Then the program will find all primes up to that value and store them
 * in another list. 
 * 
 * @author Grace Thompson 
 * @version 3/12/13
 */
public class Sieve
{
    /**
     * This method finds all positive prime numbers up to the value input by the user.
     * @param value input by user that determines the range of values to be examined.
     * @return ArrayList of prime numbers
     * @throws IllegalArgumentException if value is less than 2.
     */
    
    public static ArrayList<Integer> findPrimes(int num) {
        ArrayList<Integer> numberList = new ArrayList<Integer>(); //list of consecutive numbers
        ArrayList<Integer> primeList = new ArrayList<Integer>(); //list of prime numbers
        if(num < 2)
            throw new IllegalArgumentException("value cannot be less than 2");
        
        //first fill numberList with consecutive numbers up to num.
        for(int i = 2; i <= num; i++) { 
            numberList.add(i);
        }
        
        //search through list and remove multiples of numbers up to the sqrt of num (user value).
        for(int k = 2; k < Math.sqrt(num); k++) { //iterate through multiples
            int prime = numberList.remove(0);
            primeList.add(prime);
            for(int j = 0; j < numberList.size(); j++) { //remove multiples for each k
                if(numberList.get(j) % prime == 0) {
                    numberList.remove(j);
                }
            
            }
        }
        for(int l = 0; l < numberList.size(); l++) { //transfer remaining primes to primeList
            int remainder = numberList.get(l);
            primeList.add(remainder);
        }
        return primeList;
    }
}
