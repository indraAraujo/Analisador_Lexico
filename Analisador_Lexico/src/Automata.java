
import java.util.ArrayList;

public class Automata{
	ArrayList<Token> tokens;

	public Automata (){
		tokens = new ArrayList<Token>();
	}

	public void parseWords (ArrayList<String> readWords){
		int state, k;
		boolean hasAdjacency, debugMode;
		String word, type;
		char input;
		Vertex[] vertex;
		ArrayList<String> words = new ArrayList<String>();
		debugMode = false;
		Graph_Manager graphManager = new Graph_Manager();

		vertex = graphManager.loadGraph ();
		words = readWords;
		if (debugMode) {
			graphManager.printGraph(vertex);
		}

		state = 0;
		k = 0;
		// System.out.println ("\n");
		while ((word = words.get(k)) != null) {
			/* if (debugMode) System.out.println ("\n\t--> Analisando \"" + word + "\":");
			else System.out.print ("\t--> Analisando \"" + word + "\":"); */

			for (int i = 0; i < word.length(); i++) {
				input = word.charAt (i);
				hasAdjacency = false;
				if (debugMode){
					System.out.println ("\t\tPartindo do estado: " + state);
					System.out.println ("\t\tVerificando adjacências para " + input);
				}
				for (int j = 0; j < vertex[state].weights.size(); j++) { 
					if (vertex[state].weights.get(j) == input) {
						if (debugMode){
							System.out.println ("\t\t\tEncontrada, leva para o vértice: " + vertex[state].adjacencies.get(j));
							System.out.println ("\t\t\tAtualizando estado...");
						}
						state = vertex[state].adjacencies.get(j);
						hasAdjacency = true;
						break;
					}
				}
				if (!hasAdjacency) {
					if (debugMode) System.out.println ("\t\t\tAdajacência não encontrada, atribuindo ao tipo \"ID\"");
					state = 53;
					break;
				}
			}
			type = graphManager.determineType (state);
			tokens.add (new Token (type, word));
			
			/* if (debugMode) System.out.println ("\t\t pertence a: " + type);
			else System.out.println (" " + type); */

			state = 0;
			if (k == words.size() - 1) break;
			else k ++;
		}
		// System.out.println("\n");
	}

	public void printTokens (){
		for (Token i : tokens) {
			System.out.println (i.toString ());
		}
	}

	public ArrayList<Token> getResult(){
		return tokens; 
	}
}

