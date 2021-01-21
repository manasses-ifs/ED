package aulas.ed2020.sem2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercicios {
    public static void main(String[] args){
        try {
            new Exercicios().questao3_ListarArquivosDeUmDiretorio("E:\\SincronizadoComGit\\aulas\\ED1\\ED2020_2");
        } catch (Exception e) {
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
        mostrarDadosDoArray(dados, qtdMax);
        return dados;
    }

    /*
    Escrever os valores inteiros em um arquivo (os 100 primeiros)
     */
    public void Questao2_EscreverValoresEmArquivo(int qtdElementos) throws IOException {
        int[] dados = Questao1_LerAteXElementos(qtdElementos);
        File arquivo = new File("arquivoExemplo.txt");

        if( arquivo.createNewFile()){
            System.out.println("Arquivo criado.");
        }
        System.out.println("Caminho do arquivo: "+ arquivo.getAbsolutePath());
        FileWriter arquivoWrite = new FileWriter(arquivo);
        for (int i = 0; i < qtdElementos; i++) {
            Integer item = dados[i];
            arquivoWrite.write(item.toString() + "\n");
        }
        arquivoWrite.close();

        System.out.println("Procedimento concluído.");
    }

    /*
    Carregar um vetor de inteiros (até 100 elementos) com o conteúdo de um arquivo;
     */
    public void Questao4_CarregarDadosDoArquivo(int qtdMax) throws IOException {
        File arquivo = new File("arquivoExemplo.txt");

        if( arquivo.createNewFile()){
            System.out.println("Arquivo criado.");
        }
        Scanner arquivoLer = new Scanner(arquivo);
        int[] dados = new int[qtdMax];
        for(int i = 0; i< qtdMax; i++) {
            dados[i] = arquivoLer.nextInt();
        }
        mostrarDadosDoArray(dados, qtdMax);
    }
    public void mostrarDadosDoArray(int[] dados, int tamanho){
        for(int i=0; i< tamanho; i++){
            System.out.println(dados[i]);
        }
    }
    /*
    Listar os arquivos de um determinado diretório;
    */
    public void questao3_ListarArquivosDeUmDiretorio(String caminhoDiretorio) throws Exception {
        File elemento = new File(caminhoDiretorio);
        if (elemento.isDirectory() ) {
            File[] arquivos = elemento.listFiles();
            for(int i =0; i < arquivos.length; i ++){
                if ( arquivos[i].isFile() ) {
                    // 1. Listar SOMENTE OS arquivos do diretorio informado em "caminhoDiretorio".
                    System.out.println("Path: " + arquivos[i].getAbsolutePath() );
                    System.out.println("canExecute: " + arquivos[i].canExecute() );
                    System.out.println("canWrite: " + arquivos[i].canWrite() );
                }
            }
            for(int i =0; i < arquivos.length; i ++) {
                if (arquivos[i].isDirectory() ) {
                    // 2. Para cada "diretorio" encontrado listar o conteúdo deste diretório.
                    questao3_ListarArquivosDeUmDiretorio(arquivos[i].getAbsolutePath());
                }
            }
        } else {
            throw new Exception("O caminho informado ["+ elemento.getAbsolutePath() + "] não é de um diretório.");
        }
    }

}
