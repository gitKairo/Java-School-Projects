/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.primenumbersupto;

/**
 *
 * @author kairo
 */
import java.io.*;

public class PrimeNumbersUpTo {
    public static void main(String[] args) {
        File primeFile = new File("PrimeNumbers.dat");
        long[] primes = new long[10000];
        int primeCount = 0;

        // Read existing prime numbers from file
        if (primeFile.exists()) {
            try (DataInputStream input = new DataInputStream(new FileInputStream(primeFile))) {
                while (true) {
                    primes[primeCount] = input.readLong();
                    primeCount++;
                }
            } catch (EOFException e) {
                // Reached end of file
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Find new prime numbers and append to file
        try (DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(primeFile, true)))) {
            long number = (primeCount == 0) ? 2 : primes[primeCount - 1] + 1;
            while (number <= 1000000) {
                boolean isPrime = true;
                for (int i = 0; i < primeCount && primes[i] * primes[i] <= number; i++) {
                    if (number % primes[i] == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    primes[primeCount] = number;
                    primeCount++;
                    output.writeLong(number);
                    if (primeCount == 10000) {
                        primeCount = 0;
                        primes = new long[10000];
                    }
                }
                number++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

