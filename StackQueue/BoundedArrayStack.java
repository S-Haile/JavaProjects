package csc143.data_structures;

/**
 * 
 * Class to create a bounded stack with an underlying array
 * 
 * @author Samson Haile
 * @version Standard
 * 
 * 
 */
public class BoundedArrayStack implements BoundedStack{
  int size; 
  int length;
  Object [] BoSt;
  
  public BoundedArrayStack(int i){
    length = i;
    size = 0;
    BoSt = new Object[i];
  }
  
  /**
   * 
   * The method adds an item to the stack
   * Since we have to cycle through the entire array, this is O(n).
   * @param o the item we want to add to the stack
   * @throws Overfill adding the item goes over the stack capacity
   * 
   */
  public void push(Object o) throws Overfill {
    
    //Checks if we are trying to add to a full stack
    //if so, we throw the Overfill exception.
    if(size == length){
      throw new Overfill("You are trying to add to a full stack");
    }
    
    //Shifts eveything up by 1
    for(int i = size - 1; i >= 0; i--){
      BoSt[i+1] = (BoSt[i]);
    }
    
    //Sets the first value to the given object
    BoSt[0] = (o);
    
    //increment this size
    size = size + 1;
    
    
  }
  
  /**
   * 
   * The method removes an item from the stack
   * Since we have to cycle through the entire array, this is O(n).
   * @return The item we are removing from the stack
   * @throws Underempty if the stack is empty
   */
  public Object pop() throws Underempty{
    //Checks if we're trying to remove from an empty queue
    //if so, throws Underempty exception
    if(size < 0){
      throw new Underempty("You are trying to remove from an empty stack");
    }
    //shifts everything down 1
    Object item;
    item = BoSt[0];
    for(int i = 1; i < size; i++){
      BoSt[i-1] = (BoSt[i]);
    
    }
    
    //sets end value to null
    //otherwise we would have an extra
    BoSt[size-1] = null;
    
    //decrements size
    size = size - 1;
    return item;
    
    
  }
  
  /**
   * 
   * Checks if the stack isn't empty
   * Since this is a simple return operation, this would be O(k).
   * @return if the stack is empty or not
   * 
   */
  public boolean isNotEmpty(){
    
    //obvious
    if (size > 0){
      return true;
    }
    return false;
  }
  /**
   * 
   * Checks if the stack isn't full
   * Since this is a simple return operation, this would be O(k).
   * @return if the stack is full or not
   * 
   */
  public boolean isNotFull(){
    
    //obvious
    if(size != length){
      return true;
    }
    return false;
  }
  /**
   * 
   * Gives you the current number of items in the stack
   * Since this is a simple return operation, this would be O(k).
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
   * Since we have to cycle through the entire array, this is O(n).
   * @return the String version of the stack
   * 
   */
  public String toString(){
    //Fencepost problem. We print the first item on it's own
    //so we don't have any extra commas
    String stack = "[ " + size + ": ";
    
    //Checks if the size equals 1
    //if so, we just print it out
    if(size == 1){
      return "[ 1 : " + BoSt[0] + " ]";
    }
    
    //Zero case
    //prints nothing beyond the size
    if (size == 0){
      return "[ 0 : ]";
    }
    
    //runs through the array
    //appending the values to the string
    int i = size-1;
    while(i > 0){
      stack = stack + BoSt[i] + ", ";
      i--;
    }
    //appends the final bracket.
    stack = stack + BoSt[0] + " ]";
    return stack;
  }
 
  /**
   * 
   * Gives you back the total number of items the queue can hold
   * Since this is a simple return operation, this would be O(k).
   * @return the total number of items the queue can hold
   * 
   */
  public int capacity(){
    //obvious
    return length;
  }
}
  