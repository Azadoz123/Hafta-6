import java.io.*;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //dosyadan veri okuma
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("notlar.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //  String okunanMetin = bufferedReader.readLine();
            String okunanMetin = ";";
            while ((okunanMetin = bufferedReader.readLine()) != null) {
                System.out.println(okunanMetin);
            }
            System.out.println();
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Kullanıcıdan veri alma
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir metin girin: ");
        String metin = scanner.nextLine();

        //Veriyi Dosyaya yazma
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("notlar.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(metin);
        printWriter.close();

    }
}