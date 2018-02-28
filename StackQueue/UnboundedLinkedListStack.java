package csc143.data_structures;
/**
 * 
 * Class to create a unbounded stack with an underlying Linked List
 * 
 * @author Samson Haile
 * @version Standard
 * 
 * 
 */
public class UnboundedLinkedListStack implements UnboundedStack{
  
  int size;
  Node first;
  Node last;
  public UnboundedLinkedListStack(){
    size = 0;
    first = null;
    last = null;
  }
  
  /**
   * 
   * The method adds an item to the stack
   * Since this is just a simple assignment operation, O(k).
   * @param o the item we want to add to the stack
   * @throws Overfill adding the item goes over the stack capacity
   * 
   */
  public void push(Object o){
   
    
    Node newLink = new Node(o,null);
    //Special add case for when the list is empty
    if(first == null){
      first = newLink;
    }else{
      //sets the last link to the object & link given
      last.next = newLink;
    }
    //updates last link
    last = newLink;
    
    //increments size
    size = size + 1;
  }
  
  /**
   * 
   * The method removes an item from the stack
   * Since we are looping through the entire list, this is O(n).
   * @return The item we are removing from the stack
   * @throws Underempty if the stack is empty
   */
  public Object pop() throws Underempty{
    Object item;
    Node current;
    current = first;
    
    //Checks if we're trying to remove from an empty queue
    //if so, throws Underempty exception
    if(size == 0){
      throw new Underempty("You are trying to remove from an empty stack");
    }
    
    //Shifts everything down 1
    for(int i = 0; i < size -1; i++){
      current = current.next;
    }
    //saves removed item
    item = current.item;
    
    //nulls out item, removing it
    current.item = null;
    
    //decrements size
    size = size-1;
    
    return item;
    
  }
  
  /**
   * 
   * Checks if the stack isn't empty
   * Since this is a simple return operation, this is O(k).
   * @return if the stack is empty or not
   * 
   */
  public boolean isNotEmpty(){
    //obvious
    if(size > 0){
      return true;
    }
    return false;
  }
   
  /**
   * 
   * Gives you the current number of items in the stack
   * Since this is a simple return operation, this is O(k).
   * @return the number of items in the stack
   * 
   */
  public int size(){
    //obvious
    return size;
  }
  
  /**
   * 
   * Gives you back the stack as a String
   * Since we are looping through the entire list, this is O(n).
   * @return the String version of the stack
   * 
   */
  public String toString(){
    
    //Fencepost problem. We print the first item on it's own
    //so we don't have any extra commas
    String stack = "[ " + size + ": ";
    Node current = first;
    
    //loops through the list
    //appending the items to the string
    for(int i = 0; i < size -1; i++){
      stack = stack + current.item + ", ";
      current = current.next;
    }
    
    //appends the final item and the bracket
    stack = stack + current.item + " ]";
    return stack;
  }

  /**
   * 
   * 
   *Inner class that represents the nodes and links for the Linked List
   * @author Samson Haile
   * @version 1.0
   * 
   */
  public class Node {
  
    Object item;
  
    Node next;
    /**
     * 
     * Constructs a new link with the item given
     * @param item the object to be put in this node
     * @param next the connection to the next node
     * 
     */
    public Node(Object item, Node next){
      this.item = item;
      this.next = next;
    
    }
    
  }

}