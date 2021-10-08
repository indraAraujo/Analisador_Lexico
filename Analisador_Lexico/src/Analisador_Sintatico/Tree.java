package Analisador_Sintatico;

import java.util.*;
 
class NodeTemp{
    String token;
    NodeTemp next, child;
    public NodeTemp(String token){
        this.token = token;
        next = child = null;
    }
}
class Tree{
 
    
     
    // Adds a sibling to a list with starting with n
     public NodeTemp addSibling(NodeTemp node, String token) {
        if(node == null)
            return null;
        while(node.next != null)
            node = node.next;
        return(node.next = new NodeTemp(token));
    }
         
    // Add child Node to a Node
     public NodeTemp addChild(NodeTemp node, String token){
        if(node == null)
            return null;
     
        // Check if child is not empty.
        if(node.child != null)
            return(addSibling(node.child,token));
        else
            return(node.child = new NodeTemp(token));
    }
 
    // Traverses tree in depth first order
     public void traverseTree(NodeTemp root)
    {
        if(root == null)
            return;
        while(root != null)
        {
            System.out.print(root.token + " ");
            if(root.child != null)
                traverseTree(root.child);
            root = root.next;
        }
    }
}