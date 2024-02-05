package si.review;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIO {
    // also note: 'throws IOException'
    public static void main(String[] args) throws IOException {
        String filepath = "data/alice.txt";
        
        // File Object
        File file = new File(filepath);
        String abspath = file.getAbsolutePath();
        System.out.println(abspath);

        // Reading Files (and try/catch)
        try {
            FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            while(line != null){
                System.out.println(line);
                line = bufferedReader.readLine();
            }

            fileReader.close();
            bufferedReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("Fart");
            e.printStackTrace();
        }

        // Writing w/ files & try w/ resources
        try (FileWriter fw = new FileWriter("src/main/java/unit01/file_writer.txt");
             PrintWriter pw = new PrintWriter(fw);
             Scanner scan = new Scanner(System.in)){
                pw.println("\n\nSession start:");
                System.out.println("\nPlease enter some text to write in the text file:");
                System.out.print(">> ");
                String s = scan.nextLine();
                while(s != ""){
                    pw.println(s);
                    System.out.print(">> ");
                    s = scan.nextLine();
                }
                pw.flush();
        }
    }
}
