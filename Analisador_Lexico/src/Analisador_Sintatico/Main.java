package Analisador_Sintatico;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String args[]) {
        Reader leitor = new Reader("Resultado Lexico.txt");
        Stack<Token> tokens = leitor.readFile();

        System.out.println(tokens.peek());
        /*Stack pilha = new Stack();

        pilha.push("S");
        System.out.println(pilha.peek());

        pilha.push("(defun N (L) C) S");
        System.out.println(pilha.peek());

        pilha.push("identificador");
        
        System.out.println("Item de valor " + pilha.pop() + " retirado da pilha");
        System.out.println("Item atual no topo: " + pilha.peek());
        System.out.println("Item de valor " + pilha.pop() + " retirado da pilha");
        System.out.println("Item atual no topo: " + pilha.peek()); */
    }

}