package csc143.data_structures;
/**
 * 
 * Class to create a bounded queue with an underlying array
 * 
 * @author Samson Haile
 * @version Standard
 * 
 * 
 */
public class BoundedArrayQueue implements BoundedQueue{
  
  int size; 
  int length;
  Object [] BoQu;
  public BoundedArrayQueue(int i){
    size = 0;
    length = i;
    BoQu = new Object[i];
    
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
      throw new Overfill ("You are trying to add to an full queue.");
    }
    //adds to the end of the queue
    BoQu[size] = o;
    
    //increments the size
    size = size + 1;
  }
  
  /**
   * 
   * The method removes an item from the queue
   * Since we have to cycle through the entire array, this is O(n).
   * @return The item we are removing from the queue
   * @throws Underempty if the queue is empty
   */
  
  public Object dequeue() throws Underempty{
    
    //Checks if we're trying to remove from an empty queue
    //if so, throws Underempty exception
    if(size < 0){
      throw new Underempty("You are trying to remove from an empty queue");
    }
    
    //saving the item we are removing so it can be returned.
    Object item;
    item = BoQu[0];
    
    //Shifts every item one down
    for(int i = 1; i < size; i++){
      BoQu[i-1] = BoQu[i];
    }
    
    //sets the last item to null
    //otherwise we would have an extra
    BoQu[size-1] = null;
    
    //decrements the size
    size = size -1;
    
    return item;
  }
  
  /**
   * 
   * Checks if the queue isn't empty
   * Since this is a simple return operation, this would be O(k).
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
   * Since this is a simple return operation, this would be O(k).
   * @return if the queue is full or not
   * 
   */
  public boolean isNotFull(){
    
    //obvious
    if(size == length){
      return false;
    }
    return true;
  }
  
  /**
   * 
   * Gives you current number of items in the queue
   * Since this is a simple return operation, this would be O(k).
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
   * Since we have to cycle through the entire array, this would be O(n).
   * @return the String version of the queue
   * 
   */
  public String toString(){
    //Fencepost problem. We print the first item on it's own
    //so we don't have any extra commas
    String stack = "[ " + size + " : " + BoQu[0];
   
   //Checks if the size equals 1
   //if so, we just print it out
    if(size == 1){
      return "[ 1 : " + BoQu[0] + " ]";
    }
   
   //Zero case
   //prints nothing beyond the size
    if (size == 0){
      return "[ 0 : ]";
    }
    //runs through the array
    //appending the values to the string
    for(int i = 1; i < size; i++){
      stack = stack + ", " + BoQu[i];
    }
   
    //appends the final bracket.
    stack = stack + " ]";
    return stack;
  }
  
  
  /**
   * 
   * Gives you back the total number of items the queue can hold
   * Since this is a simple return operation, this would be O(k).
   * @return the total number of items the queue can hold
   * 
   * 
   */
  public int capacity(){
    
    //obvious
    return length;
  }
 
}