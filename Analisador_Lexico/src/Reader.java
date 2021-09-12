
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
	File file;
	String fileName;
	Scanner scanner = null;
	int times = 0;
	public Reader(String filePath){
		fileName = filePath;
		try{
			file = new File(fileName);
			scanner = new Scanner(file);
		}catch(FileNotFoundException fe){
			System.out.println("Exception: "+ fe);
		}
	} 

	/*
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
	*/

	public ArrayList<String> readFile ()
	{
		ArrayList<String> read = new ArrayList<String>();
		
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			String[] words = line.split(" ");
			for (int i = 0; i < words.length; i++) {
				if (!words[i].trim().isEmpty())
					read.add (words[i]);
			}
		}
		
		return read;
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
}

