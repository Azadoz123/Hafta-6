import java.io.*;

public class Main {
    public static void main(String[] args) {
// Dosyaya yazma
        /*try (BufferedWriter bw = new BufferedWriter(new FileWriter("myFile.txt"))) {
            bw.write("Merhaba Dünya!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }*/

// Dosyadan okuma
        try (BufferedReader br = new BufferedReader(new FileReader("myFile.txt"))) {
            String line;
            int total = 0;
            while ((line = br.readLine()) != null) {
                total += Integer.parseInt(line);
            }
            System.out.println(total);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}