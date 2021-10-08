
import java.util.Stack;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Automata {
	public static void main (String[] Args)
	{
		Stack<String> stack = new Stack<String>(); // push, pop, peek
		Stack<Token> tokens;
		Reader reader = new Reader("Resultado Lexico.txt");
		ArrayList<String> terminalSymbols = new ArrayList<String>();

		
		loadTerminalSymbols(terminalSymbols);

		tokens = reader.readFile();
		boolean hasUnrecWords = false;
		if(tokens == null)
			hasUnrecWords = true;

		System.out.println("\n");
		if (!hasUnrecWords) {
			stack.push("S");
			boolean complete = false;
			Token token = tokens.pop();
			int k = 0;
			String top = null;
			loadS(stack);
			boolean locked = false;
			while(!stack.empty()) {

				top = stack.pop();
				System.out.println("-------------");
				System.out.println(" > Valor da pilha que vai ser trabalhado: " + top);
				if(k > 0) {
					if(!locked){
						if(!tokens.empty())
							token = tokens.pop();
					}
					if(!terminalSymbols.contains(top))
						locked = true;
					else if(locked)
						locked = false;
				}

				System.out.println(" > Token que vai ser trabalhado: " + token.getInfo());


				if (top.equals("S")){
					if(token.getInfo().equals("("))
						loadS(stack);
				}
				else if(top.equals("F")){
					if(token.getInfo().equals("cond"))
						stack.push("cond");
					else if(token.getInfo().equals("car"))
						stack.push("car");
					else if(token.getInfo().equals("cdr"))
						stack.push("cdr");
					else if(token.getInfo().equals("if"))
						stack.push("if");
					else if(token.getInfo().equals("list"))
						stack.push("list");
					else if(token.getInfo().equals("+"))
						stack.push("+");
					else if(token.getInfo().equals("-"))
						stack.push("-");
					else if(token.getInfo().equals("*"))
						stack.push("*");
					else if(token.getInfo().equals("/"))
						stack.push("/");
					else if(token.getInfo().equals("<"))
						stack.push("<");
					else if(token.getInfo().equals(">"))
						stack.push(">");
					else if(token.getInfo().equals("eq"))
						stack.push("eq");
					else if(token.getInfo().equals("neq"))
						stack.push("neq");
					else if(token.getInfo().equals("leq"))
						stack.push("leq");
					else if(token.getInfo().equals("geq"))
						stack.push("geq");
					else break;
				}
				else if(top.equals("C")){
					if(token.getInfo().equals("(")){
						stack.push("C");
						stack.push(")");
						stack.push("A");
						stack.push("F");
						stack.push("(");
					}
					else if(token.getType().equals("PR")){
						stack.push("R");
					}
					else if(token.getType().equals("NU")){
						stack.push("C");
						stack.push("numero");
					}
					else if(token.getType().equals("ID")){
						stack.push("C");
						stack.push("identificador");
					}
				       	else if(!token.getType().equals("DL") || !token.getInfo().equals(")"))
						break;
				}
				else if(top.equals("R")){
					if(token.getInfo().equals("T"))
						stack.push("T");
					else if(token.getInfo().equals("nil"))
						stack.push("nil");
					else break;
				}
				else if(top.equals("A")){
					if(token.getInfo().equals("(")){
						stack.push("A");
						stack.push(")");
						stack.push("A");
						stack.push("(");
					}
					if((token.getType().equals("PR") || token.getType().equals("OP")) && !token.getInfo().equals("T") && !token.getInfo().equals("nil")){
						stack.push("A");
						stack.push("F");
					}
					else if(token.getType().equals("NU")){
						stack.push("A");
						stack.push("numero");
					}
					else if(token.getType().equals("ID")){
						stack.push("A");
						stack.push("identificador");
					}
					else if(token.getInfo().equals("T") || token.getInfo().equals("nil")) {
						stack.push("A");
						stack.push("R");
					}
					else if(!token.getType().equals("DL"))
						break;
				}
				else if(top.equals("L")){
					if(token.getType().equals("ID")){
						stack.push("L");
						stack.push("identificador");
					}
					else if(!token.getType().equals("DL"))
						break;
				}
				else if(top.equals("N")){
					if(token.getType().equals("ID")) {
						stack.push("identificador");
					}
					else break;
				}
				// a partir daqui, apenas símbolos terminais
				else if(!terminalSymbols.contains(top)) {
					break;
				}
				if(tokens.empty())
					complete = true;
				k++;
			}

			if(!complete) {
				System.out.println ("Entrada não faz parte da linguagem");
			}
			else {
				System.out.println ("Todos tokens processados: texto reconhecido");
			}
		}
		else
			System.out.println ("A entrada contém palavras que não fazem parte da linguagem.");
	}

	public static void loadS (Stack<String> stack)
	{
		stack.push(")");
		stack.push("C");
		stack.push(")");
		stack.push("L");
		stack.push("(");
		stack.push("N");
		stack.push("defun");
		stack.push("(");
	}

	public static void loadTerminalSymbols(ArrayList<String> terminalSymbols)
	{
		terminalSymbols.add("(");
		terminalSymbols.add(")");
		terminalSymbols.add("defun");
		terminalSymbols.add("identificador");
		terminalSymbols.add("cond");
		terminalSymbols.add("car");
		terminalSymbols.add("cdr");
		terminalSymbols.add("if");
		terminalSymbols.add("numero");
		terminalSymbols.add("list");
		terminalSymbols.add("+");
		terminalSymbols.add("-");
		terminalSymbols.add("*");
		terminalSymbols.add("/");
		terminalSymbols.add("<");
		terminalSymbols.add("<");
		terminalSymbols.add("eq");
		terminalSymbols.add("leq");
		terminalSymbols.add("neq");
		terminalSymbols.add("geq");
		terminalSymbols.add("new");
		terminalSymbols.add("T");
		terminalSymbols.add("nil");
	}
}
