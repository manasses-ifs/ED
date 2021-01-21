package aulas.ed2020.sem2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercicios {
    public static void main(String[] args){
        try {
            new Exercicios().Questao2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static final int QTD_MAX = 5;
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
    public void Questao2() throws IOException {
        int[] dados = Questao1_LerAteXElementos(QTD_MAX);
        File arquivo = new File("arquivoExemplo.txt");

        if( arquivo.createNewFile()){
            System.out.println("Arquivo criado.");
        }
        System.out.println("Caminho do arquivo: "+ arquivo.getAbsolutePath());
        FileWriter arquivoWrite = new FileWriter(arquivo);
        for (int i = 0; i < QTD_MAX; i++) {
            Integer item = dados[i];
            arquivoWrite.write(item.toString() + "\n");
        }
        arquivoWrite.close();

        System.out.println("Procedimento concluído.");
    }
}
