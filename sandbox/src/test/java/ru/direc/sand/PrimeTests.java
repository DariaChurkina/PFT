package ru.direc.sand;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Daria on 21.06.2016.
 */
public class PrimeTests {

    @Test
    public void testPrime() {
        Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
    }

    @Test
    public void testNotPrime() {
        Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE-2));
    }
}
