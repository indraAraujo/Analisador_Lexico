package Analisador_Sintatico;

import java.util.Stack;

public class Main {
    public static void main(String args[]) {
        Stack pilha = new Stack();

        pilha.push("S");
        System.out.println(pilha.peek());

        pilha.push("(defun N (L) C) S");
        System.out.println(pilha.peek());

        pilha.push("identificador");
        System.out.println(pilha.peek());
        System.out.println("Item de valor " + pilha.pop() + " retirado da pilha");
        System.out.println("Item atual no topo: " + pilha.peek());
        System.out.println("Item de valor " + pilha.pop() + " retirado da pilha");
        System.out.println("Item atual no topo: " + pilha.peek()); 
    }

}