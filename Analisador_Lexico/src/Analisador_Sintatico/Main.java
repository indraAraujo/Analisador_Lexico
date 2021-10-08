package Analisador_Sintatico;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String args[]) {
        Tree arvore = new Tree();
        NodeTemp root = new NodeTemp("S");
        NodeTemp n9 = arvore.addChild(root,"(");
        NodeTemp n1 = arvore.addChild(root,"defun");
        NodeTemp n2 = arvore.addChild(root,"N");
        NodeTemp n3 = arvore.addChild(root,"(");
        NodeTemp n4 = arvore.addChild(root,"L");
        NodeTemp n5 = arvore.addChild(root,")");
        NodeTemp n6 = arvore.addChild(root,"C");
        NodeTemp n7 = arvore.addChild(root,")");
        NodeTemp n8 = arvore.addChild(root,"S");
        NodeTemp n10 = arvore.addChild(n2,"identificador");

         
        arvore.traverseTree(root);

        /*
        Reader leitor = new Reader("Resultado Lexico.txt");
        Stack<Token> tokens = leitor.readFile();

        System.out.println(tokens.peek());
        */
    }

}