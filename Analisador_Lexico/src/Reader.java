import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    File file;
    String fileName;
    Scanner scanner = null;
   public Reader(String filePath){
        fileName = filePath;
        try{
            file = new File(fileName);
            scanner = new Scanner(file);
        }catch(FileNotFoundException fe){
            System.out.println("Exception: "+ fe);
        }
   } 
   
   public ArrayList<String> readFile(){
        ArrayList<String> read = new ArrayList<>();

            while (scanner.hasNext()) {
               String line = scanner.nextLine();
               String tokens[] = line.split("[)\\s*(]");
               for(int i=0; i<tokens.length;i++){
                   if(tokens[i].trim().isEmpty()==false){
                     read.add(tokens[i]);
                   }
               }
            }

        return read;
   }
   
   public void closeReader(){
       scanner.close();
   }
}
