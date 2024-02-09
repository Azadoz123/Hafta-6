import java.io.File;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        File dosya = new File("patika.txt");
        try {
            if(dosya.createNewFile()){
                System.out.println(dosya.getName() + " dosyası oluşturuldu !");
            }else {
                System.out.println(dosya.getName() + " dosyası zaten mevcut !");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}