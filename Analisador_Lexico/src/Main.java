import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> readCharacters = new ArrayList<>();
        Reader fileReader = new Reader("estranho.txt");
        readCharacters = fileReader.readFile();
        System.out.println(readCharacters.toString());
    }
}
