package main;

import java.util.ArrayList;
import java.util.Stack;

public class DfsNonRecursive {
	static void traversal (Node node) {
		
		if (node == null) 
            return; 
		Stack<Node> stack = new Stack<>();
		
		
		Node current = node;
		
//		System.out.println("outside "+current.data);	
		while(current!=null  || !(stack.isEmpty())) {
			while (current !=  null) {
			 	stack.push(current);
			 	current=current.left;
			}
			 	
			current = stack.pop();
			 System.out.println(current.data);
			 current = current.right;
		}
			
		
		
//		 while (current !=  null) {
//				 	stack.push(current);
//				 	current=current.left;
//				 	while(current!=null  && (!(stack.isEmpty()))) {
//				 			current = stack.pop();
//				 			System.out.println(current.data);
//				 			current = current.left;
//				 	}
//				
//			
//			} 
		
		}

}
