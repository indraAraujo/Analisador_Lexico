import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;


public class Reader {
    File file;
    String fileName;
   public Reader(String filePath){
        fileName = filePath;
        file = new File(fileName);
   } 
   
   public ArrayList<String> readFile(){
        ArrayList<String> read = new ArrayList<>();
        try (FileReader fr = new FileReader(file)){
            
            int content;
            while ((content = fr.read()) != -1) {
                char temp = (char) content;
                String character = ""+temp;
                read.add(character);
                System.out.println(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return read;
   }
   
}
