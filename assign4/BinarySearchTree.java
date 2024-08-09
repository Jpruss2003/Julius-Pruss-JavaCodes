package cs0048spring2024.assign4;

// Complete the methods as explained before
// Do not change complete methods (noted below)
// Do not change the main

// There are no duplicates in the tree
// Any new item that is added is not already in the tree
// For comparisons of T objects DO NOT USE CONDITIONS LIKE
// T1 > T2, T2 <= T1
// Objects of type T MUST BE COMPARED AS FOLLOWS.
// T1.compareTo(T2) < 0 is true when T1 is less than T2
// T1.compareTo(T2) > 0 is true when T1 is greater than T2 
// T1.compareTo(T2) == 0 is true when T1 is equal to T2
// T1.equals(T2) is true when T1 is equal to T2

public class BinarySearchTree<T extends Comparable<? super T>> { 
	
	// Inner class to represent a BinaryNode<T>
	class BinaryNode<T> {
		private T data;
		private BinaryNode<T> left;
		private BinaryNode<T> right;
		
		public BinaryNode(T d) {
			data = d;
			left = null;
			right = null;
		}
	} // End inner class
	
	// Every tree is represented by its root
	private BinaryNode<T> root;

	// Constructor
	public BinarySearchTree() {
		root = null;
	}
	
	// This method is complete
	public boolean recSearch(T searchItem ) {
		return bstRecSearch(root, searchItem);
	}
		
	// Complete the method below
	// The recursive method will return true if searchItem is in the tree 
	// rooted at root. If not found it returns false
	public boolean bstRecSearch(BinaryNode<T> root, T searchItem ) {
            if(root == null){
                return false;
            }
            else if(searchItem.equals(root.data)){
                return true;
            }
            else if(searchItem.compareTo(root.data) < 0){
                return bstRecSearch(root.left, searchItem);
            }
            else{
                return bstRecSearch(root.right, searchItem);
           
            
            }





	}

	// This method is complete
	public boolean iterSearch(T searchItem ) {
		if (root == null)
			return false;
		else
			return bstIterSearch(root, searchItem);
	}
	
	// Complete the method below
	// This iterative method will return true if searchItem is in the tree 
	// rooted at root. If not found it returns false
	public boolean bstIterSearch(BinaryNode<T> root, T searchItem)  {
            boolean found = false;
            BinaryNode<T> currentNode = root;
            while(!found && currentNode!= null){
                if(searchItem.equals(currentNode.data)){
                    found = true;
                }
                else if(searchItem.compareTo(currentNode.data) < 0){
                    currentNode = currentNode.left;
                }
                else{
                    currentNode = currentNode.right;
                    
            
                }
                    




            }
            return found;
	}
	
	// This method is complete
	public void recInsert(T newEntry) {
		if (root == null)
			root = new BinaryNode<T>(newEntry);
		else	
			bstRecInsert(root, newEntry);
	}
	
	// Complete the method below
	// This recursive method will insert newEntry into its correct
	// position in the binary search tree rooted at root
	public void bstRecInsert(BinaryNode<T> root, T newEntry)  {
            if(newEntry.compareTo(root.data) < 0){
                if(root.left !=null){
                    bstRecInsert(root.left, newEntry );
                }else
                    root.left = new BinaryNode<T>(newEntry);
                
            }else{
                if(root.right != null){
                    bstRecInsert(root.right, newEntry );
                
                }else{
                    root.right = new BinaryNode<T>(newEntry);
                }
                        
                
            
            }    
                       
            
             
                    
            
        
    












	}
	
	// This method is complete
	public void iterInsert(T newEntry) {
		if (root == null)
			root = new BinaryNode<T>(newEntry);
		else	
			bstIterInsert(root, newEntry);
	}
	
	// Complete the method below
	// This iterative method will insert newEntry into its correct
	// position in the binary search tree rooted at root
	public void	bstIterInsert(BinaryNode<T> root, T newEntry) {
            boolean placed = false;
            BinaryNode<T> currentNode = root;
            while(!placed){
                if(newEntry.compareTo(currentNode.data) < 0){
                    if(currentNode.left != null){
                        currentNode = currentNode.left;
                    }
                    else
                        currentNode.left = new BinaryNode<>(newEntry);
                        placed = true;
                }else
                    if(currentNode.right != null){
                        currentNode = currentNode.right;
                    }
                    else
                        currentNode.right = new BinaryNode<>(newEntry);
                        placed = true;
                    
                
                    
                    
                        
                
            }
                







	}
	
	// This method is complete
	public boolean bstDelete(T anEntry) {
		if (root == null) 
			return false;
		else {
			return (bstRecDelete(root, anEntry) != null);
		}
	}
	
	// Complete the method below
	// This recursive method will delete the node whose data matches anEntry
	// The method will return the root of the tree after the deletion has occurred 
	// Returns null if no deletion occurred

