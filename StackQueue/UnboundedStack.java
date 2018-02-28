package csc143.data_structures;
/**
 * 
 * Interface that gives you a unbounded stack
 * 
 * @author Samson Haile
 * @version 1.0
 */
public interface UnboundedStack {
  
  /**
   * 
   * The method adds an item to the stack
   * @param o the item we want to add to the stack
   * 
   * 
   */
  public void push(Object o);
  
  /**
   * 
   * The method removes an item from the stack
   * @return The item we are removing from the stack
   * @throws Underempty if the stack is empty
   */
  public Object pop() throws Underempty;
  
  /**
   * 
   * Checks if the stack isn't empty
   * @return if the stack is empty or not
   * 
   */
  public boolean isNotEmpty();
  
   /**
   * 
   * Gives you the current number of items in the stack
   * @return the number of items in the stack
   * 
   */
  public int size();
  
  /**
   * 
   * Gives you back the stack as a String
   * @return the String version of the stack
   * 
   */
  public String toString();
}