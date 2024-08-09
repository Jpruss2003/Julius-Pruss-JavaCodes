// Test file to be completed
// First build the tree described in the assignment
// Then test the three traversal methods
// Then use iterators to do three traversal where
// you print the ASCII code of each character in a node



package cs0048spring2024.assign2;

import TreePackage.*;
import StackAndQueuePackage.*;
import java.util.Iterator;

public class Assign2 {

    public static void main(String[] args) {
        
        BinaryTree<Character> treeD = new BinaryTree<>('d');
        BinaryTree<Character> treeB = new BinaryTree<>('b');
        BinaryTree<Character> treeQ = new BinaryTree<>('q', treeD, treeB);
        
        BinaryTree<Character> treeP = new BinaryTree<>('p');
        BinaryTree<Character> treeH = new BinaryTree<>('h', treeQ, treeP);
        
        
        BinaryTree<Character> treeX = new BinaryTree<>('x', treeH, null);
        
        
        
        BinaryTree<Character> treeN = new BinaryTree<>('n');
        BinaryTree<Character> treeC = new BinaryTree<>('c',treeN, null);
       
        
        BinaryTree<Character> treeT = new BinaryTree<>('t');
        BinaryTree<Character> treeW = new BinaryTree<>('w', treeC, treeT);
        
        BinaryTree<Character> treeS = new BinaryTree<>('s');
        BinaryTree<Character> treeG = new BinaryTree<>('g',null, treeS);
        
        BinaryTree<Character> treeV = new BinaryTree<>('v', treeG, treeW);
        
        
        BinaryTree<Character> myTree = new BinaryTree<>('a', treeX, treeV);
        
        
        System.out.println("preOrder Traversal: ");
        myTree.iterativePreorderTraverse();
        System.out.println();
        
        
        
        System.out.println("inOrder Traversal: ");
        myTree.iterativeInorderTraverse();
        System.out.println();
        
        
        System.out.println("level Order Traversal: ");
        myTree.iterativeLevelorderTraverse();
        System.out.println();
        
        
        Iterator<Character> myIterator = myTree.getPreorderIterator();
        while (myIterator.hasNext()){
            System.out.println("0" + Integer.toBinaryString((int) myIterator.next()));
            
        }
        
        Iterator<Character> myIterator2 = myTree.getInorderIterator();
        while(myIterator2.hasNext()){
            System.out.println("0" + Integer.toBinaryString((int) myIterator2.next()));
        }
        
        Iterator<Character> myIterator3 = myTree.getLevelOrderIterator();
        while(myIterator3.hasNext()){
            System.out.println("0" + Integer.toBinaryString((int) myIterator3.next()));
        }
        
        
    }
}
