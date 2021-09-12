
/*
 * Fornece métodos auxiliares para lidar com o grafo como um todo, uma vez que ele é
 * apresentado como uma lista de adjacências
 *
 *
 */

import java.io.File;   
import java.io.IOException;  
import java.util.Scanner; 
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Graph_Manager
{
	public Vertex[] vertex;
	public int amountOfVertexes;

	// Constrói o grafo a partir do arquivo de configuração graph.conf
	public Vertex[] loadGraph ()
	{
		File configFile = new File ("graph.conf");
		amountOfVertexes = 0;

		/* System.out.println ("\nLoading graph...");
		System.out.println ("Creating adjacency lists..."); */
		
		try {
			Scanner scanner = new Scanner (configFile);
			String string;
			amountOfVertexes = countLines ("graph.conf");
			vertex = new Vertex[amountOfVertexes];
			for (int i = 0; i< amountOfVertexes; i++)
				vertex[i] = new Vertex();

			for (int i = 0; i < amountOfVertexes; i++) {
				if (scanner.hasNextLine ()) {
					string = scanner.nextLine ();
					String[] line = string.split(":");
					vertex[i].id = Integer.parseInt (line[0]);
					String[] adjacencies = line[1].split(",");
					for (int j = 0; j < adjacencies.length; j++)
						vertex[i].adjacencies.add (Integer.parseInt(adjacencies[j]));

					String[] weights = line[2].split(",");
					for (int j = 0; j < weights.length; j++) {
						vertex[i].weights.add (weights[j].charAt(0));
					}
				}
			}
			scanner.close ();

		} catch (IOException e) {
			System.out.println ("get off");
			e.printStackTrace ();
		}

		return vertex.clone ();
	}

	// imprime o grafo, incluindo seus vértices, adjacências e pesos
	public void printGraph (Vertex[] vertex)
	{
		System.out.println ("\nPrinting graph:\n");

		for (int i = 0; i < amountOfVertexes; i++) {
			System.out.print ("\tI = " + i);
			System.out.println ("\tVertex " + vertex[i].id + ":");
			System.out.println ("\t\tAdjacencies: " + vertex[i].adjacencies.toString());
			System.out.println ("\t\tWeights:     " + vertex[i].weights.toString());
		}

		System.out.print ("\n");
	}

	public String determineType (int state)
	{
		String type = "NÃO ATRIBUÍDO";
		String reserved = "PALAVRA RESERVADA";
		String operand = "OPERADOR";

		switch (state) {
			case 40:
				type = reserved;
				break;
			case 43:
				type = reserved;
				break;
			case 23:
				type = reserved;
				break;
			case 44:
				type = reserved;
				break;
			case 26:
				type = reserved;
				break;
			case 36:
				type = reserved;
				break;
			case 38:
				type = reserved;
				break;
			case 37:
				type = reserved;
				break;
			case 54:
				type = reserved;
				break;
			case 17:
				type = reserved;
				break;
			case 45:
				type = reserved;
				break;
			case 29:
				type = reserved;
				break;
			case 57:
				type = reserved;
				break;
			case 55:
				type = operand;
				break;
			case 31:
				type = operand;
				break;
			case 30:
				type = operand;
				break;
			case 21:
				type = operand;
				break;
			case 46:
				type = operand;
				break;
			case 47:
				type = operand;
				break;
			case 48:
				type = operand;
				break;
			case 49:
				type = operand;
				break;
			case 50:
				type = operand;
				break;
			case 51:
				type = operand;
				break;
			case 52:
				type = operand;
				break;
			default:
				type = "IDENTIFICADOR";
				break;
		}

		return type;
	}
	
	// conta as linhas do arquivo de configuração, obtendo assim a quantidade de vértices
	// do grafo
	public int countLines(String filename) throws IOException
	{
		InputStream is = new BufferedInputStream(new FileInputStream(filename));
		try {
			byte[] c = new byte[1024];
			int count = 0;
			int readChars = 0;
			boolean empty = true;
			while ((readChars = is.read(c)) != -1) {
				empty = false;
				for (int i = 0; i < readChars; ++i) {
					if (c[i] == '\n') {
						++count;
					}
				}
			}
			return (count == 0 && !empty) ? 1 : count;
		} finally {
			is.close();
		}
	}
}

