
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Reader {
	File file;
	String fileName;
	Scanner scanner = null;
	int times = 0;
	Stack<Token> tokens = new Stack<>();
	
	public Reader(String filePath){
		fileName = filePath;
		try{
			file = new File(fileName);
			scanner = new Scanner(file);
		}catch(FileNotFoundException fe){
			System.out.println("Exception: "+ fe);
		}
	} 



	public Stack<Token> readFile ()
	{
		// push(new Token("EOF", "EOF"));	
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			String[] words = line.split("->");
			Token novo_token = new Token(words[0].trim(), words[1].trim());
			if(novo_token.getType().equals("NR")){
				System.out.println("Palavra não reconhecida");
			       	return null;
			}
			else insert_at_bottom(novo_token);
		}
		
		return tokens;
	}

	public void closeReader(){
		scanner.close();
	}

	public void saveFile(ArrayList<Token> result){
		try {
			String name = "Resultado_Analise_Lexica"+times+".txt";
			FileWriter writer = new FileWriter(name);
			//?COMO IMPRIMIR CERTO O VETOR DE STRING? USAR OUTRA ESTRUTURA DE DADOS?
			writer.write(result.toString());
			writer.close(); 
			times++;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void insert_at_bottom(Token x) {
 
        if(tokens.isEmpty())
            tokens.push(x);
 
        else {
             
            Token a = tokens.peek();
            tokens.pop();
            insert_at_bottom(x);
            tokens.push(a);
        }
    }
     
   
    public void reverse() {
        if(tokens.size() > 0){
           Token x = tokens.peek();
            tokens.pop();
            reverse();
			insert_at_bottom(x);
        }
    }
}

