/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

import java.util.Scanner;

/**
 *
 * @author Ngugi
 */
public class BST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 
        Tree bst = new Tree();
       Scanner scan = new Scanner(System.in);
       String choice ;
       do{
       System.out.println("***********Create a new contact*************");
       System.out.println("__________Enter first name________________");
       Contact contact = new Contact();
       contact.setFirstName(scan.next());
       System.out.println("____________Enter last name_________________");
       contact.setLastName(scan.next());
       System.out.println("Enter telephone number");
       contact.setTelephone(scan.nextLong());
       Node toInsert = new Node();
       toInsert.contact = contact;
       bst.insertNode(toInsert);
       System.out.println("Press Y to add another Contact or N to exit");
       choice = scan.next();
       }while(choice.equals("Y")||choice.equals("y"));
       System.out.println("Enter a name to search");
       String name = scan.next();
       Node node = bst.findContact(name);
       if(node!=null)
       {
           System.out.println("Found "+node.contact.getTelephone());
       }else
       {
           System.out.println("Contact not found");
       }
       System.out.println("Enter name to update");
       String uname = scan.next();
       System.out.println("Enter updated phone number");
       long num = scan.nextLong();
       if(bst.updateContact(uname, num)){
           System.out.println("Updated");
       }else{
           System.out.println("Not updated");
       }
      Node n = bst.findContact(uname);
      if(n!=null)System.out.println(n.contact.getTelephone()+" New number");
      if(bst.deleteContact(uname))
      {
          System.out.println("Deleted");
      }
      else
      {
          System.out.println("Failed");
      }
      
    }
    
}
