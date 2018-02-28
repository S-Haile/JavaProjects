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
public class UnboundedArrayStack implements UnboundedStack{
  
  int size; 
  int length;
  public Object [] UbSt;
  
  public UnboundedArrayStack(){
    length = 10;
    size = 0;
    UbSt = new Object[length];
  }
  /**
   * 
   * The method adds an item to the stack
   * Since we possible cycle through the array twice, this is O(2n).
   * @param o the item we want to add to the stack
   * 
   * 
   */
  public void push(Object o){
   
    //This checks if our array is full
    //if so, we double the size
    if (size == length){
      //creates temp array and 
      //copies the values from the original
      Object[] temp = new Object[length];
      for(int i = 0; i < size; i++){
        temp[i] = UbSt[i];
      }
      
      //reassigns the values from the temp array
      //to our increased size original
      UbSt = new Object[length*2];
      for(int i = 0; i < size; i++){
        UbSt[i] = temp[i];
      }
      //increases length
      length = length*2;
    }
    //Shifts eveything up by 1
    for(int i = size - 1; i >= 0; i--){
      UbSt[i+1] = (UbSt[i]);
    }
    //Sets the first value to the given object
    UbSt[0] = (o);

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
    if(size == 0){
      throw new Underempty("You are trying to remove from an empty stack");
    }
    
    //shifts everything down 1
    Object item;
    item = UbSt[0];
    for(int i = 1; i < size; i++){
      UbSt[i-1] = (UbSt[i]);
    
    }
    
    //sets end value to null
    //otherwise we would have an extra  
    UbSt[size-1] = null;
    
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
    if(size > 0){
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
      return "[ 1 : " + UbSt[0] + " ]";
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
      stack = stack + UbSt[i] + ", ";
      i--;
    }
    
    //appends the final bracket.
    stack = stack + UbSt[0] + " ]";
    return stack;
  }
}