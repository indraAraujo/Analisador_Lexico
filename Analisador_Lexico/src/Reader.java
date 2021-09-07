import java.io.File;
import java.io.IOException;
import java.io.FileReader;


public class Reader {
    File file;
    String fileName;
   public Reader(String filePath){
        fileName = filePath;
        file = new File(fileName);
   } 
   
   public void readFile(){
        try (FileReader fr = new FileReader(file))
        {
            int content;
            while ((content = fr.read()) != -1) {
                char character = (char) content;
                //chamar função passando o caracter
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
   }
   
}
