
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class TesteTokensNulos
{
	private FileWriter f;
	File file;

	public TesteTokensNulos()
	{
		file = new File("./tokens-nulos.scm");

		try {
			f = new FileWriter(file,false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void write(String string)
	{
		try {
			f.write(string);
		} catch (IOException e) {
			// 
			e.printStackTrace();
		}
	}

	public void closeFile()
	{
		try {
			f.close();
		} catch (IOException e) {
			// 
			e.printStackTrace();
		}
	}

	public static void main (String[] args)
	{
		TesteTokensNulos ger = new TesteTokensNulos();

		int counter = 0;
		while (counter < 10000) {
			String string = ger.gerarStringAleatoria();
			if (string.contains("!") || string.contains("@") || string.contains("#") || string.contains("$") || 
					string.contains("%") || string.contains(">") || string.contains("\\") || 
					string.contains("]") || string.contains("*") || string.contains("/") || 
					string.contains("+") || string.contains("-") || string.contains(",") || 
					string.contains("<") || string.contains(";") || string.contains("?") || 
					string.contains("[")) {
					
				ger.write (" " + string + " ");
				if (counter % 8 == 0)
					ger.write("\n");
				counter ++;
			}
		}

		ger.closeFile();
	}

	// retorna uma string aleatória, de tamanho n; usada para o identificador da variável
	private String gerarStringAleatoria ()
	{
		int n = 8;

		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "_!@#$%¨&*";
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {
			int index = (int)(AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	// retorna um número aleatório, dentro do intervalo especificado
        private static int genRandom (int min, int max)
        {
                return (int)Math.floor(Math.random()*(max-min+1)+min);
        }
}

