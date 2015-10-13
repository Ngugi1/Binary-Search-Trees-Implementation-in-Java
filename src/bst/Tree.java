/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 *
 * @author Ngugi
 */
public class Tree {
    private Node root;
    public Node getRoot(){
        return this.root;
    }
    public Tree()
    {
        root= null;
    }
    public void insertNode(Node toInsert){
        if(root==null)
        {
            root= toInsert;
            System.out.println("At root");
        } //Empty tree
        
        //Insert into a non-empty tree
        
        else{
        Node current = root;
        Node parent;
        while(true){
          parent = current;
          int lexCompare = toInsert.contact.getFirstName().compareTo(current.contact.getFirstName());
          if(lexCompare<0)
          {
           //Here we will finally set the value of the current node , therefore a parent is required
           //For us to keep track
           current = current.leftChild;
           if(current==null){
               parent.leftChild = toInsert;
               System.out.println("Inserted in left subtree");
               return;
            }
          }
          else
          {
             //If the value at node x is greater than or equal , add it to the right subtree
              current = current.rightChild;
              if(current==null){
                  parent.rightChild = toInsert;
                  System.out.println("Inserted in right subtree");
                  return;
                }
            }
          }
        }
    }
    public Node findContact(String name){
   Node current= root; //start at the root
   if(root==null) return null; //Return null is the tree is empty
   while(!current.contact.getFirstName().equals(name)) //While there is no match , keep looking
   {
       int compare = name.compareTo(current.contact.getFirstName()); //compare lexicongraphically
       if(compare<0)
       {
         current = current.leftChild;  
       }else
       {
           current = current.rightChild;
       }
       if(current==null)return null;
       
   }
   return current;
}
    public boolean updateContact(String name , long tel){
      boolean updated = false;
      Node current = root;
      if(root==null) return updated;
      else
      {
          while(!current.contact.getFirstName().equals(name))
          {
              int compare = name.compareTo(current.contact.getFirstName());
              if(compare<0)current = current.leftChild;
              else current= current.rightChild;
          }
          if(current.contact.getFirstName().equals(name)) 
          {
              current.contact.setTelephone(tel);
              System.out.println(current.contact.getTelephone()+"Update Method");
              updated=true;
          }else
          {
           updated = false;   
          }
      }
      return updated;
    }
    public boolean deleteContact(String name){
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while(!current.contact.getFirstName().equals(name)){
			parent = current;
			if(current.contact.getFirstName().compareTo(name)>0)
                        {
				isLeftChild = true;
				current = current.leftChild;
			}else
                        {
				isLeftChild = false;
				current = current.rightChild;
			}
			if(current ==null){
				return false;
			}
		}
		//if i am here that means we have found the node
		//Case 1: if node to be deleted has no children
		if(current.leftChild==null && current.rightChild==null){
			if(current==root){
				root = null;
			}
			if(isLeftChild ==true){
				parent.leftChild = null;
			}else{
				parent.rightChild= null;
			}
		}
		//Case 2 : if node to be deleted has only one child
		else if(current.rightChild==null){
			if(current==root){
				root = current.leftChild;
			}else if(isLeftChild){
				parent.leftChild = current.leftChild;
			}else{
				parent.rightChild = current.leftChild;
			}
		}
		else if(current.leftChild==null){
			if(current==root){
				root = current.rightChild;
			}else if(isLeftChild){
				parent.leftChild = current.rightChild;
			}else{
				parent.rightChild = current.rightChild;
			}
		}else if(current.leftChild!=null && current.rightChild!=null){
			
			//now we have found the minimum element in the right sub tree
			Node successor	 = getSuccessor(current);
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.leftChild = successor;
			}else{
				parent.rightChild = successor;
			}			
			successor.leftChild = current.leftChild;
		}		
		return true;		
	}
    public Node getSuccessor(Node deleleNode){
		Node successsor =null;
		Node successsorParent =null;
		Node current = deleleNode.rightChild;
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.leftChild;
		}
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
//		successsorParent
		if(successsor!=deleleNode.rightChild){
			successsorParent.leftChild = successsor.rightChild;
			successsor.rightChild = deleleNode.rightChild;
		}
		return successsor;
	}
}
   
