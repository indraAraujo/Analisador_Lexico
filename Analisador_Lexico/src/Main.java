import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
    LinkedList Delimitadores = new LinkedList<>(); 
    LinkedList Reservadas = new LinkedList<>(); 
    LinkedList Operadores = new LinkedList<>(); 
    LinkedList Identificadores = new LinkedList<>();
    Reader fileReader = new Reader("teste.txt");
    fileReader.readFile();
    }
}

