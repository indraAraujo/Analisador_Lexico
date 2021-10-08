package Analisador_Sintatico;

public class Automata {
        Stack stack = new Stack(); // push, pop, peek
		Stack tokens;
		boolean complete = false;
		ArrayList<int> historic = new ArrayList<int>();

		// tokens = getTokensFromFile();
		
		if (TokensDontHaveUnrecWords ()) {
			Main.loadS(stack);
			while(!stack.empty()) {
				String top = stack.pop();
				Token token = tokens.pop();
				System.out.println("Processando " + top);
				if (top.equals("S")){
					Main.loadS();
				}
				else if(top.equals("F")){
					[...];
				}
				else if(top.equals("C")){
					[...];
				}
				else if(top.equals("R")){
					[...];
				}
				else if(top.equals("A")){
					[...];
				}
				else if(top.equals("L")){
					[...];
				}
				else if(top.equals("N")){
					if(token.type.equals("ID"))
						continue;
					else break;
				}
				else if(top.equals("V")){
					[...];
				}
				else if(top.equals("U")){
					[...];
				}
				else if(top.equals("I")){
					[...];
				}
				// a partir daqui, apenas símbolos terminais
				else if(top.equals("(") || top.equals(")") || top.equals("defun")
						|| top.equals("cond") || top.equals("car")|| top.equals("cdr")
						|| top.equals("list") {
					continue;
				}
				else {
					break;
				}

				if(tokens.empty())
					complete = true;
			}

			if(!complete) {
				System.out.println ("Entrada não faz parte da linguagem");
			}
			else {
				System.out.println ("Todos tokens processados");
			}
		}
		else
			System.out.println ("A entrada contém palavras que não fazem parte da linguagem.");
	}


	public static void loadS (Stack stack)
	{
		stack.push("S");
		stack.push(")");
		stack.push("C");
		stack.push(")");
		stack.push("L");
		stack.push("(");
		stack.push("N");
		stack.push("defun");
		stack.push("(");
	}
}
