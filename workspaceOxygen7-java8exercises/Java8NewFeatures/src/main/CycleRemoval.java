package main;


import java.util.*; 

public class CycleRemoval {

	// Java program to detect and remove loop in a linked list 
	

		 MyNode head; // head of list 

		/* Linked list Node*/
		 class MyNode { 
			int data; 
			MyNode next; 
			MyNode(int d) 
			{ 
				data = d; 
				next = null; 
			} 
		} 

		/* Inserts a new Node at front of the list. */
		 public void push(int new_data) 
		{ 
			/* 1 & 2: Allocate the Node & 
					Put in the data*/
			MyNode new_node = new MyNode(new_data); 

			/* 3. Make next of new Node as head */
			new_node.next = head; 

			/* 4. Move the head to point to new Node */
			head = new_node; 
		} 

		// Function to print the linked list 
		 void  printList(MyNode node) 
		{ 
			while (node != null) { 
				System.out.print(node.data + " "); 
				node = node.next; 
			} 
		} 

		// Returns true if the loop is removed from the linked 
		// list else returns false. 
		boolean removeLoop(MyNode h) 
	    { 
	        HashSet<MyNode> s = new HashSet<MyNode>(); 
	        MyNode prev = null; 
	         while (h != null) {
	            // If we have already has this node 
	            // in hashmap it means their is a cycle and we 
	            // need to remove this cycle so set the next of 
	            // the previous pointer with null. 
	  
	            if (s.contains(h)) { 
	                prev.next = null; 
	                return true; 
	            } 
	  
	            // If we are seeing the node for 
	            // the first time, insert it in hash 
	            else { 
	                s.add(h); 
	                prev = h; 
	                h = h.next; 
	            } 
	        } 
	  
	        return false; 
	    } 

		/* Driver program to test above function */
		public static void main(String[] args) 
		{ 
			CycleRemoval llist = new CycleRemoval(); 
	        
	        
	  
	        llist.push(20); 
	        llist.push(4); 
	        llist.push(15); 
	        llist.push(10);
	        llist.push(20); 
	        llist.push(3); 
	  
	        /*Create loop for testing */
	        llist.head.next.next.next.next.next.next = llist.head; 
	        

	  
	        if (llist.removeLoop(llist.head)) { 
	            System.out.println("Linked List after removing loop"); 
	            llist.printList(llist.head); 
	        } 
	        else
	            System.out.println("No Loop found"); 
	    } 
		
	} 



