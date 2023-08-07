package br.com.mutualizo.desafio.solucao;

import java.util.Arrays;

public class Fibonacci {

    // Array para armazenar os valores já calculados
    private static int[] memo;

    public static int getNthFibonacci(int n) {
        // Inicializar o array de memoização com -1 (indicando não calculado ainda)
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return calculaFibonacci(n);
    }
    
    private static int calculaFibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (memo[n] != -1) {
            return memo[n]; // Retorna o valor já calculado
        } else {
            // Calcula e memoiza os valores para evitar cálculos repetidos
            memo[n] = calculaFibonacci(n - 1) + calculaFibonacci(n - 2);
            return memo[n];
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int result = getNthFibonacci(n);
        System.out.println("O " + n + "º número de Fibonacci é: " + result);
    }
}
