package bst;
/**
 *
 * @author Ngugi Ndung'u
 */
public class Node 
{
    Node leftChild;
    Node rightChild;
    Contact contact;
    
    //Node has left and right children set to null
    public Node()
    {
    this.leftChild = this.rightChild = null;
    this.contact = null;
    }
    //Setters and getters
    public void setContact(Contact contact)
    {
        this.contact = contact;
    }
    public Contact getContact(){
        return this.contact;
    }
    public void setRightChild(Node rightNode){
        this.rightChild = rightNode;
    }
    public Node getRightNode(){
        return this.rightChild;
    }
    
    public void setLeftChild(Node leftNode){
        this.leftChild = leftNode;
    }
    public Node getLeftChild(){
        return this.leftChild;
    }
}
