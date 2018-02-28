package csc143.data_structures;
/**
 * 
 * Class to create an unbounded stack
 * 
 * @author Samson Haile
 * @version 1.0
 * 
 * 
 */
public class MyUnboundedStack implements UnboundedStack{
  
  public MyUnboundedStack(){
  }
  Object add = new Object();
  /**
   * 
   * The method adds an item to the stack
   * @param o the item we want to add to the stack
   * 
   * 
   */
  public void push(Object o){
  }
  
  /**
   * 
   * The method removes an item from the stack
   * @return The item we are removing from the stack
   * @throws Underempty if the stack is empty
   */
  public Object pop() throws Underempty{
    return add;
  }
  
  /**
   * 
   * Checks if the stack isn't empty
   * @return if the stack is empty or not
   * 
   */
  public boolean isNotEmpty(){
    return true;
  }
  
   /**
   * 
   * Gives you the current number of items in the stack
   * @return the number of items in the stack
   * 
   */
  public int size(){
    return 0;
  }
  
  /**
   * 
   * Gives you back the stack as a String
   * @return the String version of the stack
   * 
   */
  public String toString(){
    return "";
  }
}