// MyList class is exactly the same as the LList class from the book
// You must add 8 extra methods and a main
// Do not change any of the existing code

public class MyList<T> implements ListInterface<T>
{
	private Node firstNode;
	private int  numberOfEntries;
	
	public MyList()
	{
		initializeDataFields();
	}
	
	public void clear()
	{
		initializeDataFields();
	}
	
	public void add(T newEntry)	
	{
		Node newNode = new Node(newEntry);
		
		if (isEmpty())
			firstNode = newNode;
		else
		{
			Node lastNode = getNodeAt(numberOfEntries);
			lastNode.setNextNode(newNode);
		} 
		
		numberOfEntries++;
	}

	public void add(int givenPosition, T newEntry)
	{
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1))
		{
			Node newNode = new Node(newEntry);
			if (givenPosition == 1)	
			{
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			}
			else
			{
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeAfter = nodeBefore.getNextNode();
				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			}
			numberOfEntries++;
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to add operation.");
	}

	public T remove(int givenPosition)
	{
		T result = null;
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			if (givenPosition == 1)	
			{
				result = firstNode.getData();
				firstNode = firstNode.getNextNode(); 
			}
			else
			{
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeToRemove = nodeBefore.getNextNode();
				result = nodeToRemove.getData();
				Node nodeAfter = nodeToRemove.getNextNode();
				nodeBefore.setNextNode(nodeAfter);
		  }
			numberOfEntries--;	
			return result;
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
	}

	public T replace(int givenPosition, T newEntry)
	{
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			Node desiredNode = getNodeAt(givenPosition);
			T originalEntry = desiredNode.getData();
			desiredNode.setData(newEntry);
			return originalEntry;
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
	}

	public T getEntry(int givenPosition)
	{
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			return getNodeAt(givenPosition).getData();
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
	}
	
	public T[] toArray()
	{
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		
		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null))
		{
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		}
		
		return result;
	} 
															
	public boolean contains(T anEntry)
	{
		boolean found = false;
		Node currentNode = firstNode;
		
		while (!found && (currentNode != null))
		{
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		}
		
		return found;
	}

	public int getLength()
	{
		return numberOfEntries;
	}

	public boolean isEmpty()
	{
		boolean result;
		
		if (numberOfEntries == 0)
		{
			result = true;
		}
		else
		{
			result = false;
		} 
		
		return result;
	}
	
	// Put new methods here
	// When writing the methods you do not need to access the list directly.
	// Instead use the numberOfEntries instance variables 
	// and the methods that already exist in the class
	

        public void swap(int position1, int position2) {
           T temp = this.getEntry(position1);
           this.replace(position2, temp);
           this.getNodeAt(position2);
           this.replace(position1, temp);
	
	
        }
        
        public void reverse(){
            for(int i = 0; i < numberOfEntries / 2; i ++){
                this.swap(i, numberOfEntries - i - 1);
            }
        }
        public int firstIndexOf(T item){
            for(int i = 0; i < numberOfEntries; i++){
                if(this.getEntry(i).equals(item)){
                    return i;
                }
            }
            return -1;
        }
        public int lastIndexOf(T item){
            for(int i = numberOfEntries-1; i >= 0; i--){
                if(this.getEntry(i).equals(item)){
                    return i;
                }
            }
            return -1;
        }
        public int occurences(T item){
            int count = 0;
            for(int i = 0; i < numberOfEntries; i++){
                if(this.getEntry(i).equals(item)){
                    count++;
            }
     
        }
            return count;
        }
        public void removeOccurences(T item){
            for(int i = 0; i < numberOfEntries; i++){
                if(this.getEntry(i).equals(item)){
                    this.remove(i);
                }
                
            }
        }
        public void shuffle(){
            int random1;
            int random2;
            int randomT = (int)(Math.random()*101);
            for(int i = 0; i <= randomT; i++){
                int range = (numberOfEntries-1)+1;
                random1 = (int)(Math.random()*range)+1;
                random2 = (int)(Math.random()*range)+1;
                this.swap(random1, random2);
            }
        }
        public String toString(){
            String temp1 = "";
            for(int i = 1; i<=numberOfEntries;i++){
                temp1 = temp1 + i + ")" + this.getEntry(i);
            }
           return temp1;
        }
	private void initializeDataFields()
	{
		firstNode = null;
		numberOfEntries = 0;
	}
	
	private Node getNodeAt(int givenPosition)
	{
		Node currentNode = firstNode;
		
		for (int counter = 1; counter < givenPosition; counter++)
			currentNode = currentNode.getNextNode();
		
		return currentNode;
	}
	
	// Inner class 
	private class Node
	{
		private T	 data;
		private Node next;
		
		private Node(T dataPortion)
		{
			data = dataPortion;
			next = null;
		}
		
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;
		}
		
		private T getData()
		{
			return data;
		}
		
		private void setData(T newData)
		{
			data = newData;
		}
		
		private Node getNextNode()
		{
			return next;
		}
		
		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		} 
	}  // end of inner class


	public static void main(String[] args) {
            MyList<String> newList = new MyList<>();
            newList.add("November");
            newList.add("May");
            newList.add("August");
            newList.add("January");
            newList.add("November");
            newList.add("January");
            newList.add("January");
            newList.add("March");
            
            newList.swap(1, 4);
            System.out.println("After swaping the order from 1 to 4: " + newList);
            
            newList.reverse();
            System.out.println("After reversing the order in the newList: "+ newList);
            
            System.out.println("The first occurence of January in the list is: " + newList.firstIndexOf("January"));
            System.out.println("The last ocurrence of January in the list is: "+ newList.lastIndexOf("January"));
            System.out.println("January appears in list: " + newList.occurences("January"));
            
            newList.removeOccurences("January");
            System.out.println("The occurences removed from January is: " + newList);
            
             newList.shuffle();
             System.out.println("The list after it is shuffle: ");
	
	
	
	}	
		
}
	
	
	