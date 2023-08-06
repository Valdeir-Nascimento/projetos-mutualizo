package br.com.mutualizo.desafio.problema;

public class Fibonacci {

    /*
    * Problema: A implementação fornecida foi desenvolvida utilizando recursividade simples.
    * Porém essa solução possui algumas limitações e problemas associados a ela como
    * desempenho ineficiente, repetição de cálculos, uso excessivo de memória.
    *
    * Na implementação, foi observado que possui problemas de eficiência devido
    * a chamadas repetidas e redundantes da função getNthFibonacci(n)
    *
    *
    * Solução: Para corrigir esse problema podemos utilizar programação dinâmica ou
    * memoização para evitar o recalculo dos mesmos valorres várias vezes.
    * */

    public static int getNthFibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return getNthFibonacci(n - 1) + getNthFibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int result = getNthFibonacci(n);
        System.out.println("O " + n + "º número de Fibonacci é: " + result);
    }
}