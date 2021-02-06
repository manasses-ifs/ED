package sem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {

        //File tempFile = File.createTempFile("ArquivoED",".txt");
        File tempFile  = new File("arquivo.txt");
        if ( tempFile.createNewFile()){
            System.out.println("Arquivo criado.");
        }
        System.out.println("Caminho:");
        System.out.println(tempFile.getAbsolutePath());

        lerArquivo(tempFile);
        FileWriter f = new FileWriter(tempFile);
        try {
            f.append("OK!\n");
        }
        finally {
            f.close();
        }
        System.out.println(tempFile.getAbsolutePath());
    }
    public static void lerArquivo(File File) throws FileNotFoundException {
        // FileReader, BufferedReader, Files, Scanner,
        // FileInputStream, FileWriter, BufferedWriter, FileOutputStream
        Scanner myReader = new Scanner(File);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();
    }
}
