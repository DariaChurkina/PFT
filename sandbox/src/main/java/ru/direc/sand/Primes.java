package ru.direc.sand;

/**
 * Created by Daria on 21.06.2016.
 */
public class Primes {

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i = i + 1) { //i +=1, i++
          if (n % i == 0) {
              return false;
          }
        }
        return true;
    }

    public static boolean isPrimeWhile(int n) {
        int i = 2;
        for (int i = 2; i < n; i = i + 1) { //i +=1, i++
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
