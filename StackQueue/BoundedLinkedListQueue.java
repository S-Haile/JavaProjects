package csc143.data_structures;
/**
 * 
 * Class to create a bounded queue with an underlying Linked List
 * 
 * @author Samson Haile
 * @version Standard
 * 
 * 
 */
public class BoundedLinkedListQueue implements BoundedQueue{
  
  int size;
  int length;
  Node first;
  Node last;
  
  public BoundedLinkedListQueue(int i){
    int size = 0;
    length = i;
    first = null;
    last = null;
  }
  
  /**
   * 
   * The method adds an item to the queue
   * Since this is just a simple assignment operation, this would be big O(k).
   * @param o the item we want to add to the queue
   * @throws Overfill adding the item goes over the queue capacity
   * 
   */
  public void enqueue(Object o) throws Overfill{
     
    //Checks if we are trying to add to a full queue
    //if so, we throw the Overfill exception.
    if(size == length){
      throw new Overfill ("You are trying to add to a full queue.");
    }
    Node newLink = new Node(o,null);
   
    //Special add case for when the list is empty
    if(first == null){
      first = newLink;
    }else{
     
      //checks for the item at the end of the list
      //and sets it to the desired value
      first = new Node(o,first);
     
      if(last == null){
        last = first;
       
      }
    }
    //updates last link
    last = newLink;
    
    //increment size
    size = size + 1;
  }
  
  /**
   * 
   * The method removes an item from the queue
   * Since we have to cycle through the entire list, this is O(n).
   * @return The item we are removing from the queue
   * @throws Underempty if the queue is empty
   */
  public Object dequeue() throws Underempty{
    Object item;
    Node current;
    current = first;
    
    //Checks if we're trying to remove from an empty queue
    //if so, throws Underempty exception
    if(size < 0){
      throw new Underempty("You are trying to remove from an empty stack");
    }
    
    //Shifts everything down 1
    for(int i = 0; i < size -1; i++){
      current = current.next;
    }
    
    //saves item we're removing
    item = current.item;
    
    //nulls out item, removing it
    current.item = null;
    
    //decrements size
    size = size-1;
    return item;
    
  }
  
  /**
   * 
   * Checks if the queue isn't empty
   * Since this is just a simple return operation, this would be O(k).
   * @return if the queue is empty or not
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
   * Checks if the queue isn't full
   * Since this is just a simple return operation, this would be O(k).
   * @return if the queue is full or not
   * 
   */
  public boolean isNotFull(){
    //obvious
    if (size < length){
      return true;
    }
    return false;
  }
  /**
   * 
   * Gives you current number of items in the queue
   * Since this is just a simple return operation, this would be O(k).
   * @return the current number of items in the queue
   * 
   */
  public int size(){
    //obvious
    return size;
  }
  
  /**
   * 
   * Gives you back the queue as a String
   * Since we are looping through the entire list, this is O(n).
   * @return the String version of the queue
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
   * Gives you back the total number of items the queue can hold
   * since this is a simple return operation, this is O(k).
   * @return the total number of items the queue can hold
   * 
   */
  public int capacity(){
    //obvious
    return length;
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
