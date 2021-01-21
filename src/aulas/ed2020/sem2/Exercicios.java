package aulas.ed2020.sem2;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;

public class Exercicios {
    public static void main(String[] args){

    }
    private final int qtdMax = 5;
    /*
    Ler um conjunto de valores em um vetor de inteiros (até 100 elementos)
     */
    public int[] Questao1_LerAteXElementos(int qtdMax){
        int[] dados = new int[qtdMax];
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < qtdMax; i ++){
            int valor = teclado.nextInt();
            dados[i] = valor;
        }
        return dados;
    }

    /*
    Escrever os valores inteiros em um arquivo (os 100 primeiros)
     */
    public void Questao2(){

    }
}
