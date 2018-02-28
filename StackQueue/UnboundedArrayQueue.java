package csc143.data_structures;
/**
 * 
 * Class to create an unbounded queue with an underlying array
 * 
 * @author Samson Haile
 * @version Standard
 * 
 * 
 */
public class UnboundedArrayQueue implements UnboundedQueue{
  
  int size; 
  int length;
  Object [] UbQu;
  
  public UnboundedArrayQueue(){
    length = 10;
    size = 0;
    UbQu = new Object[length];
  }
  /**
   * 
   * The method adds an item to the queue
   * Since we possible cycle through the array twice, this is O(2n).
   * @param o the item we want to add to the queue
   * 
   * 
   */
  public void enqueue(Object o){
    //This checks if our array is full
    //if so, we double the size
    if (size == length){
      
      //creates temp array and 
      //copies the values from the original
      Object[] temp = new Object[length];
      for(int i = 0; i < size; i++){
        temp[i] = UbQu[i];
      }
      
      //reassigns the values from the temp array
      //to our increased size original
      UbQu = new Object[length*2];
      for(int i = 0; i < size; i++){
        UbQu[i] = temp[i];
      }
      
      //increases length
      length = length*2;
    }
    
    UbQu[size] = o;
    
    //increments size
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
    if(size == 0){
      throw new Underempty("You are trying to remove from an empty queue");
    }
    
    //Saves item we are removing to be returned.
    Object item;
    item = UbQu[0];
    
    //Shifts every item down one.
    for(int i = 1; i < size; i++){
      UbQu[i-1] = UbQu[i];
    }
    
    //sets the last item to null
    //otherwise we would have an extra
    UbQu[size-1] = null;
    
    //decrements size
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
    if (size > 0){
    return true;
    }
    return false;
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
   * Since we have to cycle through the entire array, this is O(n).
   * @return the String version of the queue
   * 
   */
  public String toString(){
    
    //Fencepost problem. We print the first item on it's own
    //so we don't have any extra commas
    String stack = "[ " + size + " : " + UbQu[0];
     
    //Checks if the size equals 1
    //if so, we just print it out
    if(size == 1){
      return "[ 1 : " + UbQu[0] + " ]";
    }
   
    //Zero case
    //prints nothing beyond the size
    if (size == 0){
      return "[ 0 : ]";
    }
    
    //runs through the array
    //appending the values to the string
    for(int i = 1; i < size; i++){
      stack = stack + ", " + UbQu[i];
    }
   
    //appends the final bracket.
    stack = stack + "]";
    return stack;
  }
  
}
  