	public BinaryNode<T> bstRecDelete(BinaryNode<T> root, T anEntry) {
		// Declare any variables here
		BinaryNode<T> parentNode = root;
                
		
		if (root == null)
			return null;
		
		else if (anEntry.equals(root.data)) {
			// Handle 4 cases
			// 1. root has no children
			// 2. root has a left child but no right child
			// 3. root has a right child but no left child
			// 4. root has a left child and a right child
                        if(parentNode.left.left == null && parentNode.right.right == null){
                            return null;
                        }
                        
                        if(parentNode.left.left != null && parentNode.right.right == null){
                            parentNode.left = parentNode.left.left;
                        }
                        if(parentNode.left.left == null && parentNode.right.right != null){
                           parentNode.right = parentNode.right.right;
                        }
                        if(parentNode.left.left != null && parentNode.right.right != null){
                            maxVal(root.left);
                        }
                            
                
                        
			 
			
			
			
			
			
			
		else if (anEntry.compareTo(root.data) < 0) {
			bstRecDelete(root.left, anEntry);
			
			
			
			
			
			
		}
		else  {
                   bstRecDelete(root.right, anEntry);
                   






		}
             
	}
            return root;  
        }
		
	// This method is complete
        public T minVal() {
            return minVal(root);
    }
	// Complete the method below
	// Returns the smallest value in the tree rooted at root
	public T minVal(BinaryNode<T> root) {
            while(root.left != null){
                root = root.left;
            }
        return root.data;

	}
	
	// This method is complete
	public T maxVal() {
		return maxVal(root);
	}
	
	// Complete the method below
	// Returns the largest value in the tree rooted at root
	public T maxVal(BinaryNode<T> root) {
            while (root.right!=null){
                root = root.right;
                
            }
            
        return root.data;
            
        }
	// This method is complete
	public void postOrderTraversal() {
		System.out.print("Post Order Traversal: ");
		postOrderTraversal(root);
		System.out.println();
	}
	
	// Complete this method
	// Carries out a recursive postorder traversal
	// Print each node as it is visited
	public void postOrderTraversal(BinaryNode<T> root) {
            if(root != null){
                postOrderTraversal(root.left);
                postOrderTraversal(root.right);
                System.out.println(root.data + " ");
            }
            



	}

	// This method is complete
	public void inOrderTraversal() {
		System.out.print("In Order Traversal: ");
		inOrderTraversal(root);
		System.out.println();
	}
	

	// Complete this method
	// Carries out a recursive inorder traversal
	// Print each node as it is visited
	public void inOrderTraversal(BinaryNode<T> root) {
            if(root != null){
                inOrderTraversal(root.left);
                System.out.println(root.data + " ");
                inOrderTraversal(root.right);
        }




	}
	
	
	// Do not change the main
	public static void main(String[] args) {
		BinarySearchTree<String> testTree = new BinarySearchTree<String>();

		System.out.println("Recursive Algorithms");

		testTree.recInsert("Gladys");
		testTree.recInsert("Cabby");
		testTree.recInsert("Enya");
		testTree.recInsert("Mona");
		testTree.recInsert("Polly");
		testTree.recInsert("Fee");
		testTree.recInsert("Anne");
		testTree.recInsert("Ernie");	
		testTree.recInsert("Etosha");	
		testTree.recInsert("Hector");
		testTree.recInsert("Ian");	
		testTree.recInsert("Percy");
		testTree.recInsert("Eric");	
		
		System.out.println("Minimum value in tree is " + testTree.minVal());
		System.out.println("Maximum value in tree is " + testTree.maxVal());
		
		System.out.println("Jat is in the tree? " + testTree.recSearch("Jat"));
		System.out.println("Eric is in the tree? " + testTree.recSearch("Eric"));
		System.out.println("Des is in the tree? " + testTree.recSearch("Des"));
		System.out.println("Polly is in the tree? " + testTree.recSearch("Polly"));


		testTree.inOrderTraversal();
		testTree.postOrderTraversal();
		System.out.println("Eric was deleted? " + testTree.bstDelete("Eric"));
		System.out.println("Polly was deleted? " + testTree.bstDelete("Polly"));
		System.out.println("Mona was deleted? " + testTree.bstDelete("Mona"));
		System.out.println("Gladys was deleted? " + testTree.bstDelete("Gladys"));
		System.out.println("Percy is in the tree? " + testTree.recSearch("Percy"));
		System.out.println("Eric is in the tree? " + testTree.recSearch("Eric"));
		System.out.println("Mona is in the tree? " + testTree.recSearch("Mona"));
		System.out.println("Ian is in the tree? " + testTree.recSearch("Ian"));
		
		testTree.inOrderTraversal();
		testTree.postOrderTraversal();



		System.out.println("\nIterative Algorithms");

		testTree = new BinarySearchTree<String>();

		testTree.iterInsert("Gladys");
		testTree.iterInsert("Cabby");
		testTree.iterInsert("Enya");
		testTree.iterInsert("Mona");
		testTree.iterInsert("Polly");
		testTree.iterInsert("Fee");
		testTree.iterInsert("Anne");
		testTree.iterInsert("Ernie");	
		testTree.iterInsert("Etosha");	
		testTree.iterInsert("Hector");
		testTree.iterInsert("Ian");	
		testTree.iterInsert("Percy");
		testTree.iterInsert("Eric");	
		
		
		System.out.println("Minimum value in tree is " + testTree.minVal());
		System.out.println("Maximum value in tree is " + testTree.maxVal());
		
		System.out.println("Jat is in the tree? " + testTree.iterSearch("Jat"));
		System.out.println("Eric is in the tree? " + testTree.iterSearch("Eric"));
		System.out.println("Des is in the tree? " + testTree.iterSearch("Des"));
		System.out.println("Polly is in the tree? " + testTree.iterSearch("Polly"));

		testTree.inOrderTraversal();
		testTree.postOrderTraversal();



	}
}
	
		

		
		