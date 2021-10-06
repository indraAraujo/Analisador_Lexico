
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TesteDeCarga
{
	private ArrayList<String> words;
	private FileWriter f;
	private File file;

	public TesteDeCarga()
	{
		file = new File("./teste-de-carga.txt");

		try {
			f = new FileWriter(file,false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		words = new ArrayList<String>();
		words.add("defun");
		words.add("define");
		words.add("let");
		words.add("lambda");
		words.add("car");
		words.add("cdr");
		words.add("list");
		words.add("atom");
		words.add("cond");
		words.add("case");
		words.add("if");
		words.add("T");
		words.add("nil");
		words.add("+");
		words.add("-");
		words.add("/");
		words.add("*");
		words.add(">");
		words.add("<");
		words.add("leq");
		words.add("geq");
		words.add("neq");
		words.add("eq");
		words.add("=");
		words.add("_");
		words.add(")");
		words.add("(");

		for (int i = 0; i < 50000; i++)
			words.add (gerarStringAleatoria());
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
		TesteDeCarga ger = new TesteDeCarga();

		int counter = 0;
		while (counter < 10000000) {
			String string = ger.words.get(genRandom(0, 26));
			ger.write (" " + string + " ");
			if (counter % 20 == 0)
				ger.write("\n");
			counter ++;
		}

		ger.closeFile();
	}

	// retorna uma string aleatória, de tamanho n; usada para o identificador da variável
	private String gerarStringAleatoria ()
	{
		int n = 8;

		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "_!@#$%¨&*()";
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

